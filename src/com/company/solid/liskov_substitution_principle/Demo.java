package com.company.solid.liskov_substitution_principle;

public class Demo {
    public static void useIt(Rectangle r){
        int width = r.getWidth();
        r.setHeight(10);

        //area = width * 10
        System.out.println(
                "Expected area of " + (width * 10) +
                        ", got " + r.getArea()
        );
    }
}
