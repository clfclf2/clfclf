package test1;
import java.util.Scanner;

public class Testmatin {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		double a = sc.nextInt();
		char c = sc.next().charAt(0);
		double b = sc.nextInt();
		double result=0;
		
		if(c =='*')
		{
			result=a*b;
		}
		
		else if (c=='+')
		{
			result=a+b;	
		}
		else if (c=='-')
		{
			result=a-b;
			
		}
		else if (c=='/')
		{
			result= a/b;
			
		}
		else
		{
			result=a%b;
		}
		
		System.out.print(a+" "+c+" "+b + " = " + result);
		
		sc.close();
		
	}
     
	
}
