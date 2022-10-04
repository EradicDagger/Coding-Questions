// https://leetcode.com/problems/number-of-times-binary-string-is-prefix-aligned/

class Solution {
    public int numTimesAllBlue(int[] flips) {
        
        int max = 0;
        int count = 0;
        
        for (int i =0; i< flips.length;i++) {
            max = Math.max(max, flips[i]);
            if (max == i+1) {
                count++;
            }
        }
        return count;
        
    }
}
