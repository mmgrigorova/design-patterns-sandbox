package com.company.solid.open_close_principle.specifications;

import com.company.solid.open_close_principle.Product;
import com.company.solid.open_close_principle.enums.Color;

public class ColorSpecification implements Specification<Product> {
    private Color color;

    public ColorSpecification(Color color) {
        this.color = color;
    }

    @Override
    public boolean isSatisfied(Product item) {
        return item.getColor() == color;
    }
}
