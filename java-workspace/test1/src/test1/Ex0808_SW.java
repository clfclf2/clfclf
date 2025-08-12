package test1;

public class Ex0808_SW {

	public static void main(String[] args) {
		
		int  [] n  = {5,1,3,2,4,10,11,12,13,14,15};
		int swap;
		
		
		for(int i=0; i<n.length; i++) {
			for(int j=0; j<n.length-1; j++) {
				if(n[j]>n[j+1]) {
					
					swap=n[j];
					n[j]=n[j+1];
					n[j+1]=swap;
				}	
			}	
		}
		for(int k=0; k<n.length; k++) {
			System.out.print(n[k]+" ");
		}
	}

}
