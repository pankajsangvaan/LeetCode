
import java.util.Arrays;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[] num = new long[n];
        for(int i=0;i<n;i++){
            num[i]=nums[i]*nums[i];
        }

Arrays.sort(num);

long sum = 0;

int half = n / 2;

for (int i = 0; i < n; i++) {
    long square = num[i];

    if (i < half) {
        sum -= square;
    } else {
        sum += square;
    }
}

return sum;

    }
}
