package test1;
import java.util.Scanner;

public class Ex_0807 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("정수를 5개 입력하세오");
		int sum =0;
		
		for(int i=0; i<5; i++) {
			int num = scanner.nextInt();
		
			if(num<=0) {
				continue;
			}
			else {
				sum += num;
			}
		}
		
		System.out.print("양수의 합은: " +sum);
		
		scanner.close();
	}
}
