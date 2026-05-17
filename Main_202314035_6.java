import java.util.Arrays;
import java.util.Stack;

public class Main_202314035_6 {
    public static int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        
        for (int num : arr) {
            if (stack.isEmpty() || stack.peek() != num) {
                stack.push(num);
            }
        }
        
        int[] answer = new int[stack.size()];
        for (int i = answer.length - 1; i >= 0; i--) {
            answer[i] = stack.pop();
        }
        
        return answer;
    }

    public static void main(String[] args) {
        int[] testArray = {1, 1, 3, 3, 0, 1, 1};
        
        int[] result = solution(testArray);

        System.out.println("결과: " + Arrays.toString(result));
    }
}