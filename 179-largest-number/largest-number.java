import java.util.*;

class Solution {
    public String largestNumber(int[] nums) {

        // Step 1: Convert integers to strings
        String[] arr = new String[nums.length];

        for(int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        // Step 2: Sort using custom comparator
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        // Step 3: Handle all zeros
        if(arr[0].equals("0")) {
            return "0";
        }

        // Step 4: Build the answer
        StringBuilder ans = new StringBuilder();

        for(String s : arr) {
            ans.append(s);
        }

        return ans.toString();
    }
}