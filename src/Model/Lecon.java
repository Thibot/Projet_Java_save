package Model;

import javax.swing.*;
import java.util.Vector;

/**
 * Created by thibaut on 04/02/17.
 */
public abstract class Lecon {

    protected String name;
    protected String langue;
    protected Vector<Exercice> list_exercices;
    protected Vector<JLabel> list_jlabel;

    /**
     * Contructeur d'une classe abstraite lecon en affectant une langue à la leçon et une liste d'exercices vide, qui doit être remplie avec chaque exercice effectué
     * @param LANGUE
     */
    public Lecon(String LANGUE)
    {
        langue=LANGUE;
        list_exercices = new Vector<Exercice>();
        list_jlabel=new Vector<JLabel>();
    }

    /**
     * Méthode retournant le dernier Exercice de la liste d'exercices
     * @return
     */
    public Exercice getExercice()
    {
        return list_exercices.get(list_exercices.size()-1);
    }

    /**
     * Méthode ajoutant un exercice dans la liste d'exercices
     * @param exo
     */
    public void addExercice(Exercice exo)
    {
        list_exercices.add(exo);
        list_jlabel.add(new JLabel(exo.getNom()));
    }

    /**
     * Méthode retournant la liste d'exercices
     * @return
     */
    public Vector<Exercice> getList_exercices()
    {
        return list_exercices;
    }

    /**
     * Méthode retournant la langue de la leçon
     * @return
     */
    public String getLangue()
    {
        return langue;
    }

    public String toString(){
        return name;
    };
}
