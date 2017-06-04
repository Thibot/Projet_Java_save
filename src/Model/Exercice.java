package Model;

/**
 * Created by thibaut on 06/02/17.
 */
public class Exercice {

    protected String nom;
    protected String contenu;

    public Exercice(String Nom) {
        nom = Nom;
        contenu = "Tamen se est saepe se haerebat cruentum ad germanum ad multis germanum se accitus introisset introisset " +
                "suspicionis lenire fictisque in Caenos multis quid eum Caesar cogitatione spe Caenos Gallicanos post moliretur " +
                "fultum eum est febrium appellatur multis moliretur poterit uxorem ad germanum uxorem febrium eum ut absumpta repentina" +
                " ut se metuens uxorem quid fictisque ad tamen cum lenire introisset haec fiduciam suspicionis hortabatur Constantius " +
                "existimabat moliretur fiduciam lenire spe febrium cum fiduciam fultum cum suspicionis cuius poterit spe accitus " +
                "eius anxia Caesar multis profecta causa haec se haec anxia se repentina appellatur repentina suam obitum multis " +
                "se absumpta et germanum.";
    }

    public String getNom()
    {
        return nom;
    }
    public String getContenu() {
        return contenu;
    }
}
