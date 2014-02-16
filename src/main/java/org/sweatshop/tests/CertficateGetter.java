package org.sweatshop.tests;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class CertficateGetter {

    
  /**
   * Returns the top level cert for a given server.  Should generally be called with "www.example.com" 
   * and 443.  Stolen flat out from http://www.xinotes.org/notes/note/1088/
   * @param host
   * @param port
   * @return
   * @throws IOException
   * @throws CertificateException
   * @throws NoSuchAlgorithmException
   * @throws KeyManagementException
   */
  public static X509Certificate getHostCertificate(String host, Integer port) throws IOException, CertificateException, NoSuchAlgorithmException, KeyManagementException {
      //get the cert chain
      java.security.cert.Certificate[] serverCerts = getHostCertificateChain(host, port);
      
      //transform it into a 509 cert
      CertificateFactory cf = CertificateFactory.getInstance("X.509");
      X509Certificate x509Certificate = (X509Certificate) cf.generateCertificate(new ByteArrayInputStream(serverCerts[0].getEncoded()));
      return x509Certificate;
  }

  private static Certificate[] getHostCertificateChain(String host, Integer port) throws UnknownHostException, IOException, NoSuchAlgorithmException, KeyManagementException {
   // create custom trust manager to ignore trust paths
      TrustManager trm = new X509TrustManager() {
          public X509Certificate[] getAcceptedIssuers() { return null;}
          public void checkClientTrusted(X509Certificate[] certs, String authType) {}
          public void checkServerTrusted(X509Certificate[] certs, String authType) {}
      };

      //set up the context & Trust Manager
      SSLContext sc = SSLContext.getInstance("SSL");
      sc.init(null, new TrustManager[] { trm }, null);
      SSLSocketFactory factory = sc.getSocketFactory();
      
      //create the socket just enough to get the certs
      try (SSLSocket socket = (SSLSocket)factory.createSocket(host, port)) {
          socket.startHandshake();
          SSLSession session = socket.getSession();
          Certificate[] serverCerts = session.getPeerCertificates();
          
//          System.out.println("There are "+serverCerts.length+" certs in the chain");
//          for (Certificate cert : serverCerts) {
//              System.out.print("-----BEGIN CERTIFICATE-----\n");
//              System.out.println(cert);
//              System.out.print("\n-----END CERTIFICATE-----\n");
//          }
          
          return serverCerts;
      }
  }
  
  public static void main(String[] args) throws CertificateException, IOException, KeyManagementException, NoSuchAlgorithmException {
      X509Certificate cert = getHostCertificate("www.sears.com", 443);
      
      System.out.print(cert);

  }

}
