// https://leetcode.com/problems/climbing-stairs/
class Solution {
    public int climbStairs(int n) {
        int oneSteps = 1;
        int twoSteps = 1;
        int temp;
        for (int i=0; i< n-1;i++) {
            temp = oneSteps;
            oneSteps = oneSteps + twoSteps;
            twoSteps = temp;
        }
        return oneSteps;
    }
}
