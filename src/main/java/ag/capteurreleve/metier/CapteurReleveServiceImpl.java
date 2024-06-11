package ag.capteurreleve.metier;

import ag.capteurreleve.entities.ClientCapteur;
import ag.capteurreleve.entities.ClientReleve;
import ag.capteurreleve.transientObj.Capteur;
import ag.capteurreleve.transientObj.CapteurWithReleve;

import ag.capteurreleve.transientObj.Releve;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CapteurReleveServiceImpl implements CapteurReleveService {
    Logger logger = LoggerFactory.getLogger(this.getClass());


    private final ClientCapteur clientCapteur;


    private final ClientReleve clientReleve;

    public CapteurReleveServiceImpl(ClientCapteur clientCapteur, ClientReleve clientReleve) {
        this.clientCapteur = clientCapteur;
        this.clientReleve = clientReleve;
    }

    // On va interroger successivement les 2 micro-services Capteur et Releve
    @Override
    public CapteurWithReleve getCapteurWithReleve(Long idCapteur) {
        logger.info("On a 1 demande");
        logger.info("On envoie la demande au service capteur");

        try {
            // On récupère 1 objet capteur
            Capteur c = this.clientCapteur.findById(idCapteur);

            List<Releve> rlv = this.clientReleve.getReleve(c.getId());

            CapteurWithReleve cwr = new CapteurWithReleve();
            // On forge la réponse
            for (Releve r : rlv) {
                cwr.addReleve(r);
            }

            return cwr;
        } catch (feign.FeignException feignException) {
            return new CapteurWithReleve();
        }


    }
}
