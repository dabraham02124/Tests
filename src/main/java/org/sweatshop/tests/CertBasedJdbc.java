package org.sweatshop.tests;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * This class demonstrates how to use a client cert for authenticating into a postgres jdbc DB.  This connection does
 * NOT use the system trust & key stores, but instead has its own (which can be the same as the system ones) defined
 * in the properties object.<P>
 *
 * Relevant information about each property required is in comments with that property.
 */
public class CertBasedJdbc {

    public static void main( String[] args ) throws SQLException, ClassNotFoundException
    {
        Class.forName("org.postgresql.Driver");

        try (Connection conn = createConnection();
             PreparedStatement pstmt = conn.prepareStatement("select XXXcolumn1XXX, XXXcolumn2XXX from XXXtableXXX limit 1;"))
        {
            ResultSet rset = pstmt.executeQuery();
            System.out.println("executed the query");
            while (rset.next()) {
                System.out.printf("XXXcolumn1XXX = %s, XXXcolumn2XXX = %s%n", String.valueOf(rset.getObject(1)), String.valueOf(rset.getObject(2)));
            }
        }
    }

    public static Connection createConnection() throws SQLException {
        Properties props = getDbProps();
        String uri = "jdbc:postgresql://XXXhostnameXXX/XXXdbnameXXX";
        System.out.printf("uri = \"%s\",props = %s%n", uri, props);
        return DriverManager.getConnection(uri, getDbProps());
    }

    private static Properties getDbProps() {
        Properties props = new Properties();

        // The name of the postgres role
        props.setProperty("user", "XXXpostgresRoleNameXXX");

        // Use SSL for authentication
        props.setProperty("ssl", "true");

        // This is a pem file that contains something that signed one of the certs that the server returns in its
        // chain.  This is the truststore.
        props.setProperty("sslrootcert","XXX/path/to/truststore.pemXXX");

        // This is a pem file that contains the client cert and chain up to the root, in that order.  The root may be
        // included, but does not need to be.  Also "the root" is code for "the relevant entry in the server's
        // truststore", which may not actually be a root cert.
        props.setProperty("sslcert","XXX/path/to/client/cert.completeXXX");

        // This is a pkcs8 file of the client cert's private key.  It can be created with:
        // pkcs8 -topk8 -inform PEM -outform DER -in /path/to/client/cert.private_key -out /path/for/client/cert.pk8
        // Note that the file _must_ be password protected, and that the password may not be the empty string
        props.setProperty("sslkey","XXX/path/to/client/cert.pkcs8XXX");
        props.setProperty("sslpassword","XXXpasswordToPkcs8FileXXX");

        // This is the mode that verifies _everything_.  See https://www.postgresql.org/docs/current/libpq-ssl.html
        props.setProperty("sslmode","verify-full");

        // If you need to debug the postgres connection, uncomment this line.
        // See https://jdbc.postgresql.org/documentation/head/logging.html for details
//        props.setProperty("loggerLevel","TRACE");

        // If the above doesn't do it and you need to debug the ssl handshake, uncomment these lines.
        // It gives WAY too much detail, but I couldn't find anything better...
//             System.setProperty("javax.net.debug", "all");
//             props.setProperty("loglevel", "2");

        return props;
    }

}
