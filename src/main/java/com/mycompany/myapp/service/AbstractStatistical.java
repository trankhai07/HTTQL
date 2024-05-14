package com.mycompany.myapp.service;



import io.undertow.util.BadRequestException;
import org.apache.fop.apps.FopFactory;
import org.apache.xmlgraphics.util.MimeConstants;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import org.springframework.core.io.ClassPathResource;

import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.net.URI;
import java.net.URISyntaxException;

import static java.lang.Boolean.FALSE;
import static net.sf.saxon.lib.FeatureKeys.ALLOWED_PROTOCOLS;
import static net.sf.saxon.lib.FeatureKeys.ALLOW_EXTERNAL_FUNCTIONS;
import static net.sf.saxon.lib.FeatureKeys.DTD_VALIDATION;

public abstract class AbstractStatistical {
    public static final String CONFIGURATION_XCONF = "configuration.xconf";

    public static final String FACTORY_IMPL = "net.sf.saxon.TransformerFactoryImpl";

    public void generateDocument(HttpServletResponse response, String xmlTemplate) throws BadRequestException {
        try {
            InputStream inputStream = new ClassPathResource(CONFIGURATION_XCONF).getInputStream();
            FopFactory fopFactory = FopFactory.newInstance(new URI("./"), inputStream);
            DefaultHandler defaultHandler = fopFactory.newFop(MimeConstants.MIME_PDF, response.getOutputStream()).getDefaultHandler();
            Source src = new StreamSource(new StringReader(xmlTemplate));
            Result result = new SAXResult(defaultHandler);
            TransformerFactory transformerFactory = TransformerFactory.newInstance(FACTORY_IMPL, null);
            transformerFactory.setFeature(DTD_VALIDATION, FALSE);
            transformerFactory.setFeature(ALLOW_EXTERNAL_FUNCTIONS, FALSE);
            transformerFactory.setAttribute(ALLOWED_PROTOCOLS, "");
            transformerFactory.newTransformer().transform(src, result);
        } catch (IOException | TransformerException | SAXException | URISyntaxException e) {
            throw new BadRequestException("Exception occured:", e);
        }
    }
}
