class Solution {

    public boolean palindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public String longestPalindrome(String s) {

        if (s.length() == 1)
            return s;

        int start = 0;
        int max = 1;

        for (int i = 0; i < s.length(); i++) {

            for (int j = i; j < s.length(); j++) {

                if (j - i + 1 > max && palindrome(s, i, j)) {
                    max = j - i + 1;
                    start = i;
                }
            }
        }

        return s.substring(start, start + max);
    }
}