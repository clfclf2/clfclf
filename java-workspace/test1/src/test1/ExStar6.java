package test1;

public class ExStar6 {

	public static void main(String[] args) {
		
		int i,j;
		int k;
		int count;
		int num=30; // 표시할 줄 개수
		
		count = num; 
		
		 for(i=0; i<num-1; i++) {
			  
			  for(k=count-1; k>0; k--) {
				  System.out.print(" ");
			  }
			  for(j=0; j<(i*2)+1; j++) {
				  System.out.print("*");
			  }
				  
			  count--;
			  System.out.println();
		 }
		 
		 count = (2*num)-1;
			
		  for(i=0; i<num; i++) {
			  
			  for(k=0; k<i; k++) {
				  System.out.print(" ");
			  }
			  for(j=count; j>0; j--) {
				  System.out.print("*");
			  }
				  
			  count-=2;
			  System.out.println();
		}

	}

}
