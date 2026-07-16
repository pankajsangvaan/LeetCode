class Solution {
    public double myPow(double x, int n) {
        double a=1;
        long m= n;
        if(n<0){
            x=1/x;
            m = -m;
        }
        while(m>0){
            if((m&1)==1){
                a*=x;
            }
            x*=x;
            m>>=1;
        }
        

        return a;
        
    }
}