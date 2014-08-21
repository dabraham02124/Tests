package org.sweatshop.tests;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.sweatshop.tests.Java7Tester;
import org.testng.annotations.Test;

public class Java7TesterTest {

//    uncomment the following two methods to test whether dependsOnMethods really skips a test when the dependsOn test fails. 
//    @Test
//    public void bar() {
//        throw new RuntimeException("Test not implemented");
//    }
//
//    @Test(dependsOnMethods={"bar"})
//    public void binaryLiteral() {
//        throw new RuntimeException("Test not implemented");
//    }

    @Test
    public void inferGenerics() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException {
        assert (new Integer(0).equals(returnStaticPrivate(Java7Tester.class, "inferGenerics")));
        //    new Java7Tester().inferGenerics();
    }

    public Object returnStaticPrivate(String className, String methodName, Object... args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
        return returnStaticPrivate(Class.forName(className), methodName, args);
    }
    public Object returnStaticPrivate(Class<?> clazz, String methodName, Object... args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        final Method method = clazz.getDeclaredMethod(methodName);
        method.setAccessible(true);
        return method.invoke(method, args);
    }

    @Test
    public void underScoresInLiterals() {
        @SuppressWarnings("unused")
        int foo = 5_000_000;
    }
}
