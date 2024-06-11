package ag.capteurreleve.entities;

import ag.capteurreleve.transientObj.Releve;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "ac-releve")
public interface ClientReleve {
    @GetMapping("/api/releves/{id}")
    List<Releve> getReleve(@PathVariable("id") Long id);
}
