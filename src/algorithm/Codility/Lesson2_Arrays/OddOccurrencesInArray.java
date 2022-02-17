package algorithm.Codility.Lesson2_Arrays;

/*
    given an array A consisting of N integers fulfilling the above conditions, returns the value of the unpaired element.

    all but one of the values in A occur an even number of times.
*/
public class OddOccurrencesInArray {
    public static void main(String[] args) {
        int[] a = {9, 3, 9, 3, 9, 7, 9};
        System.out.println(solution(a));
    }
    //key : XOR 연산(다르면 1, 같으면 0 => 자기 자신을 짝수번 더하면 0, 홀수번 더하면 자기 자신이 됨)
    public static int solution(int[] A) {
        int unpair = A[0];
        for (int i = 1;i < A.length;i++) {
            unpair = unpair ^ A[i];
            System.out.println("unpair :: " + unpair);
        }
        return unpair;
    }
}
