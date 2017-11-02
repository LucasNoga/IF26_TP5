package example.com.if26_tp6;

import android.support.annotation.NonNull;

import java.io.Serializable;

// Posibilité de trier donc on implemente l'interface comparable, serialisable pour pouvoir passer des modules d'une activité à l'autre
public class Module implements Serializable, Comparable {

    // position = Position dans le tableau si nous faisons une liste de modules
    private String  sigle;
    private String  categorie;
    private String  parcours;
    private int     credit;

    //id permet de connaitre l'id du module dans la base de donnees
    private int     id;

    public Module(){}

    public Module(String sigle, int credit, String categorie, String parcours) {
        this.sigle = sigle;
        this.categorie = categorie;
        this.parcours = parcours;
        this.credit = credit;
    }

    @Override
    public int compareTo(@NonNull Object o) {
        Module mod = (Module) o;
        return mod.getSigle().compareTo(this.sigle);
    }

    public String getSigle() {
        return sigle;
    }

    public String getCategorie() {
        return categorie;
    }

    public String getParcours() {
        return parcours;
    }

    public int getCredit() {
        return credit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSigle(String sigle) {
        this.sigle = sigle;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setParcours(String parcours) {
        this.parcours = parcours;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }


}
