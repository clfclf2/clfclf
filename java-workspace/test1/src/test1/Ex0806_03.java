package test1;
import java.util.Scanner;

public class Ex0806_03 {

	public static void main(String[] args) {
		int[] n= {5,1,2,4,3};
		
		
		for(int i=0; i<n.length; i++) {
			System.out.println("["+ i+"] = " +n[i]);
		}
		
		n[1]=7;
		n[4]=8;
		System.out.println();
		
		for(int i=0; i<n.length; i++) {
			System.out.println("["+ i+"] = " +n[i]);
			
		}
	}

}
