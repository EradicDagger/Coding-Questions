import java.util.*; 
  
class ConnectRopesTogether { 
    static int costMin(int arr[], int sz) 
    { 
        PriorityQueue<Integer> pqueue = new PriorityQueue<Integer>(); 
        for (int i = 0; i < sz; i++) { 
            pqueue.add(arr[i]); 
        }
        int res = 0; 
        while (pqueue.size() > 1)
	{ 
            int first = pqueue.poll(); 
            int second = pqueue.poll(); 
            res += first + second; 
            pqueue.add(first + second); 
        } 
        return res; 
    } 
    public static void main(String args[]) 
    { 
        int len[] = { 8,5,10,7,3}; 
        int size = len.length; 
        System.out.println("Total amount for connecting ropes is " + costMin(len, size)); 
    } 
} 
