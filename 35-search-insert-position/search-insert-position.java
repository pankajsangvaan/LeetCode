class Solution {
    public int find(int[] nums,int target,int s,int e){

        int mid=(s+e)/2;
        if(s>e){
            return s;
        }
        if(nums[mid]==target){
            return mid;
        }
        else if((s==e)){
            if(nums[s]>target){
                return mid;
            }
            else{
                return mid+1;
            }
        }
        else if(nums[mid]<target){
            return find(nums,target,mid+1,e);
        }
        else {
            return find(nums,target,s,mid-1);
        }


    }
    public int searchInsert(int[] nums, int target) {
        int e=nums.length-1;
        int ans=find(nums,target,0,e);
        return ans;
        
    }
}