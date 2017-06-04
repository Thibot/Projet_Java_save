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

    public void setSession(Type_session TYPE, String ID)
    {
        session.setType(TYPE);
        if(session.getType()!=Type_session.ANONYM)
        {
            session.setId(ID);
        }
    }
}
