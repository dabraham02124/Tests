package org.sweatshop.tests;

public class GetFirstNNonBlankLinesOfString {

    public static void main(String[] args) {
        String firsts = getFirstLinesOfString(2, "   \nfoo   \n         \nbar\nbaz");
        
        System.out.println("begin");
        System.out.println(firsts);
        System.out.println("end");
    }
    
    
    
    
    private static String getFirstLinesOfString(int lines, String in) {
        StringBuffer returnBuffer = new StringBuffer();
        boolean started = false;
        
        for (int start = 0, linesCopied = 0; linesCopied < lines; ) {
            int newLine = in.indexOf("\n", start); 
            if (-1 == newLine) {
                String currentLine = in.substring(start).trim();
                appendLineToBuffer(returnBuffer, started, currentLine);
                break;
            }
            String currentLine = in.substring(start, newLine).trim();
            if (appendLineToBuffer(returnBuffer, started, currentLine)) {
                started = true;
                linesCopied += 1;
            }
            start = newLine + 1;
        }
        
        return returnBuffer.toString();
    }
    
    private static boolean appendLineToBuffer(StringBuffer sb, boolean started, String line) {
        if ("".equals(line)) {
            return false;
        }
        if (started) {
            sb.append("\n");
        }
        sb.append(line);
        return true;
    }
    
}
