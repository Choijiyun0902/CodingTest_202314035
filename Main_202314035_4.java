import java.util.Arrays;
import java.util.Scanner;

public class Main_202314035_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. 입력 안내
        System.out.println("전화번호를 쉼표(,)로 구분해서 입력하세요:");
        System.out.println("예: 119,97674223,1195524421");

        // 2. 한 줄을 통째로 입력받아 쉼표로 자르기
        String input = sc.nextLine();
        String[] phone_book = input.split(",");

        // 3. 결과 확인
        boolean result = checkPrefix(phone_book);
        
        if (result) {
            System.out.println("결과: true (접두어가 없습니다)");
        } else {
            System.out.println("결과: false (접두어가 존재합니다)");
        }
        
        sc.close();
    }

    // 접두어 확인
    public static boolean checkPrefix(String[] phone_book) {
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }
        return true;
    }
}