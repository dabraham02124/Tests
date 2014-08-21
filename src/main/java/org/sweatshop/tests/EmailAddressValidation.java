package org.sweatshop.tests;

import java.util.regex.Pattern;

import org.apache.commons.validator.routines.EmailValidator;

public class EmailAddressValidation {

    public static boolean isValidEmailAddress(String emailAddress) {
        String  expression="^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";  
        Pattern pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE); 
        
        return (emailAddress == null) ? false : pattern.matcher(emailAddress.trim()).matches();  
    }
    
    public static boolean isValidEmailAddress2(String email) {
        return EmailValidator.getInstance().isValid(email);
     }
    
    public static void main(String[] args) {
        System.out.println(isValidEmailAddress("a@foo.com"));
        System.out.println(isValidEmailAddress2("a@foo.com"));
        System.out.println(isValidEmailAddress2("+@foo.com"));
    }
    
}
