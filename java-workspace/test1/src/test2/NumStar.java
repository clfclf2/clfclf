package test2;

public class NumStar {

	public static void main(String[] args) {
		
		int [] n = {5,3,1,2,4};
		
		for(int i=0; i< n.length; i++ ) {
			
			System.out.print(n[i]+" ");
			for(int j=0; j<n[i]; j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
	}
}
