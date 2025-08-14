package test2;

import java.io.*;
import java.util.Scanner;

public class Grade3 {
	// 메뉴 선택
	public static void getMenu() {
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

	// 1.입력
	public static int getInput(int count, int[][] sc, String[] name, Scanner scanner) {
		if (count >= sc.length) {
			System.out.println("더 이상 입력할 수 없습니다.");
			return count;
		}
		System.out.print("이름 : ");
		name[count] = scanner.next();
		System.out.print("국어 : ");
		sc[count][0] = scanner.nextInt();
		System.out.print("영어 : ");
		sc[count][1] = scanner.nextInt();
		System.out.print("수학 : ");
		sc[count][2] = scanner.nextInt();
		System.out.println("입력이 완료되었습니다.");
		return ++count;
	}

	// 2.출력
	public static void getPrint(int count, int[][] sc, String[] name, int[] sum) {
		System.out.println("번호\t이름\t국어\t영어\t수학\t총합\t평균");
		for (int i = 0; i < count; i++) {
			if (name[i] == null)
				continue;

			System.out.print((i + 1) + "번\t");
			System.out.print(name[i] + "\t");
			sum[i] = 0;

			for (int j = 0; j < sc[i].length; j++) {
				System.out.print(sc[i][j] + "\t");
				sum[i] += sc[i][j];
			}
			System.out.print(sum[i] + "\t");
			System.out.println(sum[i] / 3);
		}
		System.out.println("출력이 완료되었습니다.");
	}

	// 3.수정
	public static void getUpdate(int count, int[][] sc, String[] name, Scanner scanner) {
		System.out.print("수정하실 번호를 입력하세요 : ");
		int fix = scanner.nextInt() - 1;

		if (fix < 0 || fix >= count || name[fix] == null) {
			System.out.println("비어있습니다. 다시 선택하세요.");
		} else {
			System.out.print("이름 : ");
			name[fix] = scanner.next();
			System.out.print("국어 : ");
			sc[fix][0] = scanner.nextInt();
			System.out.print("영어 : ");
			sc[fix][1] = scanner.nextInt();
			System.out.print("수학 : ");
			sc[fix][2] = scanner.nextInt();
			System.out.println("수정이 완료되었습니다.");
		}
	}

	// 4.삭제
	public static void getDelete(int count, int[][] sc, String[] name, Scanner scanner) {
		System.out.print("삭제하실 번호를 입력하세요 : ");
		int del = scanner.nextInt() - 1;
		if (del < 0 || del >= count || name[del] == null) {
			System.out.println("잘못된 번호입니다. 다시 선택하세요");
		} else {
			name[del] = null;
			sc[del] = new int[3];
			System.out.println("삭제가 완료되었습니다.");
		}
	}

	// 5.검색
	public static void getSearch(int count, int[][] sc, String[] name, Scanner scanner) {
		System.out.print("검색하실 이름을 입력하세요 : ");
		String sel = scanner.next();
		boolean found = false;
		int ssum;

		for (int i = 0; i < name.length; i++) {
			if (sel.equals(name[i])) {
				found = true;
				System.out.println("번호\t이름\t국어\t영어\t수학\t총합\t평균");
				System.out.print((i + 1) + "\t");
				System.out.print(name[i] + "\t");
				for (int j = 0; j < sc[i].length; j++) {
					System.out.print(sc[i][j] + "\t");
				}
				ssum = sc[i][0] + sc[i][1] + sc[i][0];
				System.out.print(ssum + "\t");
				System.out.println(ssum / 3);
				
			}
		}
		System.out.println("검색이 완료되었습니다.");
		if (found != true) {
			System.out.println("값이 없습니다.");
		}
	}

	// 6.출력2(정렬)
	public static void getPrint2(int count, int[][] sc, String[] name, int[] sum) {
		System.out.println("번호\t이름\t국어\t영어\t수학\t총합\t평균");

		// 몇개 있나 카운트
		int stcount = 0;
		for (int i = 0; i < count; i++) {
			if (name[i] != null)
				stcount++;
		}
		int[] idxArr = new int[stcount];
		int[] totalArr = new int[stcount];
		int idx = 0;
		// 총합 계산
		for (int i = 0; i < count; i++) {
			if (name[i] == null)
				continue;
			idxArr[idx] = i;
			totalArr[idx] = sc[i][0] + sc[i][1] + sc[i][2];
			idx++;
		}
		// 정렬
		for (int i = 0; i < stcount - 1; i++) {
			for (int j = 0; j < stcount - 1; j++) {
				if (totalArr[j] < totalArr[j + 1]) {

					// 총합 정렬
					int tmpTotal = totalArr[j];
					totalArr[j] = totalArr[j + 1];
					totalArr[j + 1] = tmpTotal;

					// 인덱스 정렬
					int tmpIdx = idxArr[j];
					idxArr[j] = idxArr[j + 1];
					idxArr[j + 1] = tmpIdx;
				}
			}
		}
		// 정렬 된 출력
		for (int k = 0; k < stcount; k++) {
			int i = idxArr[k];
			int sumScore = totalArr[k];
			System.out.print((i + 1) + "번\t");
			System.out.print(name[i] + "\t");
			System.out.print(sc[i][0] + "\t" + sc[i][1] + "\t" + sc[i][2] + "\t");
			System.out.print(sumScore + "\t");
			System.out.println(sumScore / 3);
		}

		System.out.println("총점 높은 순서 출력 완료.");
	}

	// 7.세이브
	public static void getSaved(int count, int[][] sc, String[] name) {
		String filePath = "E:\\java-workspace\\save.txt";
		File file = new File(filePath);

		try {
			// 파일 없으면 새로 생성
			if (!file.exists()) {
				file.createNewFile();
			}

			// BufferedWriter 생성
			BufferedWriter w = new BufferedWriter(new FileWriter(file, false));

			for (int i = 0; i < name.length; i++) {
				if (name[i] == null)
					continue;

				int sumScore = 0;
				String str = "";

				str += name[i] + "\t";

				for (int j = 0; j < sc[i].length; j++) {
					str += sc[i][j] + "\t";
					sumScore += sc[i][j];
				}
				w.write(str);
				w.newLine();
			}

			w.flush();
			w.close();

			System.out.println("저장 완료");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	// 8.로드
	public static void getLoad(int count, int[][] sc, String[] name) {
		String filePath = "E:\\java-workspace\\save.txt";
		File file = new File(filePath);

		try {
			if (file.exists()) {
				BufferedReader reader = new BufferedReader(new FileReader(file));
				String line;
				count = 0; // 기존값 날리기

				while ((line = reader.readLine()) != null) {
					String[] inline = line.split("\t");
					if (inline.length >= 4) { // 이름 + 3과목
						name[count] = inline[0];
						sc[count][0] = Integer.parseInt(inline[1]);
						sc[count][1] = Integer.parseInt(inline[2]);
						sc[count][2] = Integer.parseInt(inline[3]);
						count++;
					}
				}
				reader.close();
				System.out.println("로드 성공, " + count + "명");

			} else {
				System.out.println("저장된 파일이 없습니다.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 메인
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int sc[][] = new int[5][3];
		String name[] = new String[5];
		int count = 0;
		int sum[] = new int[5];

		while (true) {
			// 메뉴 선택
			getMenu();
			int num = scanner.nextInt();
			// 1.입력
			if (num == 1) {
				count = getInput(count, sc, name, scanner);
			}
			// 2.출력
			else if (num == 2) {
				getPrint(count, sc, name, sum);
			}
			// 3.수정
			else if (num == 3) {
				getUpdate(count, sc, name, scanner);
			}
			// 4.삭제
			else if (num == 4) {
				getDelete(count, sc, name, scanner);
			}
			// 5.검색
			else if (num == 5) {
				getSearch(count, sc, name, scanner);
			}
			// 6. 출력2(정렬)
			else if (num == 6) {
				getPrint2(count, sc, name, sum);
			}
			// 7. 세이브
			else if (num == 7) {
				getSaved(count, sc, name);
			}
			// 8. 로드
			else if (num == 8) {
				getLoad(num, sc, name);
			}
			// 종료
			else if (num == 0) {
				System.out.println("프로그램 종료되었습니다.");
				break;
			} else {
				System.out.println("잘못된 값을 입력하셨습니다. 다시 선택하세요");
				continue;
			}
		}
		scanner.close();

	}
}