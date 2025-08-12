package test1;
import java.util.Scanner;

public class _0808_Ex1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int intArray[] = new int[5];
		int max=0;
	
		for(int i=0; i<5; i++) {
			int num = scanner.nextInt();
			intArray[i]=num;
			
			if(intArray[i]>max) {
				max=intArray[i];
			}
		}
		
		System.out.print("가장 큰 수는: "+max);
		
		scanner.close();
	}

}
