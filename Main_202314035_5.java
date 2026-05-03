import java.util.Scanner;

public class Main_202314035_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 1. 단어 입력 받기
        String word = sc.next().toUpperCase(); // 대문자로 변환하여 입력 받음
        
        // 2. 알파벳 빈도수를 저장할 배열 (A-Z: 26개)
        int[] counts = new int[26];
        
        // 3. 단어를 순회하며 각 알파벳의 개수 세기
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            // 'A'를 빼주면 인덱스가 0(A) ~ 25(Z)가 됨
            counts[ch - 'A']++;
        }
        
        // 4. 가장 많이 나온 알파벳 찾기
        int maxCount = -1;
        char result = '?';
        
        for (int i = 0; i < 26; i++) {
            if (counts[i] > maxCount) {
                maxCount = counts[i];
                result = (char) (i + 'A'); // 인덱스를 다시 문자로 변환
            } else if (counts[i] == maxCount) {
                // 최댓값이 중복될 경우 '?' 저장
                result = '?';
            }
        }
        
        // 5. 결과 출력
        System.out.println(result);
        
        sc.close();
    }
}