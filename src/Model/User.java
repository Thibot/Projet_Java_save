package Model; /**
 * Created by thibaut on 03/02/17.
 */
import java.util.Scanner;

public class User {
    private String nom;
    private String prenom;
    private String id;
    private String mdp;
    private int age;
    private String genre;
    private String langue;

    /**
     * Constructeur de la classe, permettant de créer un utilisateur
     */
    public User() {

    }

    public String getNom()
    {
        return nom;
    }

    public void setNom(String Nom)
    {
        nom=Nom;
    }

    public String getPrenom()
    {
        return prenom;
    }

    public void setPrenom(String Prenom)
    {
        prenom=Prenom;
    }

    public String getID()
    {
        return id;
    }

    public void setID(String ID)
    {
        id=ID;
    }

    public String getMdp()
    {
        return mdp;
    }

    public void setMdp(String Mdp)
    {
        mdp=Mdp;
    }


    /**
     * Méthode retournant l'age d'un utilisateur
     * Possiblement nécessaire pour des améliorations du système
     * @return
     */
    public int getAge() {
        return age;
    }

    /**
     * Méthode modifiant l'age d'un utilisateur avec celui placé en paramètre
     * Possiblement nécessaire pour des améliorations du système
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Méthode retournant le Genre (Homme/Femme) d'un utilisateur
     * @return
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Méthode modifiant le genre d'un utilisateur avec celui placé en paramètre
     * @param genre
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Méthode retournant la langue à apprendre d'un utilisateur
     * @return
     */
    public String getLangue() {
        return langue;
    }

    /**
     * Méthode modifiant la langue à apprendre pour un utilisateur
     * @param Langue
     */
    public void setLangue(String Langue) {
        this.langue = Langue;
    }
}