package org.sweatshop.kids;

public class Histogrammer {
    
    public static int[] countDigits(String in) {
        int[] array = new int[10];
        if (null != in) {
            in.chars().forEach(c -> array[Integer.valueOf(c - '0')]++);
        }
        return array;
    }
    
    public static String lateralHistogram(String in) {
        int[] array = countDigits(in);
        
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            sb.append(i).append("| ");
            for (int j = 0; j < array[i]; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        
        return sb.toString();
    }

    public static String verticalHistogram(String in) {
        int[] array = countDigits(in);
        
        int max = max(array);
        
        StringBuffer sb = new StringBuffer();
        for (int i = max; i > 0; i--) {
            sb.append(i).append(" | ");
            for (int j = 0; j < 10; j++) {
                if (i <= array[j]) {
                    sb.append("* ");
                } else {
                    sb.append("  ");
                }
            }
            sb.append("\n");
        }
        
        sb.append("  ---------------------\n    0 1 2 3 4 5 6 7 8 9");
        
        return sb.toString();
    }
    
    public static int max(int[] array) {
        int max = array[0];
        
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max, array[i]);
        }
        
        return max;
    }
}
