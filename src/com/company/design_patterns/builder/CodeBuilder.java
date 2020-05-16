package com.company.design_patterns.builder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CodeBuilder {
    private String className;
    private List<Field> fields = new ArrayList<>();

    public CodeBuilder(String className) {
        this.className = className;
    }

    public CodeBuilder addField(String name, String type) {
        fields.add(new Field(name, type));
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("public class %s\n", className));
        sb.append("{\n");
        fields.forEach(sb::append);

        sb.append("}");
        return sb.toString();
    }
}
