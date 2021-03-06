package org.sweatshop.tests;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class VarArgsTester {

    private static void printVarArgs(String sOne) {
        System.out.println("only one "+sOne);
    }

    private static void printVarArgs(String sOne, String... args) {
        System.out.print(sOne+" ");

        for (String arg : args) {
            System.out.print(arg+" ");
        }
        System.out.println();
    }

    private static String listOfArgs(int first, int... args) {
        StringBuffer sb = new StringBuffer();
        sb.append(first);
        for (int arg: args) {
            sb.append(",").append(arg);
        }

        return sb.toString();
    }

    private static boolean allValidLists(List<?>... lists) {
        for (List<?> list : lists) {
            if (null == list || 0 == list.size()) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        printVarArgs("foo", "bar", "baz");
        printVarArgs("foo", "bar");
        printVarArgs("foo");
//        printVarArgs();
        printVarArgs((String)null);
        printVarArgs((String)null, (String)null);
        printVarArgs("foo", null, "baz");
        printVarArgs("foo", "bar", null);


        System.out.println(listOfArgs(1));
        System.out.println(listOfArgs(1,2,3,4));


        List<String> stringList = new LinkedList<>();
        List<Object> objectList = null;
        System.out.println(allValidLists(stringList, objectList));
        stringList.add("foo");
        System.out.println(allValidLists(stringList, objectList));
        objectList = new ArrayList<>();
        System.out.println(allValidLists(stringList, objectList));
        objectList.add("bar");
        System.out.println(allValidLists(stringList, objectList));
        stringList.remove("foo");
        System.out.println(allValidLists(stringList, objectList));
        stringList = null;
        System.out.println(allValidLists(stringList, objectList));
    }
}
