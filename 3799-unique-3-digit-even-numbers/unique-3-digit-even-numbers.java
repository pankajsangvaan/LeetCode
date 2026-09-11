class Solution {
    public int totalNumbers(int[] digits) {

        int[] freq = new int[10];

        // Count frequency of each digit
        for (int d : digits) {
            freq[d]++;
        }

        int count = 0;

        // First digit: 1-9 (cannot be 0)
        for (int first = 1; first <= 9; first++) {

            // Second digit: 0-9
            for (int second = 0; second <= 9; second++) {

                // Last digit must be even
                for (int last = 0; last <= 8; last += 2) {

                    // Same digit cannot be used more times than available
                    int[] used = new int[10];

                    used[first]++;
                    used[second]++;
                    used[last]++;

                    boolean possible = true;

                    for (int d = 0; d <= 9; d++) {
                        if (used[d] > freq[d]) {
                            possible = false;
                            break;
                        }
                    }

                    if (possible) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}