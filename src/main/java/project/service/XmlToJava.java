package project.service;

import project.jaxb.Envelope;

import javax.xml.bind.JAXBException;

public interface XmlToJava {
    Envelope xmlToPojo(String xmldata) throws JAXBException;
}
