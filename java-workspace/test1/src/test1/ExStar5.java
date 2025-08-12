package test1;

public class ExStar5 {

	public static void main(String[] args) {
		
		int i,j;
		int k;
		int count;
		int num=10;
		
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


//if(num%2==0) {
//num-=1;
//}
