package ag.capteurreleve.transientObj;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

public class Releve implements Serializable {

    private long id;
    private LocalDate dateReleve;
    private int humitide;
    private double temperature;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDateReleve() {
        return dateReleve;
    }

    public void setDateReleve(LocalDate dateReleve) {
        this.dateReleve = dateReleve;
    }

    public int getHumitide() {
        return humitide;
    }

    public void setHumitide(int humitide) {
        this.humitide = humitide;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public Long getIdCapteur() {
        return idCapteur;
    }

    public void setIdCapteur(Long idCapteur) {
        this.idCapteur = idCapteur;
    }

    private Long idCapteur;
}
