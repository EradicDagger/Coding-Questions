package GreedyAlgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JobSequencing {
	char jobId;
	int deadline;
	int profit;
	public JobSequencing(char jobId, int deadline, int profit) {
		this.jobId = jobId;
		this.deadline = deadline;
		this.profit = profit;
	}
	public static void main(String[] args) {
		List<JobSequencing> arrayList=new ArrayList<JobSequencing>();
		JobSequencing ob1=new JobSequencing('a', 2, 100);
		JobSequencing ob2=new JobSequencing('b', 1, 19);
		JobSequencing ob3=new JobSequencing('c', 2, 27);
		JobSequencing ob4=new JobSequencing('d', 1, 25);
		JobSequencing ob5=new JobSequencing('e', 3, 15);

		arrayList.add(ob1);
		arrayList.add(ob2);
		arrayList.add(ob3);
		arrayList.add(ob4);
		arrayList.add(ob5);
		Collections.sort(arrayList,new Comparator<JobSequencing>() {
			@Override
			public int compare(JobSequencing o1, JobSequencing o2) {
				return o2.profit-o1.profit;
			}
		});
		for(JobSequencing js:arrayList) {
			System.out.println(js.profit+" "+js.deadline+" "+js.jobId);
		}
		boolean slots[]=new boolean[5];
		char sechdule[]=new char[5];
		for(int i=0;i<arrayList.size();i++) {
			for(int j=arrayList.get(i).deadline-1;j>=0;j--) {
				if(slots[j]==false) {
					slots[j]=true;
					sechdule[j]=arrayList.get(i).jobId;
					break;
				}
			}
		}
		for(int i=0;i<5;i++) {
			if(slots[i])System.out.println(sechdule[i]);
		}
	}
}

