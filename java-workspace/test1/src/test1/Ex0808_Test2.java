package test1;
import java.util.Scanner;

public class Ex0808_Test2 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int score[][] = new int [3][3];
		int asum=0;
		int avg=0;
		int sum[]=new int[score.length];
		int gsum[]=new int[score[0].length];
		
		// 처리
		for(int i=0; i<score.length; i++) {
			System.out.print("점수를 입력하세요: ");
			
			for(int j=0; j<score[i].length; j++) {
				score[i][j] = scanner.nextInt();
				
				sum[i]+=score[i][j];
				
				gsum[j]+=score[i][j];
				
				asum+=score[i][j];
			}
			
			
		}
		
		//출력
		System.out.println("번호\t국어\t영어\t수학\t총점\t평균");
		
		for(int i=0; i<score.length; i++) {
			System.out.print(i+1);
			for(int j=0; j<score[i].length; j++) {
				System.out.print("\t");
				System.out.print(score[i][j]);
			}
			System.out.print("\t");
			System.out.print(sum[i]);
			System.out.print("\t");
			System.out.print(String.format("%.2f",(double)sum[i]/score.length));
			System.out.println();
		}
		
		//합 
		
		System.out.print("합: \t");
		
		for(int i=0; i<gsum.length; i++) {
			System.out.print(gsum[i]+"\t");
		}
		System.out.print(asum+"\t");
		System.out.println(String.format("%.2f",(double)asum/score.length));
		scanner.close();
	}
}