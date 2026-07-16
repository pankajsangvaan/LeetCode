class Solution {
    public int gcd(int a , int b){
        while(b!=0){
            int temp = b;
            b=a%b;
            a= temp;
        }
        return a;
    }
    public long gcdSum(int[] nums) {

        int n=nums.length;
        int[] largest = new int[n];
        int larg = nums[0];
        int[] prefixGcd = new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]>larg){
                larg=nums[i];
            }
            largest[i]=larg;
            prefixGcd[i]=gcd(nums[i],largest[i]);
        }
        long sum=0;
        Arrays.sort(prefixGcd);
        for(int i=0;i<n/2;i++){
            int s=gcd(prefixGcd[i] ,prefixGcd[n-i-1]);
            sum+=s;

        }
        return sum;



    }
}