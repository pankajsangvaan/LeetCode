class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        
        // Store reserved seats for each row
        HashMap<Integer, Integer> map = new HashMap<>();

        // Bits corresponding to seats 2-9
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];

            // Only seats 2 to 9 affect the family blocks
            if (col >= 2 && col <= 9) {
                map.put(row, map.getOrDefault(row, 0) | (1 << col));
            }
        }

        // Rows without any reservation can have 2 families
        int ans = (n - map.size()) * 2;

        for (int mask : map.values()) {

            boolean left = true;   // seats 2,3,4,5
            boolean middle = true; // seats 4,5,6,7
            boolean right = true;  // seats 6,7,8,9

            // Check 2,3,4,5
            for (int seat = 2; seat <= 5; seat++) {
                if ((mask & (1 << seat)) != 0) {
                    left = false;
                    break;
                }
            }

            // Check 4,5,6,7
            for (int seat = 4; seat <= 7; seat++) {
                if ((mask & (1 << seat)) != 0) {
                    middle = false;
                    break;
                }
            }

            // Check 6,7,8,9
            for (int seat = 6; seat <= 9; seat++) {
                if ((mask & (1 << seat)) != 0) {
                    right = false;
                    break;
                }
            }

            if (left && right) {
                // Can put two families
                ans += 2;
            } else if (left || middle || right) {
                // Can put one family
                ans += 1;
            }
        }

        return ans;
    }
}