package Controller;

import Model.Session_connexion;
import Model.Type_session;

/**
 * Created by thibaut on 04/06/17.
 */
public class Session_connexion_controller {

    Session_connexion session;

    /**
     * Constructeur du controleur
     */
    public Session_connexion_controller() {
        session=new Session_connexion();
    }

    /**
     * Méthode modifiant le type de session (utilisateur enregistré ou anonyme)
     * @param TYPE,ID
     */
    public void setSession(String TYPE, String ID)
    {
        Type_session type=Type_session.ANONYM;
        if(TYPE.equals("CONFIRMED"))
        {
            type=Type_session.CONFIRMED;
            session.setId(ID);
        }
        session.setType(type);
    }

    /**
     * Méthode retournant l'instance de session
     * @return Session_connexion
     */
    public Session_connexion getSession()
    {
        return session;
    }
}
