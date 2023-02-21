package com.jijil.interviwQns;

import java.util.*;
import java.util.function.Predicate;

public class SortHashMapBasedOnValue {


    public static void main(String[] args) {

        //Note the use of Record
        record Employee (String empName, Long empId , Double empSalary) {};

        Map<String,Employee> empMap = new HashMap<>();
        empMap.put("hr", new Employee("Jijil" , 25L , 2000D));
        empMap.put("dev", new Employee("Ammu" , 12L , 2000D));
        empMap.put("qas", new Employee("Appu" , 22L , 2000D));
        empMap.put("footballer", new Employee("Ziyech" , 22L , 2000D));


        System.out.println(empMap);

        List<Map.Entry<String, Employee>> listOfEmp = new LinkedList<> (empMap.entrySet());




        Collections.sort(listOfEmp, new Comparator<Map.Entry<String, Employee>>() {
            @Override
            public int compare(Map.Entry<String, Employee> o1, Map.Entry<String, Employee> o2) {
                return o1.getValue().empName().compareTo(o2.getValue().empName());
            }
        });

        Map<String, Employee> linkedHashEmpMap = new LinkedHashMap<>();
        for (Map.Entry<String,Employee> entry : listOfEmp){

            linkedHashEmpMap.put(entry.getKey(),entry.getValue());

        }

        System.out.println(linkedHashEmpMap);
    }
}
