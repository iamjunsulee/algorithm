package algorithm.programmers.bruteForceSearch;

import java.util.HashSet;
import java.util.Set;

/*
한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.

각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.

제한사항
numbers는 길이 1 이상 7 이하인 문자열입니다.
numbers는 0~9까지 숫자만으로 이루어져 있습니다.
"013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
 */
public class Problem2 {
    static boolean[] visited;
    static Set<Integer> set;

    public static void main(String[] args) {
        String number1 = "17";
        String number2 = "011";
        System.out.println(solution(number1));
    }
    public static int solution(String numbers) {
        visited = new boolean[numbers.length()];    //방문했는지 체킹하기 위한 배열
        set = new HashSet<>();  //중복을 막기 위해 set 사용
        backtracking(0, numbers, "");
        return set.size();
    }

    public static void backtracking(int depth, String numbers, String current) {
        if (depth == numbers.length()) return;  //숫자는 주어진 문자열 길이만큼만 만들 수 있으므로

        for (int i = 0;i < numbers.length();i++) {
            if (!visited[i]) {
                visited[i] = true;  //방문 플래그
                String newNumber = current + numbers.charAt(i);
                int parsedNumber = Integer.parseInt(newNumber);
                if (isPrime(parsedNumber)) {    //소수인 경우, set에 담는다.
                    set.add(parsedNumber);
                }
                backtracking(depth + 1, numbers, newNumber);    //재귀호출
                visited[i] = false; //백트래킹하기 위한 플래그 초기화
            }
        }
    }

    public static boolean isPrime(int num) {
        if (num < 2) return  false; //0, 1 소수 아님

        //자기자신을 제외하고 절반을 초과하는 숫자에서 나눴을때 나머지가 0이되는 숫자는 나올수가 없다.
        //더 효율적으로 루트 N 까지만 확인한다.
        for (int i = 2;i*i <= num;i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
