package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Application {
    public static void main( String[] args )
    {
        Contract contract = new Implementation();
        contract.term1();
        contract.term2();

        Collection<String> c = new ArrayList<>();
        c.addAll(List.of("cricket","badminton","football"));
        System.out.println(c);

    }
}
