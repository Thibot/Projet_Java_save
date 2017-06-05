package Model;

import java.util.Vector;

/**
 * Created by thibaut on 04/02/17.
 */
public class Historique {
    private Vector<Session> histo;

    /**
     * Constructeur de l'historique, initialisant la liste de sessions
     */
    public Historique()
    {
        histo = new Vector<Session>();
    }

    /**
     * Méthode renvoyant la liste de session
     * @return
     */
    public Vector<Session> getHistorique()
    {
        return histo;
    }

    /**
     * Affichage d'un historique en appelant la méthode d'affichage de session pour chaque session contenue dans la liste
     */
    public void AfficheHisto()
    {

        int i=0;
        while(i<histo.size())
        {
            //Appel à la méthode d'affichage de la session
            histo.get(i).AfficheSession();
            i++;
        }
    }

    public String getAfficheHisto()
    {
        String s="";
        int i=0;
        while(i<histo.size())
        {
            //Appel à la méthode d'affichage de la session
            s=s+histo.get(i).getAfficheSession();
            i++;
        }
        return s;
    }
}
