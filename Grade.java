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
            // 종료
            else if (num == 0) {
                break;
            }
        }

        scanner.close();
        System.out.println("프로그램 종료되었습니다.");
    }
}
