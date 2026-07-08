class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {

        int mod = 1000000007;
        int n = s.length();

        // Prefix sum of digits
        int[] prefixsum = new int[n + 1];

        // Number of non-zero digits till each index
        int[] count = new int[n + 1];

        StringBuilder str = new StringBuilder();

        for (int i = 0; i < n; i++) {

            int digit = s.charAt(i) - '0';

            prefixsum[i + 1] = prefixsum[i] + digit;

            count[i + 1] = count[i];

            if (digit != 0) {
                str.append(digit);
                count[i + 1]++;
            }
        }

        int m = str.length();

        long[] power = new long[m + 1];
        power[0] = 1;

        for (int i = 1; i <= m; i++) {
            power[i] = (power[i - 1] * 10) % mod;
        }

        long[] prefixnumber = new long[m + 1];

        for (int i = 0; i < m; i++) {
            int digit = str.charAt(i) - '0';
            prefixnumber[i + 1] = (prefixnumber[i] * 10 + digit) % mod;
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int l = queries[i][0];
            int r = queries[i][1];

            long sum = prefixsum[r + 1] - prefixsum[l];

            int left = count[l];
            int right = count[r + 1];

            long number = 0;

            if (left != right) {

                int len = right - left;

                number = prefixnumber[right];

                number = number - (prefixnumber[left] * power[len]) % mod;

                if (number < 0) {
                    number += mod;
                }
            }

            ans[i] = (int) ((number * (sum % mod)) % mod);
        }

        return ans;
    }
}