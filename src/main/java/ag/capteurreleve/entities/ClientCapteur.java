package ag.capteurreleve.entities;

import ag.capteurreleve.transientObj.Capteur;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "agriconnect-capteur")
public interface ClientCapteur {

    @RequestMapping(value = "/api/capteurs", method = RequestMethod.GET)
    List<ClientCapteur> getAllCapteurs();

    @RequestMapping(value = "/api/capteurs/{id}", method = RequestMethod.GET)
    Capteur findById(@PathVariable("id") Long id);

    @RequestMapping(value = "/api/capteurs/mesure/{id}", method = RequestMethod.GET)
    ClientCapteur getMesure(@PathVariable("id") Long id);

}
