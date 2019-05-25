package calculate;

public class Prim {
	public static void prim(int n ,float[][]c) {
		float []lowcost = new float[n+1];
		int[] closet = new int[n+1];
		boolean []s = new boolean[n+1];
		
		s[1] = true;
		for(int i=2;i<=n;i++) {
			lowcost[i] = c[1][i];
			closet[i] = 1;
			s[i] = false;
		}
		
		for(int i=1;i<n;i++) {
			float min = Float.MAX_VALUE;
			int j = 1;
			for(int k =2;k<=n;k++) {
				if((lowcost[k]<min)&&(!s[k])) {
					min = lowcost[k];
					j = k;
				}
			}
			System.out.println(closet[j]+" ,"+j);
			s[j] = true;			
			for(int k =2;k<=n;k++) 
				if((c[j][k]<lowcost[k])&&(!s[k])) {
					lowcost[k] = c[j][k];
					closet[k] = j;
				}	
		}
	}
	public static void main(String[] args) {
		float [][]c ;
		int n =6;
		c = new float[][]{
			{0,0,0,0,0,0,0},
			{0,99,6,1,5,7,5},
			{0,6,99,5,10,3,9},
			{0,1,5,99,5,6,4},
			{0,5,10,5,99,8,2},
			{0,7,3,6,8,99,6},
			{0,5,9,4,2,6,99}
		};
		prim(n,c);
	}
	
	
}
