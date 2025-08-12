package test1;

public class Ex0808_Test {
	public static void main(String[] args) {
		
		int arr[][] ={{1,2,3}, {4,5,6}};
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				
				System.out.print(" ["+i+"]"+ "[" +j+ "] = " + arr[i][j]);
			}
			System.out.println();
		}
		
		arr[0][1]= 7;
		arr[1][2]= 8;
		System.out.println();
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				
				System.out.print(" ["+i+"]"+ "[" +j+ "] = " + arr[i][j]);
			}
			System.out.println();
		}
		
	}
}
