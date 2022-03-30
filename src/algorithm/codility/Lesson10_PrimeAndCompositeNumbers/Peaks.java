package algorithm.codility.Lesson10_PrimeAndCompositeNumbers;

import java.util.ArrayList;
import java.util.List;

public class Peaks {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2};
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        List<Integer> indexList = new ArrayList<>();

        for (int i = 1;i < A.length - 1;i++) {
            if (A[i-1] < A[i] && A[i] > A[i+1]) {
                indexList.add(i);   //peak index 추가
            }
        }

        for (int i = A.length;i >= 1;i--) {
            if (A.length % i == 0) {
                int blockLength = A.length / i; //block 하나 당 길이
                int count = 0;
                for (int peak : indexList) {
                    if (peak / blockLength == count) {  //block 당 peak가 포함됐는지
                        count++;
                    }
                }

                if (count == i) {
                    return i;
                }
            }
        }
        return 0;
    }
}
