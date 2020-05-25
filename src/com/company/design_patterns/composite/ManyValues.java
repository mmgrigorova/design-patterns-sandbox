package com.company.design_patterns.composite;

import java.util.ArrayList;

public class ManyValues extends ArrayList<Integer>
        implements ValueContainer {
    //don't have to implement ValueContainer as ArrayList already is iterable
}
