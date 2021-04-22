package org.sweatshop.tests;

public class LambdaTest {
    
    public static interface Foo {
        public void execute();
    }
    
    public static void run(Foo f) {
        f.execute();
    }
    
    
    public static void main(String[] args) {
        run(() -> { 
            alpha();
            beta();    
            gamma();
        });
        
    }

    private static void alpha() {
        System.out.println("alpha");
    }
    private static void beta() {
        System.out.println("beta");
    }
    private static void gamma() {
        System.out.println("gamma");
    }

}
