package com.jijil.designpatterns;

import com.jijil.designpatterns.impl.Circle;
import com.jijil.designpatterns.impl.Square;
import com.jijil.designpatterns.intr.Shape;
import com.jijil.designpatterns.impl.Rectangle;

import static com.jijil.designpatterns.intr.Shape.*;

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
