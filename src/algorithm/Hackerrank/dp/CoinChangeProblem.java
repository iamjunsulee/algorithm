package algorithm.Hackerrank.dp;

import java.util.ArrayList;
import java.util.List;

public class CoinChangeProblem {
    public static void main(String[] args) {
        List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(2L);
        list.add(3L);
        System.out.println(getWays(4, list));
    }
    /*
    구해야하는 합 4와 코인 {1,2,3} 이 주어질 때
    코인으로 만들 수 있는 합 x 를 dp[x]라 할 때
    코인 1만 있을 때, dp[1] = 1, dp[2] = 1, dp[3] = 1, dp[4] = 1
    코인 1, 2가 있을 때, dp[1] = 1, dp[2] = 1 + dp[0], dp[3] = 1 + dp[1], dp[4] = 1 + dp[2]가 된다.
    dp[3]은 코인 1만 있을 땐 1 1 1 밖에 안되지만 코인 2가 있으면 1 2가 가능해지므로 dp[1]의 경우가 더해지는 것이다.
     */
    private static long getWays(int n, List<Long> c) {
        long[] dp = new long[n+1];
        dp[0] = 1;
        for(long coin : c) {
            for(int i = 1;i <= n;i++) {
                if(coin > i) continue;
                dp[i] += dp[(int) (i - coin)];
            }
        }
        return dp[n];
    }
}
