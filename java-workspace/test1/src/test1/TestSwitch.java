package test1;

import java.util.Scanner;

public class TestSwitch {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("무슨 커피를 드릴까요? ");
		String order = scanner.next();
		int price=0;
		switch(order) {
		case "에스프레소" :
		case "카푸치노" :
		case "카페라뗴" :
			price = 3500;
			}
	}

}
