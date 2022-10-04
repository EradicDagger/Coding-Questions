// https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/

class Solution {
    public int[] sumZero(int n) {
        
        int[] ans = new int[n];
        
        for (int i=0; i<n/2 ; i++) {
            ans[i] = (n-i)*(-1);
            ans[n-i-1] = n-i;
        }
        return ans;
    }
