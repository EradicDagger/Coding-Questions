//https://leetcode.com/problems/min-cost-to-connect-all-points/
//Using Prims algo
class Solution {
    
    public int minCostConnectPoints(int[][] points) {
        int size = points.length;
        int minDistance[] = new int[size];
        Arrays.fill(minDistance,Integer.MAX_VALUE);
        boolean connected[] = new boolean[size];
        int ans = 0;
        int count = 1;
        int minDistanceIdx = 0;
        
        while (count < size) {
            connected[minDistanceIdx] = true;
            minDistanceIdx = primsUtility(points,minDistance,connected,minDistanceIdx);
            ans += minDistance[minDistanceIdx];
            count++;
        }
        return ans; 
    }
    
    private int primsUtility(int[][] points,int[] minDistance, boolean[] connected, int idx) {
        int size = connected.length;
        int minDistanceIdx = 0;
        
        for (int i=0; i<size; i++) {
            if (connected[i] == false) {
                minDistance[i] = Math.min(minDistance[i], getManhattanDistance(points[idx],points[i]));
                if (minDistance[minDistanceIdx] > minDistance[i])
                    minDistanceIdx = i;
            }
        }
        return minDistanceIdx;
    }
    
    
    private int getManhattanDistance(int a[], int b[]){
        return Math.abs(a[0]-b[0]) + Math.abs(a[1]-b[1]);
    }
    
}
