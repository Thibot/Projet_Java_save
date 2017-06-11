package Controller;
import Model.Genre;
import Model.Langue;
import Model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thibaut on 29/05/17.
 */
public class User_controller {
    private User user;

    /**
     * Constructeur du controleur créant un nouvel utilisateur
     */
    public User_controller()
    {

        user=new User();
    }

    /**
     * Méthode modifiant les informations de l'utilisateur
     * @param Nom,Prenom,ID,Mdp,age,genre,langue
     * @return boolean
     */
    public Boolean CreateUser(String Nom,String Prenom, String ID, String Mdp, int age, String genre, String langue)
    {
        if(age>=0 && age<150 && GenreExist(genre) && LangueExist(langue))
        {
            try{
                user.setNom(Nom);
                user.setPrenom(Prenom);
                user.setID(ID);
                user.setMdp(Mdp);
                user.setAge(age);
                user.setGenre(genre);
                user.setLangue(langue);
                return true;

            }catch(Exception e)
            {
                return false;
            }

        }else
        {
            return false;
        }

    }

    /**
     * Méthode vérifiant si la langue existe
     * @param langue
     * @return boolean
     */
    public Boolean LangueExist(String langue)
    {
        Boolean ok=false;
        for(Langue lang : Langue.values()){
            if(langue==lang.toString())
            {
                ok=true;
            }
        }

        return ok;
    }

    /**
     * Méthode vérifiant si le genre existe
     * @param genre
     * @return boolean
     */
    public Boolean GenreExist(String genre)
    {
        Boolean ok=false;
        for(Genre genr : Genre.values()){
            if(genre==genre.toString())
            {
                ok=true;
            }
        }
        return ok;
    }


    /**
     * Méthode renvoyant l'utilisateur
     * @return User
     */
    public User getUser()
    {
        return user;
    }

    /**
     * Méthode vérifiant si l'utilisateur existe déjà dans la liste des utilisateurs
     * @param ID,liste
     * @return boolean
     */
    public Boolean UserExist(String ID, ArrayList<User> liste)
    {
        Boolean ok=true;
        int i;
        for(i=0;i<liste.size();i++)
        {
            if(liste.get(i).getID().equals(ID))
            {
                ok=false;
            }
        }
        return ok;
    }
}
