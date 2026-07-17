import java.util.*;

class Solution {

    public int[] gcdValues(int[] nums, long[] queries) {

        int max = 0;
        for (int x : nums) {
            max = Math.max(max, x);
        }

        // Frequency of each number
        int[] freq = new int[max + 1];
        for (int x : nums) {
            freq[x]++;
        }

        // countDiv[d] = numbers divisible by d
        int[] countDiv = new int[max + 1];

        for (int d = 1; d <= max; d++) {
            for (int multiple = d; multiple <= max; multiple += d) {
                countDiv[d] += freq[multiple];
            }
        }

        // gcdCount[d] = pairs whose gcd is exactly d
        long[] gcdCount = new long[max + 1];

        for (int d = max; d >= 1; d--) {

            long cnt = countDiv[d];
            gcdCount[d] = cnt * (cnt - 1) / 2;

            for (int multiple = 2 * d; multiple <= max; multiple += d) {
                gcdCount[d] -= gcdCount[multiple];
            }
        }

        // Prefix sums
        long[] prefix = new long[max + 1];

        for (int i = 1; i <= max; i++) {
            prefix[i] = prefix[i - 1] + gcdCount[i];
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            long q = queries[i];

            int low = 1;
            int high = max;

            while (low < high) {

                int mid = low + (high - low) / 2;

                if (prefix[mid] > q) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }

            ans[i] = low;
        }

        return ans;
    }
}