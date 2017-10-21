package example.com.if26_tp5;

import android.support.annotation.NonNull;

import java.io.Serializable;

// Posibilité de trier donc on implemente l'interface comparable, serialisable pour pouvoir passer des modules d'une activité à l'autre
public class Module implements Serializable, Comparable {

    // position = Position dans le tableau si nous faisons une liste de modules
    private int	    position;
    private String  sigle;
    private String  categorie;
    private String  parcours;
    private int     credit;

    //id permet de connaitre l'id du module dans la base de donnees
    private int     id;

    public Module(){}

    public Module(String sigle, String categorie, String parcours, int credit) {
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

    //permet de recuperer la position de ce module dans la liste des modules
    public int getPosition () {
        return position;
    }

    public void setPosition (int position) {
        this.position = position;
    }

    public String getSigle() {
        return sigle;
    }

    public void setSigle(String sigle) {
        this.sigle = sigle;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getParcours() {
        return parcours;
    }

    public void setParcours(String parcours) {
        this.parcours = parcours;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
