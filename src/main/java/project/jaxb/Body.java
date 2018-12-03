package project.jaxb;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@XmlRootElement(name = "Body")
@XmlAccessorType(XmlAccessType.NONE)
public class Body {
    @XmlElement(name = "sendPayment", namespace = "wsapi:Payment")
    SendPayment sendPayment;
}
