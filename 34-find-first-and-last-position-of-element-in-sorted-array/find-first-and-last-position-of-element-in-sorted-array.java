class Solution {

    int firstOccurrence(int[] nums, int target, int s, int e) {
        if (s > e) {
            return -1;
        }

        int mid = s + (e - s) / 2;

        if (nums[mid] == target) {
            int left = firstOccurrence(nums, target, s, mid - 1);
            if (left != -1) {
                return left;
            }
            return mid;
        } else if (nums[mid] < target) {
            return firstOccurrence(nums, target, mid + 1, e);
        } else {
            return firstOccurrence(nums, target, s, mid - 1);
        }
    }

    int lastOccurrence(int[] nums, int target, int s, int e) {
        if (s > e) {
            return -1;
        }

        int mid = s + (e - s) / 2;

        if (nums[mid] == target) {
            int right = lastOccurrence(nums, target, mid + 1, e);
            if (right != -1) {
                return right;
            }
            return mid;
        } else if (nums[mid] < target) {
            return lastOccurrence(nums, target, mid + 1, e);
        } else {
            return lastOccurrence(nums, target, s, mid - 1);
        }
    }

    public int[] searchRange(int[] nums, int target) {
        int first = firstOccurrence(nums, target, 0, nums.length - 1);
        int last = lastOccurrence(nums, target, 0, nums.length - 1);

        return new int[]{first, last};
    }
}