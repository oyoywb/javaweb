package calculate;

import java.util.Scanner;

public class Loading {

	static int n ;
	static int []w;
	static int c;
	static int cw;
	static int bestw;
	static int r;
	static int[]x;
	static int[] bestx;
	static boolean found = false;
	static int index;
	
	public static int maxLoading(int[]ww ,int cc,int []xx) {
		n = ww.length -1 ;
		w = ww;
		c = cc;
		cw = 0;
		bestw = 0;
		r = 0;
		x = new int[n+1];
		bestx = xx;
		index = 0;
		
		for(int i=1;i<=n;i++) 
			r += w[i];
		
		backtrack(1);
		
		for(int j=1;j<=n;j++) {
			bestw += bestx[j]*w[j];
		}
		return bestw;
		
	}
		
	private static void backtrack(int i) {
		if(i>n) {index=n;bestw=cw;return;}
		r -= w[i];
		if(cw+w[i]<=c) {
			x[i]=1;cw+=w[i];
			backtrack(i+1);
			if(index==i) {bestx[index]=1;index--;}
			cw -= w[i];
		}
		if(cw+r>bestw) {
			x[i]=0;
			backtrack(i+1);
			if(index==i) {bestx[index]=0;index--;}
		}
		r += w[i];
		
	}

	public static void main(String[] args) {
		
		System.out.println("请输入第一艘船的载重");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int cc = input.nextInt();
		System.out.println("请输箱子的数量");
		int count = input.nextInt();
		int ww[] = new int[count+1];
		ww[0] = 0;
		System.out.println("请以此输入箱子的重量");
		for(int i=1;i<count+1;i++) {
			ww[i] = input.nextInt();
		}
		
		int []x = new int[count+1];
		
		int a = maxLoading(ww,cc,x);
		System.out.println("第一艘船载重"+a+"  ");
		int c1=0;
		for(int i=1;i<count+1;i++) {
			if(Loading.bestx[i] ==0) 
				 c1 += Loading.w[i]; 
		}
		int c2=0;
		for(int i=1;i<count+1;i++) {
			if(Loading.bestx[i] == 1) {
				c2 = Loading.w[i]; 
				System.out.print("装重量为"+c2+"的箱子   ");
			}
		}
		System.out.println();
		System.out.println("第二艘船载重"+c1);
		
			
		System.out.println("最优解bestx：");
		for(int i=1;i<count+1;i++) {
			System.out.print(Loading.bestx[i]+" ");
		}
	}
}
