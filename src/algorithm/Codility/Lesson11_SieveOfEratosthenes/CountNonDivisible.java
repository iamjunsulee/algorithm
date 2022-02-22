package algorithm.Codility.Lesson11_SieveOfEratosthenes;

import java.util.Arrays;

/*
You are given an array A consisting of N integers.
For each number A[i] such that 0 ≤ i < N, we want to count the number of elements of the array that are not the divisors of A[i]. We say that these elements are non-divisors.
For example, consider integer N = 5 and array A such that:
    A[0] = 3
    A[1] = 1
    A[2] = 2
    A[3] = 3
    A[4] = 6
For the following elements:
A[0] = 3, the non-divisors are: 2, 6,
A[1] = 1, the non-divisors are: 3, 2, 3, 6,
A[2] = 2, the non-divisors are: 3, 3, 6,
A[3] = 3, the non-divisors are: 2, 6,
A[4] = 6, there aren't any non-divisors.
Result array should be returned as an array of integers.

For example, given:
    A[0] = 3
    A[1] = 1
    A[2] = 2
    A[3] = 3
    A[4] = 6
the function should return [2, 4, 3, 2, 0], as explained above.
Write an efficient algorithm for the following assumptions:
N is an integer within the range [1..50,000];
each element of array A is an integer within the range [1..2 * N].
 */
public class CountNonDivisible {
    public static void main(String[] args) {
        int[] A = {3, 1, 2, 3, 6};
        System.out.println(Arrays.toString(solution(A)));
    }
    //key : N의 배열이 주어질 때, 최대 2N 만큼의 숫자를 가진다 했으므로 2N만큼 크기를
    public static int[] solution(int[] A) {
        int[] divisor = new int[A.length * 2 + 1];  //약수의 개수를 저장하기 위한 배열
        int[] counter = new int[A.length * 2 + 1];  //해당 숫자의 개수를 저장하기 위한 배열
        int[] answer = new int[A.length];

        for (int val : A) {
            counter[val]++;
        }

        for (int i = 1;i <= A.length * 2;i++) {
            int num = counter[i];
            if (num == 0) continue;
            for (int j = i;j <= A.length * 2;j += i) {
                divisor[j] += num;  //인덱스를 i만큼 증가시키면서 해당 수의 약수를 카운트한다.
            }
        }

        for (int i = 0;i < A.length;i++) {
            answer[i] = A.length - divisor[A[i]];
        }
        return answer;
    }
}
