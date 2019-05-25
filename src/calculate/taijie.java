package calculate;

public class taijie {
	
	public static void count() {
		int []m = new int[100];
		m[0] = 0;
		m[1]  = 1;
		m[2] = 2;
		
		int n = 5;
		for(int i = 3;i <= n;i++) {
			m[i] = m[i-1] + m[i-2];
		}
		
		System.out.println(m[n]);
	}
	
	public  static  void main(String[] args) {
		count();
	}
}
