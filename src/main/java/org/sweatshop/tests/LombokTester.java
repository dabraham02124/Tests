package org.sweatshop.tests;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j @EqualsAndHashCode
public class LombokTester {


    @Getter @Setter private int age = 10;


    public static void main(String[] args) {
        LombokTester lt = new LombokTester();
        
        System.out.println(lt.getAge());
        lt.setAge(43);
        System.out.println(lt.getAge());
        
        log.error("foo");
        
        LombokTester lt2 = new LombokTester();
        lt2.setAge(41);
        
        if (lt2.equals(lt)) {
            //we get this w & without @EqualsHashCode
            System.out.println("equals");
        } else {
            System.out.println("not equals");
        }
        
        //we get 74 with @EqualsHashCode, and 966745481 without
        System.out.println(lt.hashCode());
    }

}
