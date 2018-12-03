package project.jaxb;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.xml.bind.annotation.*;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@XmlRootElement(name = "SendPayment")
@XmlAccessorType(XmlAccessType.NONE)
public class Account {
    @XmlValue
    String account;

    @XmlAttribute
    String type;
}
