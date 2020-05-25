package com.company.design_patterns.decorator;

class Dragon
{
    private Bird bird;
    private Lizard lizard;


    Dragon(){
        bird = new Bird();
        lizard = new Lizard();
    }

    private int age;
    public void setAge(int age)
    {
        bird.setAge(age);
        lizard.setAge(age);
    }
    public String fly()
    {
        return bird.fly();
    }
    public String crawl()
    {
        return lizard.crawl();
    }
}