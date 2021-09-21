package org.sweatshop.tests;

public class ModGrid {
    
    public static void main(String[] args) {
        System.out.println(getModGrid(7,5));
    }

    private static String getModGrid(int modded, int modBy) {
        StringBuffer sb = new StringBuffer();

        sb.append("\t");
        for (int i = 0; i < modded; i++) {
            sb.append(modded - i).append("\t");
        }
        sb.append("\n");
        
        for (int i = 0; i < modBy; i++) {
            sb.append(modBy - i).append("\t");
            for (int j = 0; j < modded; j++) {
                sb.append((modded - j) % (modBy - i)).append("\t");
            }
            sb.append("\n");
        }
        
        return sb.toString();
    }
}
