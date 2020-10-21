import java.util.*;
class MaxDistinction{
	static int maxDistinctNum(int arr[], int size, int k) 
		{
  			HashMap<Integer,Integer> numFreq = new HashMap<>(); 
  			for(int i = 0 ;i < size; i++)
  			{
   			    numFreq.put(arr[i],numFreq.getOrDefault(arr[i], 0) + 1);
  			}
  			int result = 0;
  			PriorityQueue<Integer> mininumHeap = new PriorityQueue<Integer>();
  			for(Map.Entry<Integer,Integer> map : numFreq.entrySet()) 
  			{
    			   if(map.getValue() == 1) 
			   {
      				++result;
			   }
    			   else
			   {
      			     mininumHeap.add(map.getValue());
			   }
  			}
  			while(k != 0 && !mininumHeap.isEmpty()) 
  			{
    				Integer value = mininumHeap.poll(); 
    				if(value == 1)
    				{
      			   	    ++result;
    				}
    				else
    				{
     			  	   --value;--k;
      			  	   mininumHeap.add(value);
    				}
  			}
  			return result;
		}
		public static void main(String[] args) 
		{        
  			int arr[] = {8,3,6,3,8,1,6,5}; 
  			int size = arr.length; 
  			int k = 4; 
  			System.out.println("Maximum distinct elements are:" +maxDistinctNum(arr,size, k));
		}
	}
 
