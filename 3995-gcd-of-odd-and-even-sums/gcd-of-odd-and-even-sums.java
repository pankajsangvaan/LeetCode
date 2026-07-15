class Solution {
    public int gcd(int a, int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;

    }
    public int gcdOfOddEvenSums(int n) {
        int j= 1;
        int sumEven = 0;
        while(j<=n){
            sumEven +=j*2;
            j++;
        }
        int sumOdd=0;
        j=0;
        while(j<n){
            sumOdd += (2*j)+1;
            j++;
        }
        return gcd(sumOdd,sumEven);

        
    }
}