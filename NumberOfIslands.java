@author Ashutosh_Sharma
+ @author Jim

// Graph traversal technique to find number of islands [Lang: java]
public class Islands{
    static final int ROW = 5;
	static final int COL = 5;

    boolean isSafe(int M[][], int row, int col, boolean visited[][]){
        if((row >= 0 && col >= 0) && (row < ROW && col < COL) && (M[row][col] == 1) && (visited[row][col] == false))
            return true;
        else
            return false;
    }

    void DFS(int M[][], int row, int col, boolean visited[][]){
        int rowN[] = new int [] {-1, -1, -1,  0, 0,  1, 1, 1};
        int colN[] = new int [] {-1,  0,  1, -1, 1, -1, 0, 1};
       
        visited[row][col] = true;
       
        for(int i = 0; i < 8; i++ ){
            if(isSafe(M, row + rowN[i], col + colN[i], visited))
               DFS(M, row + rowN[i], col + colN[i], visited);
        } 
    }

    int countIslands(int M[][]){
        
        boolean visited[][] = new boolean[ROW][COL];
        
        int count = 0;
        
        for(int i = 0; i < ROW; i++){
            for(int j = 0; j < COL; j++){
                if(M[i][j] == 1 && !visited[i][j]){
                    DFS(M, i, j, visited);
                    ++count;
                }
            }
        }
        return count;
    }

    public static void main(String[] args){
        
       int M[][] = new int [][] {{1, 1, 1, 0, 0},
                                 {0, 1, 0, 0, 1},
                                 {0, 0, 1, 1, 1},
                                 {0, 1, 0, 0, 0}, 
                                 {1, 0, 0, 0, 0}};
        
        Islands I = new Islands();
        
        System.out.println("Number of islands is: "+ I.countIslands(M));
    }
}
