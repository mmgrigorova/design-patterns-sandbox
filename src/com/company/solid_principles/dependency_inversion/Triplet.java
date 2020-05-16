package com.company.solid_principles.dependency_inversion;

class Triplet<A,B,C>{
    A a;
    B b;
    C c;

    public Triplet(A a, B b, C c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Triplet() {
    }

    public A getValue0(){
        return a;
    }    public B getValue1(){
        return b;
    }    public C getValue2(){
        return c;
    }
}
