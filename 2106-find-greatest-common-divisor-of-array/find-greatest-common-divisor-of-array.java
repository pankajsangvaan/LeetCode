class Solution {
    public int gcd(int a,int b){
        while(b!=0){
            int t=b;
            b=a%b;
            a=t;
        }
        return a;
    }
    public int findGCD(int[] nums) {
        int l=nums[0];
        int s=nums[0];
        for(int i=0;i<nums.length;i++){
            if(nums[i]>l){
                l=nums[i];
            }
            if(nums[i]<s){
                s=nums[i];
            }
        }
        return gcd(s,l);

        
    }
}