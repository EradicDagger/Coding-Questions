// https://leetcode.com/problems/flood-fill/

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int current = image[sr][sc];
        if (newColor != current)
            floodFillUtility(image, sr, sc, current, newColor);
        
        return image;
    }
    
    public void floodFillUtility(int[][] image, int sr, int sc, int current, int newColor) {
        
        if(sr < 0 || sc < 0  || sr >= image.length || sc >= image[0].length || image[sr][sc] != current) 
            return;
        
        image[sr][sc] = newColor;
        
        floodFillUtility(image, sr-1, sc, current, newColor);
        floodFillUtility(image, sr, sc-1, current, newColor);
        floodFillUtility(image, sr+1, sc, current, newColor);
        floodFillUtility(image, sr, sc+1, current, newColor);
    }
}
