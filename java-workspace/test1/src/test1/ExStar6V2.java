package test1;

public class ExStar6V2{

	public static void main(String[] args) {

		int i,j;
		int k;
		int count;
		int num=10;
		
		count = num;
		
		  for(i=0; i<num; i++) {
			  
		//	  if() {
				  for(k=count-1; k>0; k--) {
					  System.out.print(" ");
				  }
				  for(j=0; j<(i*2)+1; j++) {
					  System.out.print("*");
				  }
			  }	  
			  count--;
			  System.out.println();
		}
	}

