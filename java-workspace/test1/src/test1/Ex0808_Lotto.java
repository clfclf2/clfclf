package test1;
import java.util.Random;

public class Ex0808_Lotto {

	public static void main(String[] args) {
		
		Random random = new Random();
		int [ ]n = new int[5];
		int swap=0;
		
		//로또 번호 뽑기 
	
		for(int i=0; i<n.length; i++) {
			int num= random.nextInt(45)+1;
			
			//중복제거
			for(int j=0; j<i; j++) {
				if(n[j]==num) {
					num= random.nextInt(45)+1;
					j=-1;
				}
			}
			
			n[i]=num;
		}
	
			
		// 정렬
		for(int i=0; i<n.length-1; i++) {
			for(int j=0; j<n.length-1; j++) {
				if(n[j]>n[j+1]) {
					
					swap=n[j];
					n[j]=n[j+1];
					n[j+1]=swap;
				}	
			}	
		}
		
		//출력 
		System.out.print("로또 번호 : " );
		for(int k=0; k<n.length; k++) {
			System.out.print(n[k]+" ");
			}
		}
   }

 
 

