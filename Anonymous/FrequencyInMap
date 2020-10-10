import java.util.*; 
  
class CheckFrequency 
{ 
    static void printFrequencyOfElements(int arr[]) 
    { 
        TreeMap<Integer, Integer> treemap = new TreeMap<Integer, Integer>();

        for (int i = 0; i < arr.length; i++) 
        { 
     	    Integer ans = treemap.get(arr[i]);  
            if (treemap.get(arr[i]) == null) 
		{
                  treemap.put(arr[i], 1); 
                }
            else
              {
                treemap.put(arr[i], ++ans);
              } 
        } 
        for (Map.Entry mapElement:treemap.entrySet()) 
          System.out.println("Frequency of " + mapElement.getKey() +  " is " + mapElement.getValue()); 
    } 

    public static void main (String[] args) 
    { 
        int arr[] = {182,176,33,1224,33,98,1224,1224}; 
        printFrequencyOfElements(arr); 
    } 
} 
