package test1;
import java.util.Scanner;

public class Ex_Array {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("받으실 정수 개수:");
		int num = scanner.nextInt();
		int intArray[] = new int[num];
		int sum=0;
		System.out.print("양수"+num+"개를 입력하세요:");
		
		for(int i=0; i<num; i++) {
			
			intArray[i] = scanner.nextInt();
			
			sum+=intArray[i];
		}
		
		System.out.print("평균은: "+(double)sum/intArray.length);
		
		scanner.close();
	}

}
