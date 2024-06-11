package ag.capteurreleve.metier;

import ag.capteurreleve.transientObj.CapteurWithReleve;
import org.springframework.stereotype.Service;

@Service
public interface CapteurReleveService {
    CapteurWithReleve getCapteurWithReleve(Long idCapteur);
}
