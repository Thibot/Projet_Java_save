package Model;

/**
 * Created by thibaut on 30/05/17.
 */
public class Session_connexion {

    private Type_session type;
    private String id;

    public Session_connexion()
    {

    }

    public Type_session getType()
    {
        return type;
    }

    public void setType(Type_session TYPE)
    {
        type=TYPE;
    }

    public void setId(String ID)
    {
        id=ID;
    }

    public String getId()
    {
        return id;
    }

}
