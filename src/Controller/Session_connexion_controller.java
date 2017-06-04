package Controller;

import Model.Session_connexion;
import Model.Type_session;

/**
 * Created by thibaut on 04/06/17.
 */
public class Session_connexion_controller {

    Session_connexion session;

    public Session_connexion_controller(Session_connexion Session)
    {
        session=Session;
    }

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

    public Session_connexion getSession()
    {
        return session;
    }
}
