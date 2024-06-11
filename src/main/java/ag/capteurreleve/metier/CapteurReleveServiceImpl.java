package ag.capteurreleve.metier;

import ag.capteurreleve.entities.ClientCapteur;
import ag.capteurreleve.entities.ClientReleve;
import ag.capteurreleve.transientObj.Capteur;

import ag.capteurreleve.transientObj.Releve;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public Capteur getCapteurWithReleve(Long idCapteur) {
        try {
            // On récupère 1 objet capteur
            Capteur c = this.clientCapteur.findById(idCapteur);

            logger.info("On a récupéré le capteur : {}", c.getId());

            //Iterable<Releve> rlv = this.clientReleve.getReleves(c.getId());

            List<Releve> rlv = this.clientReleve.getReleves(c.getId());
            if (rlv != null) {
                List<Releve> releveList = new ArrayList<>(rlv);
                logger.info("Releves pour le capteur {}: {}", c.getId(), releveList);
            } else {
                logger.info("Aucun releve trouvé pour le capteur {}", c.getId());
            }

            c.setReleves(rlv);

            return c;
        } catch (feign.FeignException feignException) {
            return new Capteur();
        }


    }
}
