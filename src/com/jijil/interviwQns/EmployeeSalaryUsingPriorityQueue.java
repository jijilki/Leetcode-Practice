package com.jijil.interviwQns;

import jdk.nio.mapmode.ExtendedMapMode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class EmployeeSalaryUsingPriorityQueue {

    public static void main(String[] args) {

        PriorityQueue<Employee> pq = new PriorityQueue<>();
        pq.add(new Employee(110,"Jackson",11450));
        pq.add(new Employee(111,"Palmer",21400));
        pq.add(new Employee(112,"Madueke",3650));
        pq.add(new Employee(113,"Mudryk",33200));

        while (pq.size() >0) {
            System.out.println(pq.poll());
        }

        //Priority queue using Comparator class
        Comparator nameComparator = new NameComparator();
        PriorityQueue<Employee> pqWithComparator = new PriorityQueue<>(10,nameComparator);
        pqWithComparator.add(new Employee(110,"Jackson",5544345));
        pqWithComparator.add(new Employee(111,"Maduke",1123));
        pqWithComparator.add(new Employee(112,"Anderson",3345));
        pqWithComparator.add(new Employee(114,"Zenith",11450));
        pqWithComparator.add(new Employee(108,"Yacko",3356));
        System.out.println("Printing Employee lis with Alphabatical name order");
        while (pqWithComparator.size()>0){
            System.out.println(pqWithComparator.poll());
        }
    }


}

class NameComparator implements Comparator<Employee>{

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getEmpName().compareTo(o2.getEmpName());
    }
}

class Employee implements Comparable<Employee>{

    private int empId;
    private String empName;
    private int empSal;

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Employee(int empId, String empName, int empSal) {
        this.empId = empId;
        this.empName = empName;
        this.empSal = empSal;
    }


    @Override
    public int compareTo(Employee o) {
        return o.empSal - this.empSal;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empSal=" + empSal +
                '}';
    }
}