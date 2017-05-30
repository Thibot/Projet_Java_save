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
    public User_controller()
    {
        user=new User();
    }

    public Boolean CreateUser(String Nom,String Prenom, String ID, String Mdp, int age, String genre, String langue)
    {
        if((age<=0 || age >150) && GenreExist(genre) && LangueExist(langue))
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

    public Boolean LangueExist(String langue)
    {
        Boolean ok=false;
        ArrayList<String> tab=new ArrayList<>();
        int i=0;
        for(Langue lang : Langue.values()){
            tab.add(lang.toString());
        }
        i=0;
        while(ok==false && i<tab.size())
        {
            if(tab.get(i)==langue)
            {
                ok=true;
            }else
            {
                i++;
            }
        }
        return ok;
    }

    public Boolean GenreExist(String genre)
    {
        Boolean ok=false;
        ArrayList<String> tab=new ArrayList<>();
        int i=0;
        for(Genre genr : Genre.values()){
            tab.add(genr.toString());
        }
        i=0;
        while(ok==false && i<tab.size())
        {
            if(tab.get(i)==genre)
            {
                ok=true;
            }else
            {
                i++;
            }
        }
        return ok;
    }

    public User getUser()
    {
        return user;
    }
}
