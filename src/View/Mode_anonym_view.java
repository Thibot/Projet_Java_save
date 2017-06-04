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

    public Mode_anonym_view(Session_connexion_controller session_controller)
    {
        getContentPane().setLayout(new GridBagLayout());

        Init_pn_menu();
        Init_pn_contenu();




        setTitle ("Apprentissage des langues - Anonyme") ;
        setSize(d.width / 2, d.height /2);
        setLocation(d.width /4, d.height /4);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //pack();
        setVisible (true);
    }

    protected void Init_pn_menu()
    {
        pn_menu.setBackground(Color.gray);
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.gridheight=GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(10, 15, 5, 15);
        getContentPane().add(pn_menu,gbc);
        pn_menu.setLayout(new BoxLayout(pn_menu,BoxLayout.Y_AXIS));
    }

    protected void Init_pn_contenu()
    {
        gbc.gridx=1;
        gbc.gridy=0;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(10, 15, 5, 15);
        getContentPane().add(pn_contenu,gbc);
    }


}
