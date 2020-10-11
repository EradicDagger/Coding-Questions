package com.java2novice.treeset;
 
import java.util.Comparator;
import java.util.TreeSet;
 
public class GetLeastElementInSet {
 
    public static void main(String a[])
        { 
        TreeSet<Empl1> comp = new TreeSet<Empl1>(new Comparing());
        comp.add(new Empl1("Ajay",2100));
        comp.add(new Empl1("Anil",8700));
        comp.add(new Empl1("Arun",2000));
        comp.add(new Empl1("Abhi",3400));
        System.out.println("Least salary emp: "+comp.first());
    }
}
 
class Comparing implements Comparator<Empl1>{
 
    @Override
    public int compare(Empl1 e1, Empl1 e2) {
        if(e1.getSalary() > e2.getSalary()){
            return 1;
        } else {
            return -1;
        }
    }
}
 
class Empl1{
     
    private String name;
    private int salary;
     
    public Empl1(String n, int s){
        this.name = n;
        this.salary = s;
    }
     
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public String toString(){
        return "Name: "+this.name+"-- Salary: "+this.salary;
    }
}
