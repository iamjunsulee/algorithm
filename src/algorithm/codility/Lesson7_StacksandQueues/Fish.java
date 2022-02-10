package algorithm.codility.Lesson7_StacksandQueues;

import java.util.Stack;

public class Fish {
    public static void main(String[] args) {
        int a[] = {4, 3, 2, 1, 5};
        int b[] = {0, 1, 0, 0, 0};
        System.out.println(solution(a, b));
    }
    //key : stack 사용, downstream인 fish를 stack에 넣는다.
    public static int solution(int[] A, int[] B) {
        Stack<Integer> stack = new Stack<>();
        int alive = A.length;

        for(int i = 0;i < A.length;i++) {
            if (B[i] == 1) {
                stack.push(A[i]);
            }

            if (B[i] == 0) {
                while (!stack.isEmpty()) {
                    if (stack.peek() > A[i]) {
                        alive--;
                        break;
                    }else {
                        alive--;
                        stack.pop();
                    }
                }
            }
        }
        return alive;
    }
}
