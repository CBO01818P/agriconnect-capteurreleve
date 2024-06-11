package ag.capteurreleve.entities;

import ag.capteurreleve.transientObj.Capteur;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "agriconnect-capteur")
public interface ClientCapteur {
    @GetMapping("/api/capteurs")
    List<ClientCapteur> getAllCapteurs();

    @GetMapping("/api/capteurs/{id}")
    Capteur findById(@PathVariable("id") Long id);

    @GetMapping("/api/capteurs/mesure/{id}")
    ClientCapteur getMesure(@PathVariable("id") Long id);

}
