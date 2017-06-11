package Model;

/**
 * Created by thibaut on 30/05/17.
 */
public class Session_connexion {

    private Type_session type;
    private String id;

    /**
     * Constructeur de l'instance de session de connexion
     */
    public Session_connexion()
    {

    }

    /**
     * Méthode retournant le type de la session
     * @return Type_session
     */
    public Type_session getType()
    {
        return type;
    }

    /**
     * Méthode modigiant le type de la session
     * @param TYPE
     */
    public void setType(Type_session TYPE)
    {
        type=TYPE;
    }

    /**
     * Méthode modifiant l'ID de la session
     * @param ID
     */
    public void setId(String ID)
    {
        id=ID;
    }

    /**
     * Méthode retournant l'id de la session
     * @return String
     */
    public String getId()
    {
        return id;
    }

}
