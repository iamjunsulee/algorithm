package algorithm.Codility.Lesson10_PrimeAndCompositeNumbers;

/*
A positive integer D is a factor of a positive integer N if there exists an integer M such that N = D * M.
Write a function:
class Solution { public int solution(int N); }
that, given a positive integer N, returns the number of its factors.
For example, given N = 24, the function should return 8, because 24 has 8 factors, namely 1, 2, 3, 4, 6, 8, 12, 24. There are no other factors of 24.
N is an integer within the range [1..2,147,483,647].
 */
public class CountFactors {
    public static void main(String[] args) {
        System.out.println(solution2(2147395600));
        System.out.println(solution(69));
    }
    //time out
    public static int solution(int N) {
        int count = 0;
        int i = 1;
        while (i <= N) {
            if (N % i == 0) {
                count++;
            }
            i++;
        }
        return count;
    }

    // 소인수분해?
    // key : N의 가장 큰 약수는 N을 제외하면 최대 N/2
    public static int solution2(int N) {
        int count = 0;
        int sqrt = (int) Math.sqrt(N);
        for (int i = 1; i <= sqrt; i++) {
            if(N % i == 0) {
                count++;
            }
        }
        count *= 2;

        if (sqrt * sqrt == N) {
            count -= 1;
        }

        return count;
    }
}
