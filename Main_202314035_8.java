import java.util.Scanner;
import java.util.Stack;

public class Main_202314035_8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int K = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < K; i++) {
            int number = sc.nextInt();
            
            if (number == 0) {
                // 0이 입력되면 가장 최근에 넣은 숫자를 지웁니다.
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // 0이 아니면 스택에 숫자를 넣습니다.
                stack.push(number);
            }
        }
        
        // 스택에 남아있는 모든 숫자의 합 계산
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        
        // 최종 결과 출력
        System.out.println(sum);
        
        sc.close();
    }
}