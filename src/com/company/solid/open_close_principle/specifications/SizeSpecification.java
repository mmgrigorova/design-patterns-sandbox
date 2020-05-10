package com.company.solid.open_close_principle.specifications;

import com.company.solid.open_close_principle.Product;
import com.company.solid.open_close_principle.enums.Size;

public class SizeSpecification implements Specification<Product> {
    private Size size;

    public SizeSpecification(Size size) {
        this.size = size;
    }

    @Override
    public boolean isSatisfied(Product item) {
        return item.getSize() == size;
    }
}
