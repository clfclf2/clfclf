

import java.io.*;
import java.util.Scanner;

public class Grade {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int sc[][] = new int[5][3];
        String name[] = new String[5];
        int count = 0;
        int sum[] = new int[5];

        System.out.println("┌─성적 관리 프로그램─┐");

        while (true) {

            // 선택
            System.out.println("1.입력");
            System.out.println("2.출력");
            System.out.println("3.수정");
            System.out.println("4.삭제");
            System.out.println("5.검색");
            System.out.println("6.출력2");
            System.out.println("7.세이브");
            System.out.println("8.저장 값 출력");
            System.out.println("0.프로그램 종료");
            System.out.print("선택 : ");
            int num = scanner.nextInt();

            // 입력
            if (num == 1) {
                if (count >= sc.length) {
                    System.out.println("더 이상 입력할 수 없습니다.");
                    continue;
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
                count++;
            }

            // 출력
            else if (num == 2) {
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
            
            //수정
            else if (num == 3) {
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

            // 삭제
            else if (num == 4) {
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
            
            //검색
            else if(num ==5) {
            	System.out.print("검색하실 이름을 입력하세요 : ");
            	String sel = scanner.next();
            	boolean found = false;
            	int ssum;
            	
            	for(int i=0; i<name.length; i++) {
            		if(sel.equals(name[i])) {
            			found = true;
            			System.out.println("번호\t이름\t국어\t영어\t수학\t총합\t평균");
                    	System.out.print((i+1)+"\t");
                    	System.out.print(name[i]+"\t");
                    	for(int j=0; j<sc[i].length; j++) {
                    		System.out.print(sc[i][j]+"\t");
                    	}
                    	ssum = sc[i][0]+sc[i][1]+sc[i][0];
                    	System.out.print(ssum+ "\t");
                        System.out.println(ssum / 3);
                    	System.out.println("검색이 완료되었습니다.");
            		}		
            	}
            	if (found !=true) {
        			System.out.println("값이 없습니다.");
            	}
            }
            
            else if (num == 6) {
    System.out.println("번호\t이름\t국어\t영어\t수학\t총합\t평균");

    // 유효한 학생 수 카운트
    int studentCount = 0;
    for (int i = 0; i < count; i++) {
        if (name[i] != null) studentCount++;
    }

    // 인덱스 배열 생성
    int[] indexArr = new int[studentCount];
    int[] totalArr = new int[studentCount];
    int idx = 0;

    // 총합 계산
    for (int i = 0; i < count; i++) {
        if (name[i] == null) continue;
        indexArr[idx] = i;
        totalArr[idx] = sc[i][0] + sc[i][1] + sc[i][2];
        idx++;
    }

    // 총합 기준 내림차순 정렬 (버블 정렬)
    for (int i = 0; i < studentCount - 1; i++) {
        for (int j = 0; j < studentCount - i - 1; j++) {
            if (totalArr[j] < totalArr[j + 1]) {
                // 총합 교환
                int tmpTotal = totalArr[j];
                totalArr[j] = totalArr[j + 1];
                totalArr[j + 1] = tmpTotal;
                // 인덱스 교환
                int tmpIdx = indexArr[j];
                indexArr[j] = indexArr[j + 1];
                indexArr[j + 1] = tmpIdx;
            }
        }
    }

    // 정렬된 순서대로 출력
    for (int k = 0; k < studentCount; k++) {
        int i = indexArr[k];
        int sumScore = totalArr[k];
        System.out.print((i + 1) + "번\t");
        System.out.print(name[i] + "\t");
        System.out.print(sc[i][0] + "\t" + sc[i][1] + "\t" + sc[i][2] + "\t");
        System.out.print(sumScore + "\t");
        System.out.println(sumScore / 3);
    }

    System.out.println("총합 기준 내림차순 출력 완료.");
}

           
            
        //세이브
        else if (num == 7) {
            String filePath = "C:\\Users\\chul\\Desktop\\jv\\save.txt";
            File file = new File(filePath);

            try {
                if (!file.exists()) {
                    file.createNewFile();
                }

                BufferedWriter w = new BufferedWriter(new FileWriter(file, false));

                for (int i = 0; i < count; i++) {
                    if (name[i] == null) continue;

                    StringBuilder sb = new StringBuilder();
                    sb.append(name[i]).append("\t");
                    for (int j = 0; j < sc[i].length; j++) {
                        sb.append(sc[i][j]).append("\t");
                    }
                    w.write(sb.toString().trim()); // 마지막 탭 제거
                    w.newLine();
                }

                w.flush();
                w.close();
                System.out.println("저장 완료");

            } catch (Exception e) {
                System.out.println("저장 중 오류: " + e);
            }
        }

        
        // 8. 로드
        else if (num == 8) {
            String filePath = "C:\\Users\\chul\\Desktop\\jv\\save.txt";
            File file = new File(filePath);

            try {
                if (file.exists()) {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    String line;
                    count = 0; // 기존 데이터 초기화

                    while ((line = reader.readLine()) != null) {
                        String[] parts = line.split("\t");
                        if (parts.length >= 4) { // 이름 + 3과목
                            name[count] = parts[0];
                            sc[count][0] = Integer.parseInt(parts[1]);
                            sc[count][1] = Integer.parseInt(parts[2]);
                            sc[count][2] = Integer.parseInt(parts[3]);
                            count++;
                        }
                    }
                    reader.close();
                    System.out.println("로드 성공, 불러온 데이터: " + count + "명");

                } else {
                    System.out.println("저장된 파일이 없습니다.");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


            	
            // 종료
            else if (num == 0) {
                break;
            }
           
        }

        scanner.close();
        System.out.println("프로그램 종료되었습니다.");
    }
}