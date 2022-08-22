package com.jijil.designpatterns.impl;

import com.jijil.designpatterns.intr.Shape;

public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}
