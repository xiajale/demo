package com.huawei.cloud.metadata;

import com.huawei.cloud.util.FileUtil;
import org.opensaml.core.xml.XMLObject;
import org.opensaml.core.xml.config.XMLObjectProviderRegistrySupport;
import org.opensaml.core.xml.io.Unmarshaller;
import org.opensaml.core.xml.io.UnmarshallingException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * Created by zhouyibin on 2017/12/5.
 */
public class IDPMetadataHandler {

    private static final String IDP_METADATA_PATH = IDPMetadataFact.class.getClassLoader().getResource("idp-metadata.xml").getPath();

    public static XMLObject getIDPMetadataXMLObject(){
        String content = FileUtil.readFile(IDP_METADATA_PATH);

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setNamespaceAware(true);

        DocumentBuilder docBuilder = null;
        try {
            docBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        Document document = null;
        try {
            document = docBuilder.parse(new ByteArrayInputStream(content.trim().getBytes()));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Element element = document.getDocumentElement();
        Unmarshaller unmarshaller = XMLObjectProviderRegistrySupport.getUnmarshallerFactory().getUnmarshaller(element);
        XMLObject xmlObject = null;
        try {
            xmlObject = unmarshaller.unmarshall(element);
        } catch (UnmarshallingException e) {
            e.printStackTrace();
        }

        return xmlObject;
    }

    public static void main(String[] args) {
        XMLObject xmlObject = getIDPMetadataXMLObject();
        System.out.println(xmlObject);
    }
}
