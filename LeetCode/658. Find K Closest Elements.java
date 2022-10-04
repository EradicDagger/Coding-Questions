//https://leetcode.com/problems/find-k-closest-elements/
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
       
        /*
        //Simple Binary and then propagatinf left and right
        int left = 0;
        int right = arr.length-1;
        int mid = 0;
        //x = Math.abs(x); 
        
        while (left <= right) {
            mid = (left + right)/2;
            
            if (arr[mid] == x) {
                break;
            } else if (arr[mid] < x ) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        System.out.println(left +  " " + mid + " " + right); 
        if(mid>=1) {
            left = mid-1;
            right = mid;
        } else {
            left = mid;
            right = mid+1;
        }
        
        System.out.println(left +  " " + mid + " " + right);
       
        LinkedList<Integer> ans = new LinkedList<>();
        while (left >= 0 && right < arr.length &&  k > 0) {
            if (Math.abs(arr[left] - x)  <= Math.abs(arr[right] - x)) {
                ans.addFirst(arr[left]);
                left--;
            } else {
                ans.add(arr[right]);
                right++;
            }
            k--;
        }
        
        while ( k > 0 && left >= 0) {
                ans.addFirst(arr[left]);
                left--;
                k--;
        }
        
        while ( k > 0 && right < arr.length) {
                ans.add(arr[right]);
                right++;
                k--;
        }
            
        //Collections.sort(ans);
        return ans;
        */
        
        
        // Mathamatical Sliding window
        int left = 0;
        int right = arr.length-k;
        int mid =0;
        while (left < right) {
            mid = (left + right)/2;
            if (x - arr[mid] > arr[mid+k] -x ) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        for (int i = left; i < left+k; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }
}
