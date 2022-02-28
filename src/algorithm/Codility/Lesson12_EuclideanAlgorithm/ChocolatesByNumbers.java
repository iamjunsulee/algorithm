package algorithm.codility.Lesson12_EuclideanAlgorithm;

//Euclidean Algorithm : 최대 공약수를 구하는 알고리즘
/*
You begin with eating chocolate number 0. Then you omit the next M − 1 chocolates or wrappers on the circle, and eat the following one.
More precisely, if you ate chocolate number X, then you will next eat the chocolate with number (X + M) modulo N (remainder of division).
You stop eating when you encounter an empty wrapper.
For example, given integers N = 10 and M = 4. You will eat the following chocolates: 0, 4, 8, 2, 6.
 */
public class ChocolatesByNumbers {
    public static void main(String[] args) {
        System.out.println(solution(12, 3));
    }
    //큰 수를 작은 수로 나눈 나머지를 구한다.
    //나눴던 수와 나머지로 다시 MOD 연산을 한다.
    //나머지가 0이 될 때까지 반복하는데, 이때 나누는 수가 최대 공약수이다.
    public static int solution(int N, int M) {
        int remainder = 0;
        int number = N;
        while(M != 0) {
            remainder = number % M;
            number = M;
            M = remainder;
        }
        return N / number;
    }
}
