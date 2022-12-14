package com.jijil.designpatterns;

public class FacadePattern {
    // Client / Demo Class


    public static void main(String[] args) {

        ShapeMaker shapeMaker = new ShapeMaker();
        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
// Here , shapeMaker not returning ShapeObject like Factory pattern , Returns null. Using the shapeMaker Oject , calling different functioanlities from client itself.

    }

}


class ShapeMaker {
    Circle circle;
    Rectangle rectangle;


// Constructor creates Circle , Rectangles all shapes
    public ShapeMaker(){

        this.circle = new Circle();
        this.rectangle = new Rectangle();

    }

    public void drawCircle() {

       this.circle.draw();

    }

    public void drawRectangle() {
        this.rectangle.draw();
    }
}
