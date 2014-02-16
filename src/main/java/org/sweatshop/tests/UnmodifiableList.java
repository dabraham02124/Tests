package org.sweatshop.tests;

import java.util.Collections;
import java.util.List;

public class UnmodifiableList {

    public static void main(String[] args) {
        List<?> list = Collections.emptyList();
        System.out.println(list);
    }
    
}
