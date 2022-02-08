package algorithm.codility.Lesson3_TimeComplexity;

public class PermMissingElem {
    public static void main(String[] args) {
        int[] a = {2, 3, 1, 5};
        System.out.println(solutionA(a));
    }
    public static int solution(int[] A) {
        int result = 0;
        int[] check = new int[A.length + 2];

        for (int i : A) {
            check[i]++;
        }

        for (int i = 0;i < check.length;i++) {
            if (check[i] == 0 && i != 0) result = i;
        }
        return result;
    }
    //key : 전체 합계를 이용(1~N까지 합은 N*(N+1) / 2)
    public static int solutionA(int[] A) {
        int range = (A.length + 1);
        int sum = range * (range + 1) / 2;

        for (int i : A) {
            sum -= i;
        }
        return sum;
    }
}
