package org.sweatshop.kids;

public class ArrayTest {
    
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        
        print(array);
        
        changeElements(array);
        print(array);
        
        changeArray(array);
        print(array);
    }

    private static void changeArray(int[] array) {
        array = new int[]{65,65,65,65};
    }

    private static void changeElements(int[] array) {
        array[2] = 47;
    }

    private static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.format("a[%s] = %s, ", i, array[i]);
        }
        System.out.println();
    }

    
    
}
