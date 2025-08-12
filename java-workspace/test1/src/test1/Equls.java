package test1;
import java.util.Random;
import java.util.Scanner;

public class Equls {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		System.out.print("무엇을 낼 지 선택하세요 (가위,바위,보)");
		String a = sc.next();
		
		Random random = new Random();
		random.setSeed(System.currentTimeMillis());
		int num = random.nextInt(3);
		num++;
		String com;
		int me;
		
		if(a.equals("가위")) {
			me= 1;
		}
		else if (a.equals("바위")) {
			me=2;
		}
		else {
			me=3;
		}
		
		if(me==1)
		{
			System.out.print(" 나:가위(1)");
			if(num==1) {
				System.out.println(" 컴퓨터:가위(1)");
				System.out.println(" 비겼습니다.");
			}
			else if(num==2){
				System.out.println(" 컴퓨터:주먹(2)");
				System.out.println(" 당신이 졌습니다.");
			}
			else {
				System.out.println(" 컴퓨터:보(3)");
				System.out.println(" 당신이 이겼습니다.");
			}
		}
		if(me==2)
		{
			System.out.print(" 나:바위(2)");
			if(num==1) {
				System.out.println(" 컴퓨터:가위(1)");
				System.out.println(" 이겼습니다.");
			}
			else if(num==2){
				System.out.println(" 컴퓨터:주먹(2)");
				System.out.println(" 비겼습니다.");
			}
			else {
				System.out.println("컴퓨터:보(3)");
				System.out.println("당신이 졌습니다.");
			}
		}
		if(me==3)
		{
			System.out.print(" 나:보(3)");
			if(num==1) {
				System.out.print(" 컴퓨터:가위(1)");
				System.out.print(" 졌습니다.");
			}
			else if(num==2){
				System.out.print(" 컴퓨터:주먹(2)");
				System.out.print(" 당신이 이겼습니다.");
			}
			else {
				System.out.print(" 컴퓨터:보(3)");
				System.out.print(" 비겼습니다.");
			}
		}
	}
	

}
