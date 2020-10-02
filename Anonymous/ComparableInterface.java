// Java Comparable interface is used to order the objects of user-defined class.
// This interface is found in java.lang package and contains only one method named compareTo(Object).

// Implementing Comparable Interface and overriding compareTo() to sort student records in java.

import java.util.ArrayList;
import java.util.Iterator;
import java.util.*;
 
public class ComparableInterfaceAndSort
{
    private static class student implements Comparable<student>{
        public int r;
        public String name;
        
        public student(int roll, String n){
            this.r = roll;
            this.name = n;
        }
        
        @Override
        public int compareTo(student t){
            if(this.r > t.r) return -1;
            if(this.r < t.r) return +1;
            return 0;
        }
        
        public String toString(){
            return "Student - " + "  RollNo:" + r + "   Name :" + name;  
        }
    }
    
    public static void main(String[] args)
    {
        ArrayList<student> al = new ArrayList<>();
        
        al.add(new student(1, "a"));
        al.add(new student(2, "b"));
        al.add(new student(3, "c"));
        al.add(new student(4, "d"));
        
        Collections.sort(al);
        
        Iterator itr = al.iterator();
    
        while(itr.hasNext()){
          student t = (student)itr.next();
          System.out.println(t.toString());
        }
    }
}
