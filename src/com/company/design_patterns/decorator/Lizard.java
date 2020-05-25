package com.company.design_patterns.decorator;
class Lizard
{
    public int age;

    public String crawl()
    {
        return (age > 1) ? "crawling" : "too young";
    }

    public void setAge(int age){
        this.age = age;
    }
}
