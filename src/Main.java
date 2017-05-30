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

        menu_profil profil=new menu_profil(Liste_utilisateur);
    }
}
