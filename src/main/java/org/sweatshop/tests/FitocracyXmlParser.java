package org.sweatshop.tests;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import lombok.SneakyThrows;

import javax.xml.parsers.*;
import java.io.*;

public class FitocracyXmlParser {

    private final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    private final DocumentBuilder builder = newDB(factory);

    public static void main(String[] args) throws SAXException, IOException {
        FitocracyXmlParser fxp = new FitocracyXmlParser();
        fxp.parse("/tmp/fito");

    }

    private void parse(String filename) throws SAXException, IOException {
        FileInputStream fileInputStream = new FileInputStream(filename);
        Document doc = builder.parse(fileInputStream);
        Element root = doc.getDocumentElement();
        //returns specific attribute
        String attribute = root.getAttribute("attributeName");

        //returns a Map (table) of names/values
        NamedNodeMap attributes = root.getAttributes();

        System.out.format("%, %s", attribute, attributes);
    }

    @SneakyThrows
    private DocumentBuilder newDB(DocumentBuilderFactory factory2) {
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder;
    }

}
