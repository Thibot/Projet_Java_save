import Controller.Historique_Controller;
import Model.User;
import View.menu_profil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by thibaut on 29/05/17.
 */
public class Main {
    public static ArrayList<User> Liste_utilisateur=new ArrayList<>();

    public static void main(String[] args)
    {
        Historique_Controller histo = new Historique_Controller();
        User user = new User();
        user.setNom("Roudel");
        user.setPrenom("Thibaut");
        user.setAge(22);
        user.setID("Titi");
        user.setMdp("1234");
        user.setGenre("H");
        user.setLangue("Anglais");
        Liste_utilisateur.add(user);
        User user2 = new User();
        user2.setNom("Dupont");
        user2.setPrenom("Stéphane");
        user2.setAge(35);
        user2.setID("Steph");
        user2.setMdp("toto");
        user2.setGenre("H");
        user2.setLangue("Allemand");
        Liste_utilisateur.add(user2);
        menu_profil profil=new menu_profil(Liste_utilisateur,histo);
    }
}
