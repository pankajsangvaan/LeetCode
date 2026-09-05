class Solution {
    public int firstStableIndex(int[] nums, int k) {

        int n = nums.length;

        // suffix minimum
        int[] right = new int[n];

        right[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.min(nums[i], right[i + 1]);
        }

        // prefix maximum
        int left = nums[0];

        for (int i = 0; i < n; i++) {

            left = Math.max(left, nums[i]);

            int score = left - right[i];

            if (score <= k) {
                return i;
            }
        }

        return -1;
    }
}