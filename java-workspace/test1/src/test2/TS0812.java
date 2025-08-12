package test2;

public class TS0812 {
	
	public static int add (int a, int b) {
		int result= a+b;
		return result;
	}
	
	public static int cha(int a, int b) {
		int result= a+b;
		return result;
	}
	
	public static float div(int a, int b) {
		float result= (float) a/b;
		return result;
	}
	public static int mul(int a, int b) {
		int result= a*b;
		return result;
	}
	
	
	
	public static void main(String[] args) {
		int a = add(1,2);
		int b = cha(4,2);
		float c = div(8,3);
		int d = mul(3,4);
		
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(String.format("%.2f", c ));
		System.out.println(d);
	}
}
