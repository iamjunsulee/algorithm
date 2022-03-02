package algorithm.codility.Lesson12_EuclideanAlgorithm;

public class CommonPrimeDivisors {
    public static void main(String[] args) {
        int[] A = {15, 10, 3};
        int[] B = {75, 30, 5};
        System.out.println(solution(A, B));
    }
    public static int solution(int[] A, int[] B) {
        int count = 0;
        for (int i = 0;i < A.length;i++) {
            int num1 = A[i];
            int num2 = B[i];
            int gcd = gcd(num1, num2);
            num1 = getSmallestDivisor(num1, gcd);
            num2 = getSmallestDivisor(num2, gcd);
            if (num1 == 1 && num2 == 1) count++;
        }
        return count;
    }
    //두 수 15, 75의 최대 공약수는 15
    //75는 15 * 5 로 이루어져 있고, 5와 15의 최대 공약수는 5이므로 소수의 곱 집합이 동일하다.
    private static int getSmallestDivisor(int number, int gcd) {
        while (true) {
            int divisor = gcd(number, gcd);
            if (divisor == 1) break;
            number /= divisor;
        }
        return number;
    }

    //최대공약수
    private static int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        else {
            return gcd(b, a % b);
        }
    }
}
