package ag.capteurreleve.transientObj;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Setter
@Getter
public class Releve implements Serializable {

    private long id;
    private LocalDate dateReleve;
    private int humitide;
    private double temperature;
    private Long idCapteur;

}
