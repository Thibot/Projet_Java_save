package Controller;

import Model.Lecon;
import Model.Session;

/**
 * Created by thibaut on 05/06/17.
 */
public class Session_controller {
    private Session session;

    public Session_controller()
    {
        session=new Session();
    }

    public Session getSession()
    {
        return session;
    }
}
