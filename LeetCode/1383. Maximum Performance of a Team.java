//https://leetcode.com/problems/maximum-performance-of-a-team/
class Solution {
    int mod = (int)1e9 + 7;
    
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        
        List<Performance> list = new ArrayList<>();
        
        for (int i=0;i<speed.length;i++) {
            list.add(new Performance(speed[i], efficiency[i])); 
        }
        
        list.sort((o1, o2) -> o2.efficiency - o1.efficiency);
        
        PriorityQueue<Integer> efficiencyQueue = new PriorityQueue<>();
        
        long maxPerformance = Integer.MIN_VALUE;
        long totalSpeed = 0;
        
        for (Performance p : list) {
            
            totalSpeed += p.speed; 
            efficiencyQueue.offer(p.speed);
          
            if (efficiencyQueue.size() > k) {
                totalSpeed -= efficiencyQueue.poll();
            }
            
            maxPerformance = Math.max(maxPerformance, (totalSpeed * p.efficiency));
        }
        return (int) (maxPerformance%(long)(1e9+7) );  
    }
    
    private static class Performance {
        int speed;
        int efficiency;

        public Performance(int speed, int efficiency) {
            this.speed = speed;
            this.efficiency = efficiency;
        }
        
        @Override
        public String toString() {
			return this.speed + " " + this.efficiency;
        	
        }
        
    }
}
