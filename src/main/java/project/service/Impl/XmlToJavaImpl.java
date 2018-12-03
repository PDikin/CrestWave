package project.service.Impl;

import org.springframework.stereotype.Service;
import project.jaxb.Envelope;
import project.service.XmlToJava;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

@Service
public class XmlToJavaImpl implements XmlToJava {
    public Envelope xmlToPojo(String xmldata) throws JAXBException {
        StringReader reader = new StringReader(xmldata);

        JAXBContext context = JAXBContext.newInstance(Envelope.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        Envelope envelope = (Envelope) unmarshaller.unmarshal(reader);

        return envelope;
    }
}
