package GreedyAlgorithms;

import java.util.*;

/*Activity Selection Problem*/
public class ActivitySelectionProblem {
	int start,finish;
	public ActivitySelectionProblem(int a,int b){
		start=a;
		finish=b;
	}
	public static void main(String[] args) {
		ActivitySelectionProblem[] asp=new ActivitySelectionProblem[6];
		asp[0]=new ActivitySelectionProblem(1,2);
		asp[1]=new ActivitySelectionProblem(3,4);
		asp[2]=new ActivitySelectionProblem(0,6);
		asp[3]=new ActivitySelectionProblem(5,7);
		asp[4]=new ActivitySelectionProblem(8,9);
		asp[5]=new ActivitySelectionProblem(5,9);
		List<ActivitySelectionProblem> list=new ArrayList<ActivitySelectionProblem>();
		list.add(asp[0]);
		list.add(asp[1]);
		list.add(asp[2]);
		list.add(asp[3]);
		list.add(asp[4]);
		list.add(asp[5]);
		Collections.sort(list,new Comparator<ActivitySelectionProblem>() {
			@Override
			public int compare(ActivitySelectionProblem arg0, ActivitySelectionProblem arg1) {
				return arg0.finish-arg1.finish;
			}
			
		});
		int j=0;
		System.out.println(list.get(j).start+" "+list.get(j).finish);
		for(int i=1;i<list.size();i++) {
			if(list.get(j).finish <= list.get(i).start) {
				System.out.println(list.get(i).start+" "+list.get(i).finish);
				j=i;
			}
		}
	}
}

