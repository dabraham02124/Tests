package org.sweatshop.tests;

import java.util.List;

public class Return {

    public static interface Inter <T extends Inter<?>> {
        public T getInter();
        public List<T> getInterList();
    }

    public static class Impl implements Inter<Impl> {

        @Override
        public Impl getInter() {
            return null;
        }

        @Override
        public List<Impl> getInterList() {
            return null;
        }
    }


    public static void main(String[] args) {
        Impl impl = new Impl();
        System.out.println(impl);

        Inter<Impl> inter = new Impl();
        Impl i2 = (Impl) inter;
        Object o = null;
        Impl i3 = (Impl) o;
        System.out.println(i2 + "" + i3);
    }
}
