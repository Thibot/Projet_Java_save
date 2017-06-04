package Model;

/**
 * Created by thibaut on 06/02/17.
 */
public class Exercice {

    protected String nom;
    protected String contenu;

    public Exercice(String Nom) {
        nom = Nom;
        contenu = "Tamen se est saepe se haerebat cruentum ad germanum ad multis germanum se accitus introisset introisset ";
    }

    public String getNom()
    {
        return nom;
    }
    public String getContenu() {
        return contenu;
    }
}
