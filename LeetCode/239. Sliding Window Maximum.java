// https://leetcode.com/problems/sliding-window-maximum/

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length < k || nums.length == 0) return new int[0];
            int[] result = new int[nums.length - k + 1];
            Deque<Integer> deque = new ArrayDeque<>();
            int i = 0, index = 0;
            for(i = 0; i < nums.length; i++){
                if(i - k >= 0 && !deque.isEmpty() && deque.peek() == i - k) 
                    deque.pollFirst();
                int add = nums[i];
                while(!deque.isEmpty() && add >= nums[deque.getLast()]){
                    deque.pollLast();
                }
                deque.addLast(i);
                if(i - k + 1 >= 0) result[index++] = nums[deque.getFirst()];
            }
            return result; 
    }
}
