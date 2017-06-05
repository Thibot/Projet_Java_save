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

    /**
     * Méthode ajoutant une leçon dans la liste de leçon
     * @param lecon
     */
    public void addLecon(Lecon lecon)
    {
        if(session.getList_Lecon().contains(lecon))
        {
            session.getList_Lecon().get(session.getList_Lecon().indexOf(lecon)).addExercice(lecon.getExercice());
        }else
        {
            session.getList_Lecon().add(lecon);
        }

    }
}
