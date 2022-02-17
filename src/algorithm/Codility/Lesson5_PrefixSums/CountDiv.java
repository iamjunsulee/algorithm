package algorithm.Codility.Lesson5_PrefixSums;

/*
that, given three integers A, B and K, returns the number of integers within the range [A..B] that are divisible by K, i.e.:
{ i : A ≤ i ≤ B, i mod K = 0 }
A and B are integers within the range [0..2,000,000,000];
K is an integer within the range [1..2,000,000,000];
A ≤ B.
=> A와 B 사이의 K의 배수 갯수 구하기
 */
public class CountDiv {
    public static void main(String[] args) {
        System.out.println(solution2(6, 11, 2));
    }
    //time out..
    public static int solution(int A, int B, int K) {
        int count = 0;
        for (int i = A;i <= B;i++) {
            if (i % K == 0) {
                count++;
            }
        }
        return count;
    }
    //key : 반복문을 쓰면 안된다.
    public static int solution2(int A, int B, int K) {
        int count = B/K - A/K;
        if (A % K == 0) count++;
        return count;
    }
}
