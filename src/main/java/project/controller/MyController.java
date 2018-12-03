package project.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import project.jaxb.Envelope;
import project.model.ModelXml;
import project.service.XmlToJava;

import javax.xml.bind.JAXBException;
import javax.xml.bind.UnmarshalException;


@Controller
public class MyController {
    Logger log = (Logger) LogManager.getLogger(MyController.class);

    @Autowired
    XmlToJava xmlToJava;

    @RequestMapping(value = "/getData", method = RequestMethod.POST)
    public ModelAndView getData(@ModelAttribute("data") ModelXml modelXml) throws JAXBException, JsonProcessingException {
        ModelAndView model = new ModelAndView();
        Envelope envelope = xmlToJava.xmlToPojo(modelXml.getXml());
        log.info(envelope);
        ObjectMapper mapper = new ObjectMapper();
        log.info(mapper.writeValueAsString(envelope));

        model.addObject("envelopeJson", mapper.writeValueAsString(envelope));
        model.addObject("envelope", envelope);
        model.setViewName("resultForm");
        return model;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String startPage(@ModelAttribute("data") ModelXml modelXml) {
        return "index";
    }

    @ExceptionHandler(UnmarshalException.class)
    @ResponseBody
    @RequestMapping
    public ModelAndView handleStorageFileNotFound(UnmarshalException exc) {
        ModelAndView view = new ModelAndView();
        String excMessage = exc.toString();
        log.info(excMessage);
        view.addObject("excMessage", excMessage);
        view.setViewName("exceptionPage");
        return view;
    }

}
