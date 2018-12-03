package project.jaxb;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@XmlRootElement(name = "SendPayment")
@XmlAccessorType(XmlAccessType.NONE)
public class SendPayment {
    @XmlElement
    String token;

    @XmlElement
    String cardNumber;

    @XmlElement
    String requestId;

    @XmlElement
    String amount;

    @XmlElement
    String currency;

    @XmlElement(name = "account", namespace = "wsapi:Utils")
    ArrayList<Account> accounts = new ArrayList<>();

    @XmlElement
    Integer page;

    @XmlElement(name = "field")
    ArrayList<Field> fields = new ArrayList<>();
}
