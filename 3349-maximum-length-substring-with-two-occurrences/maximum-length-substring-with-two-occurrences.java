class Solution {
    public int maximumLengthSubstring(String s) {
        int[] freq = new int[26];
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char curr = s.charAt(right);
            freq[curr - 'a']++;


            while (freq[curr - 'a'] > 2) {
                freq[s.charAt(left) - 'a']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}