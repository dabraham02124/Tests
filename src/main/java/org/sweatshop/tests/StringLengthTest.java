package org.sweatshop.tests;

public class StringLengthTest {

    public static void main(String[] args) {
        String url = "jdbc:postgresql://rdbmsExa-2.nss1.tn.example.com/exa-prod?user=exa-prod&ssl=true&sslrootcert=/a/etc/ssl_ca/example_ca_list.pem&sslcert=/a/exa/var/exa_processor_db_cert.complete&sslkey=/a/exa/var/exa_processor_db_cert.pkcs8&sslpassword=example&sslmode=verify-ca";
        int location = 18;
        System.out.println(url.substring(location, url.indexOf("/", location)));
    }
}
