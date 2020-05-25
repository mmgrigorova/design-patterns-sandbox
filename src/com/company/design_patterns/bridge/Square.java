package com.company.design_patterns.bridge;

public class Square extends Shape
{
    public Square(Renderer renderer){
        super(renderer);
    }
    @Override
    public String getName()
    {
        return "Square";
    }
    @Override
    public String toString()
    {
        return String.format("Drawing %s as %s", getName(), renderer.whatToRenderAs());
    }
}
