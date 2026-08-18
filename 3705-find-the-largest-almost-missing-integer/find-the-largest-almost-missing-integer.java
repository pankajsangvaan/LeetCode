class Solution {

    static class Info {
        int lastR;
        int count;

        Info(int lastR, int count) {
            this.lastR = lastR;
            this.count = count;
        }
    }

    public int largestInteger(int[] nums, int k) {

        int n = nums.length;
        HashMap<Integer, Info> map = new HashMap<>();

        for (int i = 0; i < n; i++) {

            int L = Math.max(0, i - k + 1);
            int R = Math.min(i, n - k);

            if (!map.containsKey(nums[i])) {

                // First occurrence of this number
                map.put(nums[i], new Info(R, R - L + 1));

            } else {

                Info info = map.get(nums[i]);

                // If current interval does not overlap/touch
                if (L > info.lastR + 1) {
                    info.count += R - L + 1;
                }

                // If intervals overlap, only add the new part
                else if (R > info.lastR) {
                    info.count += R - info.lastR;
                }

                info.lastR = R;
            }
        }

        int ans = -1;

        for (Map.Entry<Integer, Info> entry : map.entrySet()) {

            if (entry.getValue().count == 1) {
                ans = Math.max(ans, entry.getKey());
            }
        }

        return ans;
    }
}