package com.jijil.designpatterns;


import static com.jijil.designpatterns.Shape.*;

public class SimpleFactory {



    public Shape generateShape(String shape){

        if(shape ==  null) {
             return null;
        }

        switch (shape) {

            case CIRCLE :
                return  new Circle();
            case SQUARE :
                return new Square();
            case RECTANGLE:
                return new Rectangle();
            default:
                  throw new IllegalArgumentException(shape);

        }

    }


}

class FactoryClient {

    public static void main(String[] args) {
        //Create a Factory class
        SimpleFactory sfc = new SimpleFactory();

        //Call generateShape Method of Factory , Returns a Shape Impl
        Shape shape = sfc.generateShape("circle");

        //Call draw method of Shape Impl
        shape.draw();
        sfc.generateShape("square").draw();
    }

}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }
}

class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a shape");
    }
}

interface Shape {

    public static final String CIRCLE = "circle";
    public static final String SQUARE = "square";
    public static final String RECTANGLE = "rectangle";

    void draw();


}




