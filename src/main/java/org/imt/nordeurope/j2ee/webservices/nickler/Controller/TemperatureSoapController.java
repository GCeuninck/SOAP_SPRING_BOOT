package org.imt.nordeurope.j2ee.webservices.nickler.Controller;

import org.imt.nordeurope.j2ee.webservices.nickler.Model.Temperature;
import org.imt.nordeurope.j2ee.webservices.nickler.client.TemperatureSoapWebService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;
import java.time.LocalDate;


@Controller
public class TemperatureSoapController {

    Temperature temperature;

    @RequestMapping(value = { "/", "/temperature" }, method = RequestMethod.GET)
    public String getTemperature(Model model) throws Exception {

        URL url = new URL("http://localhost:9000/TemperatureSoapWebService?wsdl");
        QName qname = new QName("http://nickler.webservices.j2ee.nordeurope.imt.org/", "TemperatureSoapWebService");
        Service service = Service.create(url, qname);
        TemperatureSoapWebService temperatureSoapWebService = service.getPort(TemperatureSoapWebService.class);

        XMLGregorianCalendar today = DatatypeFactory.newInstance().newXMLGregorianCalendar(LocalDate.now().toString());

        String country = "France";

        Integer temperature = temperatureSoapWebService.getTemperature(country, today);

        Temperature temp = new Temperature(temperature, country, today.toGregorianCalendar().getTime());
        model.addAttribute("temp", temp);

        return "temperature";
    }

}
