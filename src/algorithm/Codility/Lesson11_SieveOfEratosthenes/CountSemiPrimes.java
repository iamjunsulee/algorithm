package algorithm.codility.Lesson11_SieveOfEratosthenes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountSemiPrimes {
    public static void main(String[] args) {
        int[] p = {1, 4, 16};
        int[] q = {26, 10, 20};
        System.out.println(Arrays.toString(solution(26, p, q)));
    }
    public static int[] solution(int N, int[] P, int[] Q) {
        int[] answer = new int[P.length];
        int[] prime = new int[N + 1];
        int[] semiPrime = new int[N + 1];
        Arrays.fill(prime, 1);
        prime[0] = 0;   //소수 아니므로 제외
        prime[1] = 0;   //소수 아니므로 제외

        //에라토스테네스의 체
        for (int i = 2;i <= N;i++) {
            for (int j = i + i;j <= N;j += i) {
                if (prime[j] == 0) continue;
                prime[j] = 0;
            }
        }

        List<Integer> indexList = new ArrayList<>();
        for (int i = 2;i <= N;i++) {
            if (prime[i] == 1) {
                indexList.add(i);
            }
        }

        for (int i = 0;i < indexList.size();i++) {
            for (int j = i;j < indexList.size();j++) {
                int semiPrimeNum = indexList.get(i) * indexList.get(j);
                if (semiPrimeNum > N) {
                    break;
                } else {
                    semiPrime[semiPrimeNum] = 1;
                }
            }
        }
        //해당 위치까지 semi prime 수의 수
        for (int i = 1;i <= N;i++) {
            semiPrime[i] += semiPrime[i - 1];
        }

        for (int i = 0;i < P.length;i++) {
            answer[i] = semiPrime[Q[i]] - semiPrime[P[i] - 1];
        }
        System.out.println(Arrays.toString(prime));
        System.out.println(Arrays.toString(semiPrime));

        return answer;
    }
}
