package DataTime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortingDate {
	public static void main(String[] args) {
		ArrayList<String> datestring=new ArrayList<String>();
		datestring.add("01/21/2013 03:13 PM");
		datestring.add("01/21/2013 04:37 PM");
		datestring.add("01/21/2013 10:41 AM");
		datestring.add("01/21/2013 10:48 AM");
		datestring.add("01/22/2013 06:16 AM");
		datestring.add("01/22/2013 06:19 AM");
		datestring.add("01/21/2013 05:19 PM");
		datestring.add("01/21/2013 05:19 PM");
		sortDate(datestring);
		for (String s : datestring)
		{
		    System.out.println(s);
		}
	}

	private static void sortDate(ArrayList<String> datestring) {
		DateFormat df=new SimpleDateFormat("MM/dd/yyyy hh:mm a");
		/*Collections.sort(datestring, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				try {
					return df.parse(o1).compareTo(df.parse(o2));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return 0;
			}
		});*/
		Collections.sort(datestring, (a,b)-> {
			try {
				return df.parse(a).compareTo(df.parse(b));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
		});
	}
}
