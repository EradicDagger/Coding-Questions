import java.io.*; 
import java.util.*; 
  
class ArraysQue { 
    static int SubarrayDivByK(int arr[],int size, int k) 
    { 
        HashMap<Integer, Integer> map= new HashMap<Integer, Integer>(); 
        int mod_arr[]= new int[n]; 
        int max = 0; 
        int curr_sum = 0; 
        for (int i = 0; i < n; i++) 
        { 
            curr_sum += arr[i]; 
            mod_arr[i] = ((curr_sum % k) + k) % k;      
        }  
        for (int i = 0; i < n; i++) 
        { 
            if (mod_arr[i] == 0) 
               {
                  max = i + 1;
	       } 
            else if (map.containsKey(mod_arr[i]) == false) 
                {
		  map.put(mod_arr[i] , i); 
		}
            else
		{
                if (max < (i - map.get(mod_arr[i]))) 
                    {max = i - map.get(mod_arr[i]);}          
        } 
        return max; 
    }     
    public static void main (String[] args)  
    { 
        int arr[] = {2,5,9,10,3,2,5,9}; 
        int size = arr.length; 
        int k = 3; 
        System.out.println("Length:"+SubarrayDivByK(arr, size, k));   
    } 
} 
  
