// https://leetcode.com/problems/min-cost-climbing-stairs/
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        //cost =  1 2 3  4   5  6 * 
        //              n-3       n  
            
        for (int i=cost.length-3; i>=0;i--) {
            cost[i] += Math.min(cost[i+1], cost[i+2]);
        }    
        return Math.min(cost[0], cost[1]);
    }
}
