package Controller;

import Model.*;

import java.text.DateFormat;
import java.util.Date;
import java.util.Vector;

/**
 * Created by thibaut on 04/06/17.
 */
public class Historique_Controller {
    private Historique histo;
    public Historique_Controller()
    {
        histo=new Historique();
    }

    /**
     * Méthode testant si l'historique contient déjà une session avec la date du jour, renvoie -1 si aucune session n'existe à la date du jour
     * @param session
     * @return
     */
    public int ContientSessionDate(Session session)
    {
        int i,res=-1;

        for(i=0;i<histo.getHistorique().size() && res==-1;i++)
        {
            if(histo.getHistorique().get(i).getDate()==session.getDate())
            {
                res=i;
            }
        }
        return res;
    }

    public Historique getHisto(){return histo;}
    public Vector<Session> getHistorique()
    {
        return histo.getHistorique();
    }

    public void addSession(Session session)
    {
        if(!histo.getHistorique().contains(session.getDate()))
        {
            histo.getHistorique().add(session);
        }
    }

    public void addExoHisto(String lecon,Exercice exo, String langue)
    {
        Exercice exo_cp = exo;
        Session session;
        String date;
        DateFormat shortDateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.SHORT);
        date=shortDateFormat.format(new Date());

        if(!ContientDate(date)) {
            session=new Session();
            session.setDate(date);
            switch(lecon)
            {
                case "Orthographe":
                    session.getList_Lecon().add(new Orthographe(langue));
                    break;
                case "Grammaire":
                    session.getList_Lecon().add(new Grammaire(langue));
                    break;
                case "Conjugaison":
                    session.getList_Lecon().add(new Conjugaison(langue));
                    break;
                case "Vocabulaire":
                    session.getList_Lecon().add(new Vocabulaire(langue));
                    break;
                default:
                    break;
            }
            histo.getHistorique().add(session);
        }else
        {
            int i=0;
            while(!histo.getHistorique().get(i).getDate().equals(date)){i++;}
            if(!ContientLecon(i,lecon))
            {
                switch(lecon)
                {
                    case "Orthographe":
                        histo.getHistorique().get(i).getList_Lecon().add(new Orthographe(langue));
                        break;
                    case "Grammaire":
                        histo.getHistorique().get(i).getList_Lecon().add(new Grammaire(langue));
                        break;
                    case "Conjugaison":
                        histo.getHistorique().get(i).getList_Lecon().add(new Conjugaison(langue));
                        break;
                    case "Vocabulaire":
                        histo.getHistorique().get(i).getList_Lecon().add(new Vocabulaire(langue));
                        break;
                    default:
                        break;
                }
            }
        }
        int i=0;
        while(!histo.getHistorique().get(i).getDate().equals(date)){i++;}
        int j=0;
        while(!histo.getHistorique().get(i).getList_Lecon().get(j).toString().equals(lecon) && j<histo.getHistorique().get(i).getList_Lecon().size()){j++;}
        histo.getHistorique().get(i).getList_Lecon().get(j).addExercice(exo_cp);
    }


    public Boolean ContientDate(String date)
    {
        Boolean ok=false;
        int i=0;
        while(i<histo.getHistorique().size() && ok==false)
        {
            if(histo.getHistorique().get(i).getDate().equals(date))
            {
                ok=true;
            }else
            {
                i++;
            }

        }
        return ok;
    }

    public Boolean ContientLecon(int i,String lecon)
    {
        Boolean ok=false;
        int j=0;

        while(j<histo.getHistorique().get(i).getList_Lecon().size() && ok==false)
        {
            if(histo.getHistorique().get(i).getList_Lecon().get(j).toString().equals(lecon))
            {
                ok=true;
            }else
            {
                j++;
            }
        }
        return ok;
    }
}
