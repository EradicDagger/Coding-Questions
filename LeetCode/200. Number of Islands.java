// https://leetcode.com/problems/number-of-islands/

class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    dfsUtility(grid,i,j); 
                    count++;
                }
            }
        }
        return count;
    }
    
    public void dfsUtility(char[][] grid,int cr,int cc){
        if (cr < 0 || cc < 0 || cr > grid.length-1 || cc > grid[0].length-1 || grid[cr][cc] != '1') {
            return;
        }
        
        grid[cr][cc] = '9';
        
        dfsUtility(grid, cr, cc-1);
        dfsUtility(grid, cr-1, cc);
        dfsUtility(grid, cr, cc+1);
        dfsUtility(grid, cr+1, cc);       
    }
}
