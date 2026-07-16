class Solution {

    public long combination(int n, int r) {

        if (r > n - r) {
            r = n - r;
        }

        long ans = 1;

        for (int i = 1; i <= r; i++) {
            ans = ans * (n - i + 1) / i;
        }

        return ans;
    }

    public int climbStairs(int n) {

        long count = 0;
        int m = n;
        int two = 0;

        if (n == 0 || n == 1 || n == 2 || n == 3) {
            return n;
        }

        while (m >= 0) {

            count += combination(m + two, two);

            m -= 2;
            two++;
        }

        return (int) count;
    }
}