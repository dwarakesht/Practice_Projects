package org.example;

public class Implementation  implements Contract{

    @Override
    public void term1() {
        System.out.println("TERM:1");
    }

    @Override
    public void term2() {
        System.out.println("TERM:2");
    }
}
