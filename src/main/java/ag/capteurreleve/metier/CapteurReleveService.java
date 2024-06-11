package ag.capteurreleve.metier;

import ag.capteurreleve.transientObj.Capteur;
import org.springframework.stereotype.Service;

@Service
public interface CapteurReleveService {
    Capteur getCapteurWithReleve(Long idCapteur);
}
