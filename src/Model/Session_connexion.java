package Model;

/**
 * Created by thibaut on 30/05/17.
 */
public class Session_connexion {

    private Type_session type;
    private String id;
    private String mdp;

    public Session_connexion(String ID,String MDP,Type_session TYPE)
    {
        id=ID;
        mdp=MDP;
        type=TYPE;
    }

    public Session_connexion(Type_session TYPE)
    {
        id=null;
        mdp=null;
        type=TYPE;
    }

    public String getId()
    {
        return id;
    }

    public Type_session getType()
    {
        return type;
    }
}
