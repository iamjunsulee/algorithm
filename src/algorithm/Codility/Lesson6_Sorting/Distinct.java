package algorithm.Codility.Lesson6_Sorting;

import java.util.HashSet;
import java.util.Set;

public class Distinct {
    public static void main(String[] args) {
        int[] a = {2, 1, 1, 2, 3, 1};
        System.out.println(solution(a));
    }
    //key : 중복을 없애는 set
    public static int solution(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int i : A) {
            set.add(i);
        }
        return set.size();
    }
}
