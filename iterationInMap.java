import java.util.*; 
class TreeMapImpl { 
    public static void main(String args[]) 
    { 
        
        TreeMap<Integer, String> treeM= new TreeMap<Integer, String>(); 
 
        treeM.put(4, "Welcome"); 
        treeM.put(3, "To"); 
        treeM.put(2, "My"); 
  	treeM.put(1, "World"); 

        for (Map.Entry mapElement : treeM.entrySet()) 
	   { 
              int key = (int)mapElement.getKey();
              String val = (String)mapElement.getValue(); 
              System.out.println(key +" " + val); 
           } 
    } 
} 