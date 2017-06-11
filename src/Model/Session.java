package Model; /**
 * Created by thibaut on 03/02/17.
 */

import java.util.Vector;

public class Session {

    private String date;
    private Vector<Lecon> list_lecon;

    /**
     * Constructeur de session, initialisant la date de début de celle-ci et la liste de leçon
     */
    public Session()
    {
        list_lecon=new Vector<Lecon>();
    }

    /**
     * Méthode retournant la liste des lecon
     * @return Vector<Lecon>
     */
    public Vector<Lecon> getList_Lecon()
    {
        return list_lecon;
    }

    /**
     * Méthode retournant la date de début de la session
     * @return
     */
    public String getDate()
    {
        return date;
    }

    /**
     * Méthode modifiant la date de début d'un session
     * @param DATE
     */
    public void setDate(String DATE) {
        this.date = DATE;
    }

    /**
     * Méthode modifiant la liste de leçons par celle placée en paramètre
     * @param list_lecon
     */
    public void setList_lecon(Vector<Lecon> list_lecon) {
        this.list_lecon = list_lecon;
    }

    /**
     * Affichage du contenu d'une session (Date + les types de leçon et les exercices
     */
    public void AfficheSession()
    {
        int i=0;
        System.out.println("Date : "+date);

        for(i=0;i<list_lecon.size();i++)
        {
            for(int j=0;j<list_lecon.get(i).getList_exercices().size();j++)
            {
                System.out.println(list_lecon.get(i).toString()+"\t"+list_lecon.get(i).getList_exercices().get(j).getNom()+"\n");
            }

        }

    }

    /**
     * Méthode retournant la liste des lecon de la session pour un affichage possible
     * @return String
     */
    public String getAfficheSession()
    {
        String s="<html> ";
        int i=0;
        s=(s+date+"<br><br>");

        for(i=0;i<list_lecon.size();i++)
        {
            for(int j=0;j<list_lecon.get(i).getList_exercices().size();j++)
            {
                s=s+list_lecon.get(i).toString()+" || "+list_lecon.get(i).getList_exercices().get(j).getNom()+"<br>";
            }

        }
        s=s+"\n\n</html>";
        return s;
    }



}
