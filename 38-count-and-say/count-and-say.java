class Solution {
    public StringBuilder cas(int n){
        if(n==1){
            StringBuilder s=new StringBuilder();
            s.append("1");
            return s;
        }
        StringBuilder s= cas(n-1);
        int len=s.length();
        StringBuilder s1=new StringBuilder();
        int count = 1;
        for(int i=0;i<len;i++){

            if (i==len-1){
                s1.append(count);
                s1.append(s.charAt(i));
                break;
  
            }
            
            if(s.charAt(i)==s.charAt(i+1)){
                count++;
            }
            else{
                s1.append(count);
                s1.append(s.charAt(i));
                count = 1;
            }
        }
        return s1;

    }
    public String countAndSay(int n) {
        StringBuilder ans;
        ans = cas(n);
        String s = ans.toString();
        return s;

        
    }
}