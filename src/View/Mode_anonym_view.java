package View;


import Controller.Session_connexion_controller;

import javax.swing.*;
import java.awt.*;

/**
 * Created by thibaut on 04/06/17.
 */
public class Mode_anonym_view extends Mode_view_abstract{

    private JButton btn_accueil = new JButton("Accueil");
    private JButton btn_lecons = new JButton("Leçons");
    private JButton btn_quitter = new JButton("Quitter");
    private JLabel lb_titre = new JLabel("Accueil",JLabel.CENTER);

    public Mode_anonym_view()
    {
        getContentPane().setLayout(new BoxLayout(getContentPane(),BoxLayout.X_AXIS));


        Init_pn_menu();
        Init_pn_contenu();


        setTitle ("Apprentissage des langues - Anonyme") ;
        setSize(d.width / 2, d.height /2);
        setLocation(d.width /4, d.height /4);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible (true);
    }

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

    protected void Init_pn_contenu()
    {
        getContentPane().add(pn_contenu);
        pn_contenu.setLayout(new BorderLayout());
        pn_contenu.add(lb_titre,BorderLayout.NORTH);
        lb_titre.setFont(new Font("TimesNewRoman",Font.BOLD,24));
    }


}
