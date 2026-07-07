class Solution {
    public long sumAndMultiply(int n) {

        int sum = 0;
        long ans = 0;
        long place = 1;

        while (n > 0) {
            int digit = n % 10;
            sum += digit;
            n /= 10;

            if (digit != 0) {
                ans += digit * place;
                place *= 10;
            }
        }

        return ans * sum;
    }
}