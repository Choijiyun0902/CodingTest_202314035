import java.util.Scanner;
import java.util.HashSet;

public class Main_202314035_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 1. 문자열 입력받기 
        String S = sc.next();
        
        // 2. 중복 제거
        HashSet<String> set = new HashSet<>();
        
        // 3. 모든 부분 문자열 찾기
        for (int i = 0; i < S.length(); i++) {
            for (int j = i + 1; j <= S.length(); j++) {
                
                set.add(S.substring(i, j));
            }
        }
        
        // 4. 결과 
        System.out.println(set.size());
        
        sc.close();
    }
}