package algorithm.Codility.Lesson9_MaximumSliceProblem;

public class MaxProfit {
    public static void main(String[] args) {
        int[] a = {23171, 21011, 21123, 21366, 21013, 21367};
        System.out.println(solution(a));
    }
    //key : max profit이라는 건 결국 큰값에서 젤 작은값을 뺸 경우
    public static int solution(int[] A) {
        int min = Integer.MAX_VALUE;
        int max_profit = 0;
        for (int price : A) {
            min = Math.min(min, price);
            max_profit = Math.max(max_profit, price - min);
        }
        return max_profit;
    }
}
