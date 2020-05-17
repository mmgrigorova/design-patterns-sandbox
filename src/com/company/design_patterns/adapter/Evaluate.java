package com.company.design_patterns.adapter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Evaluate
{
    @Test
    public void test()
    {
        Square sq = new Square(11);
        SquareToRectangleAdapter adapter = new SquareToRectangleAdapter(sq);
        assertEquals(121, adapter.getArea());
    }
}

