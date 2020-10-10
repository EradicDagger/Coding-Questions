package GreedyAlgorithms;

import java.util.*;
public class FractionalKnapSack{
	int weight,values;
	public FractionalKnapSack(int a,int b) {
		values=a;
		weight=b;
	}
	public static void main(String[] args)  {
		FractionalKnapSack ob1=new FractionalKnapSack(60,10);
		FractionalKnapSack ob2=new FractionalKnapSack(100,20);
		FractionalKnapSack ob3=new FractionalKnapSack(120,30);
		List<FractionalKnapSack> list=new ArrayList<FractionalKnapSack>();
		list.add(ob1);
		list.add(ob2);
		list.add(ob3);
		Collections.sort(list,new Comparator<FractionalKnapSack>() {
			@Override
			public int compare(FractionalKnapSack arg0, FractionalKnapSack arg1) {
				return arg1.values/arg1.weight - arg0.values/arg0.weight;
			}		
		});
		int capacity=50;
		int weight=0;
		int value=0;
		for (FractionalKnapSack i : list) {
			if(weight+i.weight < capacity) {
				weight=weight+i.weight;
				value+=i.values;
			}
			else {
				int temp=capacity-weight;
				value+=i.values * ((double)temp/i.weight);
				break;
			}
	    }
		System.out.println(value);
	}
}

