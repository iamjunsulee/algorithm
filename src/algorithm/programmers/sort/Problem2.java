package algorithm.programmers.sort;

import java.util.*;

//메모리 초과, 다시 풀 것
public class Problem2 {
    static boolean[] visited;
    static Set<Integer> set;

    public static void main(String[] args) {
        int[] numbers = {6, 10, 2};
        System.out.println(solution(numbers));
    }

    public static String solution(int[] numbers) {
        visited = new boolean[numbers.length];
        set = new HashSet<>();
        func(0, numbers, "");
        List<Integer> numList = new ArrayList<>(set);
        Collections.sort(numList);
        return String.valueOf(numList.get(numList.size() - 1));
    }

    public static void func(int depth, int[] numbers, String current) {
        if (depth == numbers.length) {
            set.add(Integer.parseInt(current));
            return;
        }

        for (int i = 0;i < numbers.length;i++) {
            if (!visited[i]) {
                visited[i] = true;
                String number = current + String.valueOf(numbers[i]);
                func(depth + 1, numbers, number);
                visited[i] = false;
            }
        }
    }
}
