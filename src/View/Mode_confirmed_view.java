package View;

import Controller.Session_connexion_controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.System.exit;

/**
 * Created by thibaut on 04/06/17.
 */
public class Mode_confirmed_view extends Mode_view_abstract{

    private JButton btn_accueil = new JButton("Accueil");
    private JButton btn_lecons = new JButton("Leçons");
    private JButton btn_quitter = new JButton("Quitter");
    private JLabel lb_titre = new JLabel("Accueil",JLabel.CENTER);

    public Mode_confirmed_view(Session_connexion_controller session_controller)
    {
        getContentPane().setLayout(new BoxLayout(getContentPane(),BoxLayout.X_AXIS));


        Init_pn_menu();
        Init_pn_contenu();

        btn_lecons.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //LeconBTN_Step1_Contenu();
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


        setTitle ("Apprentissage des langues - "+session_controller.getSession().getId()) ;
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
