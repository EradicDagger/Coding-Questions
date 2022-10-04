// https://leetcode.com/problems/surrounded-regions/

class Solution {
    public void solve(char[][] board) {
        markBorderFriends(board);
        devour(board);
    }
    
    public void markBorderFriends(char[][] b){
        for (int j=0; j<b[0].length; j++){
            dfs(b,0,j);
            dfs(b,b.length-1,j);
        }
        for (int i=1; i<b.length-1; i++){
            dfs(b,i,0);
            dfs(b,i,b[0].length-1);
        }
    }
    
    public void dfs(char[][] b, int i, int j){
        if (i==b.length || j == b[0].length || i<0 || j<0){
            return;
        }
        if (b[i][j]=='O'){
            b[i][j] = '-';
            dfs(b, i+1, j);
            dfs(b, i, j+1);
            dfs(b, i, j-1);
            dfs(b, i-1, j);
        }
    }
    
    public void devour(char[][] b){
        for (int i=0; i<b.length; i++){
            for (int j=0; j<b[0].length; j++){
                if (b[i][j]!='-'){
                    b[i][j] = 'X';
                }
                else{
                    b[i][j] = 'O';
                }
            }    
        }
    }
}
