class Solution {
    public List<Integer> sequentialDigits(int low, int high) {

        List<Integer> list = new ArrayList<>();
        String s = "123456789";

        int len = String.valueOf(low).length();
        int lenh = String.valueOf(high).length();
        for(int i=len;i<=lenh;i++){
            for(int j=0;j+i<=9;j++){
                int ans = Integer.parseInt(s.substring(j,j+i));
                if((ans>=low)&&(ans<=high)){
                    list.add(ans);
                }
                if(ans>high){
                    break;
                }

            }

        }
    
        return list;               
    }
}