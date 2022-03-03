package algorithm.codility.Lesson14_BinarySearch;
/*
You are given integers K, M and a non-empty array A consisting of N integers. Every element of the array is not greater than M.
You should divide this array into K blocks of consecutive elements. The size of the block is any integer between 0 and N. Every element of the array should belong to some block.
The sum of the block from X to Y equals A[X] + A[X + 1] + ... + A[Y]. The sum of empty block equals 0.
The large sum is the maximal sum of any block.
 */
public class MinMaxDivison {
    public static void main(String[] args) {
        int[] a = {2, 1, 5, 1, 2, 2, 2};
        System.out.println(solution(3, 5, a));
    }

    public static int solution(int K, int M, int[] A) {
        int max = 0;
        int min = 0;

        for (int i : A) {
            max += i;//최대값은 전체
            min = Math.max(min, i);//최소값은 제일 큰 값 하나만 가질 때
        }
        //binary search
        while (min <= max) {
            int mid = (min + max) / 2;//중간값

            if (canDivide(A, mid, K)) {//블럭을 나눌 수 있으면
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return min;
    }

    private static boolean canDivide(int[] a, int mid, int k) {
        int currentSum = 0;
        int blocks = k;
        for (int j : a) {
            currentSum += j;

            if (currentSum > mid) {//중간합보다 크면 다음 블럭이 필요하단 뜻
                blocks--;
                currentSum = j;
            }

            if (blocks == 0) {//더이상 블록을 나눌 수 없으므로
                return false;
            }
        }
        return true;
    }
}
