package algorithm.codility.Lesson15_CaterpillarMethod;

import java.util.HashSet;
import java.util.Set;

/*
A non-empty array A consisting of N numbers is given. The array is sorted in non-decreasing order.
The absolute distinct count of this array is the number of distinct absolute values among the elements of the array.

For example, consider array A such that:
  A[0] = -5
  A[1] = -3
  A[2] = -1
  A[3] =  0
  A[4] =  3
  A[5] =  6
The absolute distinct count of this array is 5, because there are 5 distinct absolute values among the elements of this array, namely 0, 1, 3, 5 and 6.
 */
public class AbsDistinct {
    public static void main(String[] args) {
        int[] a = {-5, -3, -1, 0, 3, 6};
        System.out.println(solution(a));
    }
    //key : 중복을 없애주는 자료구조 Set
    public static int solution(int[] A) {
        Set<Integer> set = new HashSet<>();

        for (int value : A) {
            set.add(Math.abs(value));
        }
        return set.size();
    }
}
