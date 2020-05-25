package com.company.design_patterns.decorator;

class Bird
{
    public int age;

    public String fly()
    {
        return age < 10 ? "flying" : "too old";
    }

    public void setAge(int age){
        this.age = age;
    }
}
