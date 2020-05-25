package com.company.design_patterns.bridge;

public abstract class Shape
{
    protected Renderer renderer;
    public Shape(Renderer renderer){
        this.renderer = renderer;
    }
    public abstract String getName();
}

