package com.jijil.designpatterns;

public class Singleton {

    //Static Class variable
    private static Singleton instance ;

    public String value;


    //private constructor
    private Singleton(String value) {

        try {
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.value = value;


    }

    //Static method to get Instance of object. Returns existing instance if any
    public static Singleton getInstance(String val){
        if(instance == null) {
            instance = new Singleton(val);
        }

        return  instance;
    }


}


class TestClient {


    public static void main(String[] args) {



        Singleton singleton = Singleton.getInstance("Foo");
        Singleton anotherSingleton = Singleton.getInstance("Boo");

        System.out.println(singleton.value);
        System.out.println(anotherSingleton.value);
    }

}