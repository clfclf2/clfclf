package test2;

public class NumStar2 {

	public static void main(String[] args) {
		
		int [] n = {5,3,1,2,4};
		for(int i=0; i<n.length; i++ ) {
			
			for(int j=0; j<n.length; j++) {
				if(n[j]>=n[i]) {
				System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			}
			
			System.out.println();
			
		}
		
		System.out.println(" ");

	}

}
