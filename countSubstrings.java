import java.util.*;

class Solution {
    public int solve(int i, int j, String s, int[][] dp) {
        if (i >= j)
            return dp[i][j] = 1;
        if (dp[i][j] != -1)
            return dp[i][j];
        if (s.charAt(i) != s.charAt(j))
            return dp[i][j] = 0;
        return dp[i][j] = solve(i + 1, j - 1, s, dp);
    }

    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        int[][] dp = new int[n][n];
        
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                count += solve(i, j, s, dp);
            }
        }
        return count;
    }
}
