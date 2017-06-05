package View;

import Model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

/**
 * Created by thibaut on 04/06/17.
 */
public class Anonym_langue extends JFrame {
    private Toolkit kit = Toolkit.getDefaultToolkit ();
    private Dimension d = kit.getScreenSize();
    private JComboBox<String> cb_langue = new JComboBox<>();
    private JButton btn_valider = new JButton("Valider");
    private Vector<Lecon> list_lecon = new Vector<>();

    public Anonym_langue()
    {
        for(Langue lang : Langue.values()){
            cb_langue.addItem(lang.toString());
        }

        btn_valider.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                        generateLecon(cb_langue.getSelectedItem().toString());
                        Mode_view_abstract anonym_view = new Mode_anonym_view(list_lecon,cb_langue.getSelectedItem().toString());

                    }
                }
        );

        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(cb_langue);
        getContentPane().add(btn_valider);

        setTitle ("Sélection d'une langue") ;
        setSize(d.width / 2, d.height /2);
        setLocation(d.width /4, d.height /4);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible (true);
    }

    private void generateLecon(String langue)   //Evolution : rechercher une liste de lecons correspondante à la langue sélectionnée
    {
        Conjugaison conjugaison = new Conjugaison(cb_langue.getSelectedItem().toString());
        conjugaison.addExercice(new Exercice("Exercice Conjugaison 1"));
        conjugaison.addExercice(new Exercice("Exercice Conjugaison 2"));
        conjugaison.addExercice(new Exercice("Exercice Conjugaison 3"));
        conjugaison.addExercice(new Exercice("Exercice Conjugaison 4"));
        conjugaison.addExercice(new Exercice("Exercice Conjugaison 5"));
        Grammaire grammaire = new Grammaire(cb_langue.getSelectedItem().toString());
        grammaire.addExercice(new Exercice("Exercice Grammaire 1"));
        grammaire.addExercice(new Exercice("Exercice Grammaire 2"));
        grammaire.addExercice(new Exercice("Exercice Grammaire 3"));
        grammaire.addExercice(new Exercice("Exercice Grammaire 4"));
        grammaire.addExercice(new Exercice("Exercice Grammaire 5"));
        Orthographe orthographe = new Orthographe(cb_langue.getSelectedItem().toString());
        orthographe.addExercice(new Exercice("Exercice Orthographe 1"));
        orthographe.addExercice(new Exercice("Exercice Orthographe 2"));
        orthographe.addExercice(new Exercice("Exercice Orthographe 3"));
        orthographe.addExercice(new Exercice("Exercice Orthographe 4"));
        orthographe.addExercice(new Exercice("Exercice Orthographe 5"));
        Vocabulaire vocabulaire = new Vocabulaire(cb_langue.getSelectedItem().toString());
        vocabulaire.addExercice(new Exercice("Exercice Vocabulaire 1"));
        vocabulaire.addExercice(new Exercice("Exercice Vocabulaire 2"));
        vocabulaire.addExercice(new Exercice("Exercice Vocabulaire 3"));
        vocabulaire.addExercice(new Exercice("Exercice Vocabulaire 4"));
        vocabulaire.addExercice(new Exercice("Exercice Vocabulaire 5"));

        list_lecon.add(conjugaison);
        list_lecon.add(grammaire);
        list_lecon.add(orthographe);
        list_lecon.add(vocabulaire);
    }
}
