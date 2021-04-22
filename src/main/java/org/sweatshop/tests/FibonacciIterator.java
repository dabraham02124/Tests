package org.sweatshop.tests;

import java.util.Iterator;

public class FibonacciIterator implements Iterator<Integer> {

    private boolean first = true;
    private int nMinusTwo = 0;
    private int nMinusOne = 1;

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Integer next() {
        if (first) {
            first = false;
            return 0;
        } else {
            int total = nMinusTwo + nMinusOne;
            nMinusTwo = nMinusOne;
            nMinusOne = total;
            return total;
        }
    }
}