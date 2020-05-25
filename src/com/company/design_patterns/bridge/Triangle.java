package com.company.design_patterns.bridge;

public class Triangle extends Shape
{
    public Triangle(Renderer renderer){
        super(renderer);
    }

    @Override
    public String getName()
    {
        return "Triangle";
    }

    @Override
    public String toString()
    {
        return String.format("Drawing %s as %s", getName(), renderer.whatToRenderAs());
    }
}