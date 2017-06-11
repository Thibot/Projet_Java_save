package Model;

/**
 * Created by thibaut on 06/02/17.
 */
public class Exercice {

    protected String nom;
    protected String contenu;

    /**
     * Constructeur de l'instance d'exercice
     * @param Nom
     */
    public Exercice(String Nom) {
        nom = Nom;
        contenu = "<html>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non risus.<br>" +
                " Suspendisse lectus tortor, dignissim sit amet, adipiscing nec, ultricies sed, dolor.<br>" +
                " Cras elementum ultrices diam. Maecenas ligula massa, varius a, semper congue, euismod <br>" +
                "non, mi. Proin porttitor, orci nec nonummy molestie, enim est eleifend mi, non fermentum <br>" +
                "diam nisl sit amet erat. Duis semper. Duis arcu massa, scelerisque vitae, consequat in, <br>" +
                "pretium a, enim. Pellentesque congue. Ut in risus volutpat libero pharetra tempor. Cras <br>" +
                "vestibulum bibendum augue. Praesent egestas leo in pede. Praesent blandit odio eu enim. <br>" +
                "Pellentesque sed dui ut augue blandit sodales. Vestibulum ante ipsum primis in faucibus <br>" +
                "orci luctus et ultrices posuere cubilia Curae; Aliquam nibh. Mauris ac mauris sed pede <br>" +
                "pellentesque fermentum. Maecenas adipiscing ante non diam sodales hendrerit.</html>";
    }

    /**
     * Méthode retournant le nom de l'exercice
     * @return String
     */
    public String getNom()
    {
        return nom;
    }

    /**
     * Méthode retournant le contenu de l'exercice
     * @return String
     */
    public String getContenu() {
        return contenu;
    }
}
