package algorithm.Codility;

public class Solution {
    public static void main(String[] args) {
        //System.out.println(parityDegree(48));
        System.out.println(threeLetters(3, 1));
    }

    /*
    어떤 수 N이 주어질 때, N mod (2^k) = 0 인 최대 k 값 출력
     */
    public static int parityDegree(int n) {
        //2 4 8 16 32 64 ....
        //12 6 3 1
        //0 0 0 8
        //몫이 작을 때까지 나머지가 0인 것
        int divisor = 2;
        int k = 1;
        while(n % (Math.pow(divisor, k)) == 0) {
            k++;
        }
        return k-1;
    }

    /*
    입력받는 두 수 A, B 만큼 문자 a, b를 가지고 문자열을 만드는데,
    하나의 문자가 연속적으로 3번 나오면 안된다.
     */
    //3개가 연속적이면 안되니까 2개까지 문자를 붙이고 그 다음 다른 문자로 2개까지 붙이고 나머지 문자 붙이면?
    //어떤 문자부터 시작할건지는 어떻게 체크하나

    public static String threeLetters(int A, int B) {
        StringBuilder result = new StringBuilder();
        while ( A > 0 || B > 0) {
            if (A > B) {
                if (result.length() < 2) {
                    result.append("a");
                    A--;
                } else {
                    if (isPossible(result, 'a')) {
                        result.append("a");
                        A--;
                    }
                    else {
                        result.append("b");
                        B--;
                    }
                }
            } else if (B >= A) {
                if (result.length() < 2) {
                    result.append("b");
                    B--;
                }
                else {
                    if (isPossible(result, 'b')) {
                        result.append("b");
                        B--;
                    }
                    else {
                        result.append("a");
                        A--;
                    }
                }
            }
        }
        return result.toString();
    }

    private static boolean isPossible(StringBuilder result, char a) {
        return result.charAt(result.length() - 1) != a || result.charAt(result.length() - 2) != a;
    }
}
