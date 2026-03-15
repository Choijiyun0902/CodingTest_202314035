import java.util.Scanner;
import java.util.HashSet;

public class Main_202314035 { //파일명 맞는지 확인
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N개의 정수 입력받아 HashSet에 저장
        int N = sc.nextInt();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(sc.nextInt());
        }

        // 정수 M개 입력받고 존재 확인
        int M = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) { //M번 반복
            if (set.contains(sc.nextInt())) { 
                sb.append(1).append("\n"); //if문: 숫자 포함 > 1나오고 줄바꿈(\n)
            } else {
                sb.append(0).append("\n"); //숫자 포함x > 0나오고 줄바꿈(\n)
            }
        }
        
        //결과 한꺼번에 출력
        System.out.println(sb.toString());
        sc.close(); //입력도구 닫기
    }
}