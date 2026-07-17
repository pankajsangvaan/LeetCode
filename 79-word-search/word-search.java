class Solution {
    public boolean find(char[][] b, String w,int i,int j,int x){
        int m=b.length;
        int n=b[0].length;
        if(x==w.length()){
            return true;
        }
        if((i>=m)||(j>=n)||(i<0)||(j<0)){
            return false;
        }

        if(b[i][j]!=w.charAt(x)){
            return false;
        }
        char t = b[i][j];
        b[i][j]='#';
        if(find(b,w,i,j+1,x+1)){
            return true;
        }
            else if(find(b,w,i+1,j,x+1)){
                return true;
            }
            else if(find(b,w,i-1,j,x+1)){
                return true;
            }
            else if(find(b,w,i,j-1,x+1)){
                return true;
            }
            else {
                b[i][j]=t;
                return false;
            }
    }

    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        char a=word.charAt(0);
        boolean ans=false;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==a){
                    ans=find(board,word,i,j,0);
                    if(ans){
                        break;
                    }
                }
            }
            if(ans){
                break;
            }
        }
        return ans;
        
    }
}