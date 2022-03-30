package algorithm.codility.Lesson1_Iterations;

/*
binary gap이란 N의 이진 표현에서 양쪽 끝에서 1로 둘러싸인 연속 0의 최대 시퀀스
10진수 9 = 2진수 1001 => binary gap는 1개, 길이는 2
10진수 529 = 2진수 1000010001 => binary gap은 2개, 길이는 각각 4, 3
양의 정수 N이 주어지면 가장 긴 이진 간격의 길이를 반환합니다. N에 이진 간격이 포함되지 않은 경우 함수는 0을 반환해야 합니다.
 */
public class BinaryGap {
    public static void main(String[] args) {
        System.out.println(solution(328));
    }
    //key : 비트 연산
    public static int solution(int N) {
        int max = 0;
        int count = 0;
        boolean counting = false;

        while (N != 0) {
            if (!counting) {
                if ((N&1) == 1) {
                    counting = true;    //갯수 세기 시작
                }
            }else {
                if ((N&1) == 0) {
                    count++;    //비트연산 결과가 0이므로 카운트 증가
                }else {
                    max = Math.max(max, count);
                    count = 0;  //reset
                }
            }
            N = N >> 1;     //오른쪽으로 비트 이동
        }
        return max;
    }
}
