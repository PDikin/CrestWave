package project.jaxb;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@XmlRootElement(name = "field")
public class Field {
    @XmlAttribute
    Integer id;

    @XmlAttribute
    String value;
}
