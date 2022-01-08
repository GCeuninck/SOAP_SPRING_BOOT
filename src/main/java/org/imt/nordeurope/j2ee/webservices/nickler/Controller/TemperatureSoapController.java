package org.imt.nordeurope.j2ee.webservices.nickler.Controller;

import org.imt.nordeurope.j2ee.webservices.nickler.Model.Temperature;
import org.imt.nordeurope.j2ee.webservices.nickler.Model.TemperatureForm;
import org.imt.nordeurope.j2ee.webservices.nickler.client.TemperatureSoapWebService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @RequestMapping(value = { "/" }, method = RequestMethod.GET)
    public String index(Model model) {
        TemperatureForm temperatureForm = new TemperatureForm();
        model.addAttribute("temperatureForm", temperatureForm);
        return "index";
    }

    @RequestMapping(value = { "/temperature" }, method = RequestMethod.POST)
    public String getTemperature(Model model, @ModelAttribute("temperatureForm") TemperatureForm temperatureForm) throws Exception {

        String country = temperatureForm.getCountry();
        String date = temperatureForm.getDate();
        Temperature temp = null;

        if (country != null && !country.isEmpty()
                && date != null && !date.isEmpty()) {

            LocalDate todayLocal = date.equals("today") ? LocalDate.now() : LocalDate.now().minusDays(1);
            XMLGregorianCalendar today = DatatypeFactory.newInstance().newXMLGregorianCalendar(todayLocal.toString());

            URL url = new URL("http://localhost:9000/TemperatureSoapWebService?wsdl");
            QName qname = new QName("http://nickler.webservices.j2ee.nordeurope.imt.org/", "TemperatureSoapWebService");
            Service service = Service.create(url, qname);
            TemperatureSoapWebService temperatureSoapWebService = service.getPort(TemperatureSoapWebService.class);

            Integer temperature = temperatureSoapWebService.getTemperature(country, today);
            temp = new Temperature(temperature, country, today.toGregorianCalendar().getTime());
        }

        model.addAttribute("temp", temp);

        return "temperature";
    }

}
