package test1;

import java.util.Random;
import java.util.Scanner;

public class Test0806 {
	public static void main(String[] args) {
			
		Scanner scanner = new Scanner(System.in);
		System.out.print("가위(1) 바위(2) 보(3)를 입력하시오: ");
		int me = scanner.nextInt();
		
		Random random = new Random();
		random.setSeed(System.currentTimeMillis());
		int num = random.nextInt(3);
		num++;
		
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
		
		
		scanner.close();
	}
}
