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
@XmlRootElement(name = "Envelope")
@XmlAccessorType(XmlAccessType.NONE)
public class Envelope {
    @XmlElement(name = "Body")
    private Body body;
}
