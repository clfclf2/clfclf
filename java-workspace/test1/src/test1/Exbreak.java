package test1;



public class Exbreak {
	public static void main(String[] args) {
				
		int i,j,k;
		
		
		  for(i=1; i<10; i++) {
			for(k=0; k<10-i; k++) {
				System.out.print(" ");
			}
			
			for(j=0; j<i; j++) {
				System.out.print("*");
				// System.out.print('\t');
			}
			
			System.out.println();
		}
		 
		
		/*
		for(i=0; i<10; i++) {
			for(j=10; j>i; j--) {
				System.out.print("*");
				
			}
			
			System.out.println();
		}
		*/
		
		  /*
		int num =0;
		
		for(i=0; i<5; i--) {
			
			System.out.print(" ");
			for(j=0; j<i; j++) {
				System.out.print("*");
			
				
			}
		}
		System.out.println();
		*/
	}
}  
