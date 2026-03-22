import java.util.HashMap;
import java.util.Scanner;

public class Main_202314035_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. 참여자 명단 입력 -쉼표로 구분
        System.out.println("참여자 명단을 입력하세요 (예: leo,kiki,eden):");
        String[] participant = sc.nextLine().split(",");

        // 2. 완주자 명단 입력
        System.out.println("완주자 명단을 입력하세요 (예: eden,kiki):");
        String[] completion = sc.nextLine().split(",");

        // 3. 실행
        String result = solve(participant, completion);
        
        // 4. 결과 출력
        System.out.println("완주하지 못한 선수: " + result);
    }

    public static String solve(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String player : participant) map.put(player, map.getOrDefault(player, 0) + 1);
        for (String player : completion) map.put(player, map.get(player) - 1);

        for (String key : map.keySet()) {
            if (map.get(key) != 0) return key;
        }
        return "";
    }
}