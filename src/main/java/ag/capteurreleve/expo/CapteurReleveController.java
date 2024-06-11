package ag.capteurreleve.expo;

import ag.capteurreleve.metier.CapteurReleveService;
import ag.capteurreleve.transientObj.Capteur;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/capteur-releve")
public class CapteurReleveController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    private final CapteurReleveService capteurReleveService;

    /**
     * Constructeur
     * @param capteurReleveService
     */
    public CapteurReleveController(CapteurReleveService capteurReleveService) {
        this.capteurReleveService = capteurReleveService;
    }

    /**
     * GET 1 capteur AVEC la liste de ses relevés
     * @return CapteurWithReleve
     */
    @GetMapping("/{id}")
    public Capteur getCapteur(@PathVariable("id") Long id) {
        logger.info("ClientCapteur : demande récup relevé d'un d'un capteur avec id:{}", id);
        Capteur c = capteurReleveService.getCapteurWithReleve(id);
        logger.info("ClientCapteur : demande récup relevé capteur:{}", c);
        return c;
    }
}