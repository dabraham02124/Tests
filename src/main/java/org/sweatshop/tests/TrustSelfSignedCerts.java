package org.sweatshop.tests;

import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509TrustManager;

public class TrustSelfSignedCerts {
    
    //interesting bits stolen from http://stackoverflow.com/questions/2642777/trusting-all-certificates-using-httpclient-over-https

    public static void main(String[] args) {
        setupTrustHandlerToAcceptSelfSignedCerts();
        
        //do anything connecting to a URL w/ a self signed cert

    }

    private static void setupTrustHandlerToAcceptSelfSignedCerts() {
        try { 
            HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier(){ 
                @Override public boolean verify(String hostname, SSLSession session) { 
                    return true; 
                }}); 
            SSLContext context = SSLContext.getInstance("TLS"); 
            context.init(
                    null, 
                    new X509TrustManager[] {
                            new X509TrustManager() { 
                                @Override public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {} 
                                @Override public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {} 
                                @Override public X509Certificate[] getAcceptedIssuers() { return new X509Certificate[0];}}}, 
                    new SecureRandom()); 
            HttpsURLConnection.setDefaultSSLSocketFactory(context.getSocketFactory()); 
        } catch (Exception e) { // should never happen 
            e.printStackTrace(); 
        } 
    }
}
