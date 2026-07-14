class Solution {

    Boolean[][] dp;

    public boolean isMatch(String s, String p) {
        dp = new Boolean[s.length() + 1][p.length() + 1];
        return solve(0, 0, s, p);
    }

    private boolean solve(int i, int j, String s, String p) {

        // Pattern finished
        if (j == p.length()) {
            return i == s.length();
        }

        // Already computed
        if (dp[i][j] != null) {
            return dp[i][j];
        }

        // Check if current characters match
        boolean firstMatch = (i < s.length()) &&
                (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        // Next character is '*'
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {

            dp[i][j] =
                    solve(i, j + 2, s, p) ||          // Skip x*
                    (firstMatch && solve(i + 1, j, s, p)); // Use x*

        } else {

            dp[i][j] =
                    firstMatch && solve(i + 1, j + 1, s, p);

        }

        return dp[i][j];
    }
}