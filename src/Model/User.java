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
    private Genre genre;
    private Langue langue;

    /**
     * Constructeur de la classe, permettant de créer un utilisateur en demandant à l'utilisateur de saisir des informations personnelles
     */
    public User() {
        Scanner sc;
        Boolean ok;
        do {
            System.out.println("\nVeuillez saisir votre age : ");
            try{
                sc = new Scanner(System.in);
                String test=sc.nextLine();
                age=Integer.parseInt(test);
                if(age<=0 || age >150) {
                    ok = false;
                } else {
                    ok = true;
                }
            }catch(Error e)
            {
                System.out.println("Erreur");
                ok=false;
            }

        } while(!ok);

        String saisie_genre;
        do {
            System.out.println("\nEtes-vous une femme ou un homme ?  (F/H)");
            sc = new Scanner(System.in);
            saisie_genre = sc.nextLine();
            if(!saisie_genre.equals("H") && !saisie_genre.equals("F")) {
                ok = false;
            } else {
                ok = true;
            }
        } while(!ok);

        if(saisie_genre.equals("H")) {
            genre = Genre.HOMME;
        } else {
            genre = Genre.FEMME;
        }

        ok=false;
        do {
            System.out.println("\nChoisissez une langue à apprendre parmi la liste : ");
            for(Langue lang : Langue.values()){
                System.out.println(lang);
            }

            System.out.println("\r");
            sc = new Scanner(System.in);
            String saisie_langue = sc.nextLine();

            switch(saisie_langue) {
                case "Anglais":
                    langue=Langue.Anglais;
                    ok=true;
                    break;
                case "Espagnol":
                    langue=Langue.Espagnol;
                    ok=true;
                    break;
                case "Italien":
                    langue=Langue.Italien;
                    ok=true;
                    break;
                case "Allemand":
                    langue=Langue.Allemand;
                    ok=true;
                    break;
                default:
                    langue=Langue.Anglais;

                    break;
            }
        } while(!ok);
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
    public Genre getGenre() {
        return genre;
    }

    /**
     * Méthode modifiant le genre d'un utilisateur avec celui placé en paramètre
     * @param genre
     */
    public void setGenre(String genre) {
        Genre conversion=null;
        for(Genre GENRE : Genre.values()){
            if(genre==GENRE.toString())
            {
                conversion=GENRE;
            }
        }
        if(conversion!=null)
        {
            this.genre = conversion;
        }
    }

    /**
     * Méthode retournant la langue à apprendre d'un utilisateur
     * @return
     */
    public Langue getLangue() {
        return langue;
    }

    /**
     * Méthode modifiant la langue à apprendre pour un utilisateur
     * @param langue
     */
    public void setLangue(String langue) {
        Langue conversion=null;
        for(Langue lang : Langue.values()){
            if(langue==lang.toString())
            {
                conversion=lang;
            }
        }
        if(conversion!=null)
        {
            this.langue = conversion;
        }
    }
}