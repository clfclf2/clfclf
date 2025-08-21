package test3;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class NewClass {

	int count = 0;

	ArrayList<Student> stu = new ArrayList<Student>();

	// 선택
	public void getMenu() {
		System.out.println("┌─성적 관리 프로그램─┐");
		System.out.println("1.입력");
		System.out.println("2.출력");
		System.out.println("3.수정");
		System.out.println("4.삭제");
		System.out.println("5.검색");
		System.out.println("6.출력2");
		System.out.println("7.세이브");
		System.out.println("8.저장 값 불러오기");
		System.out.println("0.프로그램 종료");
		System.out.println("└────────────────┘");
		System.out.print("선택 : ");

	}

	public void getInput(Scanner sc) {

		// 1.입력

		/*if (count >= stu.size()) {
			System.out.println("더 이상 입력할 수 없습니다.");
			return;
		} */
		
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("국어 : ");
		int kor = sc.nextInt();
		System.out.print("영어 : ");
		int eng = sc.nextInt();
		System.out.print("수학 : ");
		int mat = sc.nextInt();
		System.out.println("입력이 완료되었습니다.");

		stu.add(new Student(name, kor, eng, mat));

	}

	// 2. 출력

	public void printStu(Scanner sc) {
		System.out.println("번호\t이름\t국어\t영어\t수학\t총합\t평균");
		for (int i = 0; i < stu.size(); i++) {

			stu.get(i).sPrint(i);
			
		}
	}

	// 3. 수정
	public void updateStu(Scanner sc) {
		System.out.print("수정할 번호 입력: ");
		int idx = sc.nextInt() - 1;
		if (stu.get(idx) == null) {
			System.out.println("빈 번호입니다.");
			return;
		}
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("국어 : ");
		int kor = sc.nextInt();
		System.out.print("영어 : ");
		int eng = sc.nextInt();
		System.out.print("수학 : ");
		int math = sc.nextInt();
		stu.set(idx, new Student(name, kor, eng, math));
		System.out.println("수정 완료!");
	}

	// 4. 삭제
	public void deleteStu(Scanner sc) {
		System.out.print("삭제할 번호 입력: ");
		int idx = sc.nextInt() - 1;
		if (stu.get(idx) == null) {
			System.out.println("빈 번호입니다.");
			return;
		}
		stu.remove(idx);
		System.out.println("삭제 완료");
	}

	// 5. 검색
	public void searchStu(Scanner sc) {
		System.out.print("검색할 이름 입력: ");
		String name = sc.next();
		boolean found = false;
		for (int i = 0; i < stu.size(); i++) {
			if (stu.get(i).name.contains(name)) {
				System.out.println("번호\t이름\t국어\t영어\t수학\t총합\t평균");
				stu.get(i).sPrint(i);
				found = true;
			}
		}
		if (!found) {
			System.out.println("검색 결과 없음.");
		}
	}

	// 6. 정렬 출력
	public void printSort() {
		int n = stu.size();
		Student[] copy = new Student[n];
		int c = 0;

		for (int i = 0; i < c-1; i++) {
			for (int j = 0; j < c - 1; j++) {
				if (copy[j].tot() < copy[j + 1].tot()) {
					Student tmp = copy[j];
					copy[j] = copy[j + 1];
					copy[j + 1] = tmp;
				}
			}
		}
		System.out.println("번호\t이름\t국어\t영어\t수학\t총합\t평균");
		for (int i = 0; i < c; i++) {
			copy[i].sPrint(i);
		}
	}

	// 7. 저장
	public void saveStu() {
		String filePath = "E:\\java-workspace\\save.txt";
		try {
			BufferedWriter w = new BufferedWriter(new FileWriter(filePath));
			for (int i = 0; i < count; i++) {
				if (stu.get(i) == null)
					continue;
				w.write(stu.get(i).name + "\t" + stu.get(i).kor + "\t" + stu.get(i).eng + "\t" + stu.get(i).tot());
				w.newLine();
			}
			w.close();
			System.out.println("저장 완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 8. 불러오기
	public void loadStu() {
		String filePath = "E:\\java-workspace\\save.txt";
		try {
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			String line;

			while ((line = br.readLine()) != null) {
				String[] parts = line.split("\t");
				if (parts.length == 4) {
					for (int i = 0; i < stu.size(); i++) {
						stu.get(i);					
						}
				}
			}
			br.close();
			System.out.println("불러오기 성공");
		} catch (Exception e) {
			System.out.println("불러오기 실패");
		}
	}
}
