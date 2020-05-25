package com.company.design_patterns.composite;

import java.util.ArrayList;
import java.util.Collection;

public class MyList extends ArrayList<ValueContainer> {
    public MyList(Collection<? extends ValueContainer> c) {
        super(c);
    }

    public int sum(){
        int result = 0;
        for(ValueContainer container : this){
            for(int value : container){
                result += value;
            }
        }
        return result;
    }
}
