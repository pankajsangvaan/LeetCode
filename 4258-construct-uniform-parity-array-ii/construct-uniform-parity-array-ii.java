class Solution {
    public boolean uniformArray(int[] nums1) {
        int n=nums1.length;
        if(n==0){
            return true;
        }
        int s=0;
        int count=0;
        for(int i=0; i<n;i++){
            if(nums1[i]%2!=0){
                count+=1;
                if(count ==1){
                    s=nums1[i];
                }
                if(nums1[i]<s){
                    s=nums1[i];
                }
            }


        }
        int flag=0;
        for(int i=0; i<n;i++){
            if(nums1[i]%2==0){
                if(((nums1[i]-s)<1)){
                    flag=1;
                }

            }



        }   
        if(flag==0){
            return true;
        }     
        else{
            return false ;
        }

    }
}