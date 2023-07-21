package programmers.highscorekit.dp;

public class P42897 {
    public int solution(int[] money) {
        int n = money.length;
        int[][] dp = new int[2][n];
        for(int i=0; i<n; i++) {
            dp[0][i] = money[i];
            dp[1][i] = money[i];
        }
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[0][2] += dp[0][0];

        for(int i=3; i<n; i++) {
            dp[0][i] += Math.max(dp[0][i-2], dp[0][i-3]);
            dp[1][i] += Math.max(dp[1][i-2], dp[1][i-3]);
        }

        int first = Math.max(dp[0][n-2], dp[0][n-3]);
        int second = Math.max(dp[1][n-1], dp[1][n-2]);

        return Math.max(first, second);
    }
}
