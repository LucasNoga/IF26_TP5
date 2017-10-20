package example.com.if26_tp5;


import java.io.Serializable;

public class Module implements Serializable {

    private String sigle;
    private String categorie;
    private String parcours;
    private int credit;

    public Module(String sigle, String categorie, String parcours, int credit) {
        this.sigle = sigle;
        this.categorie = categorie;
        this.parcours = parcours;
        this.credit = credit;
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
}
