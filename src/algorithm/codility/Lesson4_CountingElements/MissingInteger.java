package algorithm.codility.Lesson4_CountingElements;

import java.util.HashSet;
import java.util.Set;

/*
given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
 */
public class MissingInteger {
    public static void main(String[] args) {
        int[] a = {1, 3, 6, 4, 1, 2};
        System.out.println(solution(a));
    }
    public static int solution(int[] A) {
        if (A.length == 0) return 1;

        Set<Integer> elements = new HashSet<>();
        for (int i : A) {
            elements.add(i);
        }
        for (int i = 1;i <= A.length;i++) {
            if (!elements.contains(i)) return i;
        }
        return A.length + 1;
    }
}
