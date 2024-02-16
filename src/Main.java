import com.jijil.leetcode.LongestPalindrome;


import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        LongestPalindrome lp = new LongestPalindrome();

        String palindrome = lp.longestPalindrome("malayalam");
        logger.log(Level.INFO, "Longest palindrome in String is {0} " , palindrome);


        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(100, "Sundar", 47, "North America", 10000));
        employeeList.add(new Employee(200, "Pichai", 25, "North America", 50000));
        employeeList.add(new Employee(300, "Larry", 30, "Asia", 20000));
        employeeList.add(new Employee(400, "Page", 59, "Africa",18000));

        List<String> listOfEmpNameHavingMore20KSal = employeeList.stream().filter(x -> x.getSal() > 20000).map(x -> x.getName()).collect(Collectors.toList());
        System.out.println(listOfEmpNameHavingMore20KSal);

        Comparator<Employee> employeeComparator = (Employee e1 , Employee e2) ->  e1.getRegion().compareTo(e2.getRegion());


        List<Employee> sortedList = employeeList.stream().sorted(employeeComparator).collect(Collectors.toList());
        System.out.println(sortedList);


        Map<String,Employee> empMap = new HashMap<>();

        employeeList.stream().forEach(e-> empMap.put(e.getName(),e));

        System.out.println(empMap);




    }
}

class Employee {
    private int id;
    private String name;
    private int age;
    private String region;
    private double sal;
    public Employee(int id, String name, int age, String region, double sal) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.region = region;
        this.sal = sal;
    }


// Standard setters and getters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", region='" + region + '\'' +
                ", sal=" + sal +
                '}';
    }
}

