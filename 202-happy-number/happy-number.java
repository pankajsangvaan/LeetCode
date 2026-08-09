import java.util.HashSet;

class Solution {
    public boolean isHappy(int n) {

        HashSet<Integer> set = new HashSet<>();

        while (n != 1) {

            // If we have already seen n, we are in a cycle
            if (set.contains(n)) {
                return false;
            }

            set.add(n);

            int sum = 0;

            // Calculate sum of squares of digits
            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }

            n = sum;
        }

        return true;
    }
}