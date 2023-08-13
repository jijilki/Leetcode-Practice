package com.jijil.interviwQns;

import java.util.*;
import java.util.stream.Collectors;

public class ComparatorVsComparable {

    public static void main(String[] args) {
        Car car1 = new Car(2000,"Hyundai","Creta");
        Car car2 = new Car(2010,"Maruthi","Baleno");
        Car car3 = new Car(2021,"Hyundai","Creta");
        Car car4 = new Car(2021,"Honda","Jazz");

        /**Comparable impl*/
        List<Car> cars = Arrays.asList(car3, car2, car1, car4);
        Collections.sort(cars); // For sorting List
        System.out.println(cars);

        /**Comparator example*/
        cars.sort(new CarModelComparator());
        System.err.println(cars);

    }

}


class CarYearComparator implements Comparator<Car> {


    @Override
    public int compare(Car o1, Car o2) {
        return o1.getYear().compareTo(o2.getYear());
    }

}

class CarModelComparator implements Comparator<Car> {


    @Override
    public int compare(Car o1, Car o2) {
        return o1.getModel().compareTo(o2.getModel());
    }

}


class Car implements Comparable<Car> {

    public Car(Integer year, String make, String model) {
        this.year = year;
        this.make = make;
        this.model = model;
    }

    private Integer year;
    private String make;
    private String model;

    private String color;
    private boolean isManual;

    private boolean hasAbs;




    @Override
    public int compareTo(Car car) {
      if(this.year.compareTo(car.year) != 0){
          return this.year.compareTo(car.year);
      }else if(this.make.compareTo(car.make) != 0) {
          return this.make.compareTo(car.make);
      }else {
         return this.model.compareTo(car.model);
      }

    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public boolean isManual() {
        return isManual;
    }

    public void setManual(boolean manual) {
        isManual = manual;
    }

    public boolean isHasAbs() {
        return hasAbs;
    }

    public void setHasAbs(boolean hasAbs) {
        this.hasAbs = hasAbs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car car)) return false;
        return Objects.equals(year, car.year) && Objects.equals(make, car.make) && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, make, model);
    }

    @Override
    public String toString() {
        return "Car{" +
                "year=" + year +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", isManual=" + isManual +
                ", hasAbs=" + hasAbs +
                '}';
    }
}
