package HackerLandElections;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HackerLandElection {
	public static void main(String[] args) throws IOException {
		HashMap<String,Integer> map=new HashMap<>();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int inputs=0;
		while(true) {
			inputs++;
			String inputArray[]=br.readLine().split(" ");
			String name=inputArray[0];
			Integer votes=Integer.valueOf(inputArray[1]);
			map.put(name, votes);
			if(inputs==5)break;
		}
	/*	 for(Map.Entry<String,Integer> m:map.entrySet()){  
			   System.out.println(m.getKey()+" "+m.getValue());  
		  }  */
		 Set<Map.Entry<String,Integer>> enteries=map.entrySet();
	/*	 for(Entry<String,Integer> entry:enteries) {
			 System.out.println(entry.getKey()+" "+entry.getValue());
		 }*/
		 List<Map.Entry<String,Integer>> list=new ArrayList<Map.Entry<String,Integer>>(enteries);	
		/* for(Entry<String, Integer> entry : list){
			 System.out.println(entry.getKey()+" "+entry.getValue());
		 }*/
		 Collections.sort(list,new Comparator<Entry<String,Integer>>() {
			 @Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) { 
				return o2.getValue()-o1.getValue();
			}
		});
		 int max=0;
		 HashMap<String,Integer> tempmap=new HashMap<>();
		 for(Entry<String, Integer> entry : list){
			 if(entry.getValue()>max)max=entry.getValue();
			 if(max==entry.getValue()) {
				 tempmap.put(entry.getKey(),entry.getValue());
			 }
		 }
		 Set<Map.Entry<String,Integer>> tempenteries=tempmap.entrySet();
		 List<Map.Entry<String,Integer>> templist=new ArrayList<Map.Entry<String,Integer>>(tempenteries);	
		 Collections.sort(templist,new Comparator<Map.Entry<String,Integer>>() {
			 @Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) { 
				return o2.getKey().compareTo(o1.getKey());
			}
		});
		 int temp=0;
		 for(Entry<String, Integer> entry : templist){
			 System.out.println(entry.getKey()+" "+entry.getValue());
			 if(temp==0)break;
		 }
	}
}


/*
Adi 110
Adi 90
Bittu 110
Chintu 120
Pappu 120


Mohit 140
Sumit 140
Nishant 130
Yana 140
Ok 120
*/
