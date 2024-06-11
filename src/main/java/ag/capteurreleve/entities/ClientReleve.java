package ag.capteurreleve.entities;

import ag.capteurreleve.transientObj.Releve;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "ac-releve")
public interface ClientReleve {
    @RequestMapping(method = RequestMethod.GET, value = "/api/releves/capteur/{id}", produces = "application/json")
    List<Releve> getReleves(@PathVariable("id") Long id);
}
