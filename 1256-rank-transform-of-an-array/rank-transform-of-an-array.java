class Solution {
    public int[] arrayRankTransform(int[] arr) {

        int n = arr.length;

        if (n == 0)
            return new int[0];

        int[] ans = new int[n];

        int[][] sortarr = new int[n][2];

        for (int i = 0; i < n; i++) {
            sortarr[i][0] = arr[i];
            sortarr[i][1] = i;
        }

        Arrays.sort(sortarr, (a, b) -> Integer.compare(a[0], b[0]));

        int rank = 1;
        ans[sortarr[0][1]] = rank;

        for (int i = 1; i < n; i++) {
            if (sortarr[i][0] != sortarr[i - 1][0]) {
                rank++;
            }
            ans[sortarr[i][1]] = rank;
        }

        return ans;
    }
}