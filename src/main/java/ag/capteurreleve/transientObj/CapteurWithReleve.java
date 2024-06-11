package ag.capteurreleve.transientObj;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

// Utilisation de lombok pour générer constructeurs, getters...
// on veut le constrcteur avec TOUS les attributs
@AllArgsConstructor
// on veut le constrcteur SANS argument
@NoArgsConstructor
// on veut les setters pour TOUS les attributs
@Setter
// on veut les getters pour TOUS les attributs
@Getter
/**
 * Objet Client TRANSIENT (utilisé pour la communication uniquement) embarquant une liste de comptes
 */
public class CapteurWithReleve implements Serializable {
    private List<Releve> releves;

    //métohde d'ajout de releve dans la list
    public void addReleve(Releve releve){
        this.releves.add(releve);
    }
}
