package com.jijil.designpatterns.impl;

import com.jijil.designpatterns.intr.Shape;

public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }
}
