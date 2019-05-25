package calculate;
import java.util.ArrayList;
import java.util.Scanner;

public class Kruskal1{
	
	boolean[] root;
	int[] parent;
	int currentSize = 0;
	int maxSize = 0;
	EdgeNode[] minHeap = new EdgeNode[20];
	
	public void initialize(int verNum) {
		root = new boolean[verNum+1];
		parent = new int[verNum+1];
		
		for(int vertex=1;vertex<=verNum;vertex++) {
			parent[vertex] = 1;
			root[vertex] = true;
		}
	}
	
	public int find(int vertex) {
		while(!root[vertex]) {
			vertex = parent[vertex];
		}
		return vertex;
	}
	
	public void union(int i,int j) {
		if(parent[i] < parent[j]) {
			parent[j] += parent[i];
			root[i] = false;
			parent[i]=j;
		}else {
			parent[i]+= parent[j];
			root[j] = false;
			parent[j] = i;
		}
	}
	
	public void createMinHeap(EdgeNode[] edgeNode) {
		currentSize = edgeNode.length;
		maxSize = minHeap.length;
		if(currentSize >= maxSize) {
			maxSize *= 2;
			minHeap = new EdgeNode[maxSize];
		}
		for(int i=0;i<currentSize;i++) {
			minHeap[i+1] = edgeNode[i];
		}
		int y,c;
		for(int i = currentSize/2;i>=1;i--) {
			EdgeNode node = minHeap[i];
			y = node.weight;
			c = 2*i;
			while(c < currentSize) {
				if(c <= currentSize && minHeap[c].weight >minHeap[c+1].weight)
					c++;
				if(minHeap[c].weight >= y)
					break;
				minHeap[c/2] = minHeap[c];
				c = c*2;
			}
			minHeap[c/2] = node;
		}
	}
	
	public EdgeNode deleteMinheap() {
		if(currentSize <1)
			System.out.println("堆已经为空！无法执行删除");
		EdgeNode node = minHeap[1];
		minHeap[1] = minHeap[currentSize];
		currentSize -= 1;
		
		int c=2,j=1;
		EdgeNode node1 = minHeap[currentSize+1];
		while(c<=currentSize) {
			if(c<currentSize && minHeap[c].weight>minHeap[c+1].weight)
				c++;
			if(node1.weight <= minHeap[c].weight)
				break;
			minHeap[j] = minHeap[c];
			j = c;
			c = c*2;
		}
		minHeap[j] = node1;
		return node;
	}
	
	
	public void minSpanningTree(int[] verArray,EdgeNode[] edgeNode) {
		ArrayList<EdgeNode> nodeList = new ArrayList<EdgeNode>();
		
		initialize(verArray.length);
		createMinHeap(edgeNode);
		for(int i=1;i<currentSize;i++) {
			System.out.println(minHeap[i].u+" "+minHeap[i].v+" "+minHeap[i].weight);
		}
		
		for(int i =0;i<edgeNode.length;i++) {
			EdgeNode node = deleteMinheap();
			int jRoot = find(node.u);
			int kRoot = find(node.v);
			if(jRoot != kRoot) {
				nodeList.add(node);
				union(jRoot,kRoot);
			}
		}
			
		System.out.println("使用kruskal算法得到图的最小生成树为：" );
		for(int i=0;i<nodeList.size();i++) {
			System.out.println(nodeList.get(i).u+""+nodeList.get(i).v+" "+nodeList.get(i).weight);
		}
	}
	
	public static void main(String[] args) {
		System.out.println("请输入图的顶点数和边数");
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int verNum  = scan.nextInt();
		int edgeNum  = scan.nextInt();
		
		int [] verArray = new int [verNum];
		System.out.println("请依次输入顶点");
		for(int i=0;i<verNum;i++) {
			int vertex = scan.nextInt();
			verArray[i] = vertex;
		}
		EdgeNode[] edgeNode = new EdgeNode[edgeNum];
		System.out.println("请依次输入边的顶点和权重");
		for(int i=0;i<verNum;i++) {
			int u = scan.nextInt();
			int v = scan.nextInt();
			int weight = scan.nextInt();
			EdgeNode node = new EdgeNode();
			node.u = u;
			node.v = v;
			node.weight = weight;
			edgeNode[i] = node;
		}
		
		Kruskal1 kruskal = new Kruskal1();
		kruskal.minSpanningTree(verArray,edgeNode);
	}
}