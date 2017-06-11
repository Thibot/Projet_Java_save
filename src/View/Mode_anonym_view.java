package View;


import Controller.Historique_Controller;
import Controller.Session_connexion_controller;
import Model.Conjugaison;
import Model.Langue;
import Model.Lecon;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;
import java.util.Vector;

/**
 * Created by thibaut on 04/06/17.
 */
public class Mode_anonym_view extends Mode_view_abstract{

    private JButton btn_accueil = new JButton("Accueil");
    private JButton btn_lecons = new JButton("Leçons");
    private JButton btn_quitter = new JButton("Quitter");

    /**
     * Constructeur de la vue en mode anonyme
     * @param list_Lecon,langue
     */
    public Mode_anonym_view(Vector<Lecon> list_Lecon,String langue)
    {

        Langue=langue;

        getContentPane().setLayout(new BoxLayout(getContentPane(),BoxLayout.X_AXIS));
        Init_pn_menu();
        Init_pn_contenu();

        btn_accueil.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Init_pn_contenu();
                    }
                }
        );

        btn_lecons.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        for(int i=0;i<list_Lecon.size();i++)
                        {
                            list_lecon.add(list_Lecon.get(i));
                        }
                        LeconBTN_Step1_Contenu();
                    }
                }
        );

        btn_quitter.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                }
        );


        setTitle ("Apprentissage des langues - Anonyme") ;
        setSize(d.width / 2, d.height /2);
        setLocation(d.width /4, d.height /4);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible (true);
    }

    /**
     * Méthode générant le menu de gauche
     */
    protected void Init_pn_menu()
    {
        getContentPane().add(pn_menu);
        pn_menu.setAlignmentX(0);
        pn_menu.setAlignmentY(0);
        pn_menu.setLayout(new BoxLayout(pn_menu,BoxLayout.Y_AXIS));
        pn_menu.add(btn_accueil);
        pn_menu.add(btn_lecons);
        pn_menu.add(btn_quitter);
    }
}
