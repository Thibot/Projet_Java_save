package View;

import Controller.Historique_Controller;
import Controller.Session_connexion_controller;
import Model.Lecon;
import Model.Session;
import Model.Session_connexion;
import Model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import static java.lang.System.exit;

/**
 * Created by thibaut on 04/06/17.
 */
public class Mode_confirmed_view extends Mode_view_abstract{

    private JButton btn_accueil = new JButton("Accueil");
    private JButton btn_lecons = new JButton("Leçons");
    private JButton btn_compte = new JButton("Mon Compte");
    private JButton btn_rtr_menu_principal = new JButton("Menu");
    private JButton btn_quitter = new JButton("Quitter");
    private ArrayList<User> list_user;

    public Mode_confirmed_view(Session_connexion_controller session_controller, ArrayList<User> liste_utilisateur, Historique_Controller histo,Vector<Lecon> list_Lecon)
    {
        list_user=liste_utilisateur;
        Langue=getLangueById(session_controller.getSession().getId());

        recup_profil_user(session_controller,liste_utilisateur);
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

        btn_compte.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        affichMonCompte(session_controller,liste_utilisateur);
                    }
                }
        );

        btn_rtr_menu_principal.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                        menu_profil f = new menu_profil(liste_utilisateur,histo);
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
        pn_menu.add(btn_compte);
        pn_menu.add(btn_rtr_menu_principal);
        pn_menu.add(btn_quitter);

    }

    private void recup_profil_user(Session_connexion_controller session_controller,ArrayList<User> liste_utilisateur) {
        String id = session_controller.getSession().getId();
    }

    private String getLangueById(String id)
    {
        String langue="";
        for(int i=0;i<list_user.size() && langue.equals("");i++)
        {
            if(list_user.get(i).getID().equals(id))
            {
                langue=list_user.get(i).getLangue();
            }
        }
        return langue;
    }

    private void affichMonCompte(Session_connexion_controller session_controller, ArrayList<User> liste_utilisateur)
    {
        Boolean ok=false;
        int i;
        for(i =0;i<liste_utilisateur.size() && ok;i++)
        {
            if(liste_utilisateur.get(i).getID().equals(session_controller.getSession().getId()));
            {
                ok = true;
            }
        }

        JLabel lb_nom = new JLabel(liste_utilisateur.get(i).getNom());
        JLabel lb_prenom = new JLabel(liste_utilisateur.get(i).getPrenom());
        JLabel lb_age = new JLabel(Integer.toString(liste_utilisateur.get(i).getAge()));
        JLabel lb_genre = new JLabel("");
        if(liste_utilisateur.get(i).getGenre().equals("H"))
        {
            lb_genre.setText("Homme");
        }else
        {
            lb_genre.setText("Femme");
        }
        JLabel lb_id = new JLabel(liste_utilisateur.get(i).getID());
        JLabel lb_langue = new JLabel(liste_utilisateur.get(i).getLangue());



        pn_north.removeAll();
        pn_north.setLayout(new GridLayout(6,1));


        pn_north.add(lb_nom);
        pn_north.add(lb_prenom);
        pn_north.add(lb_age);
        pn_north.add(lb_genre);
        pn_north.add(lb_id);
        pn_north.add(lb_langue);

        pn_north.revalidate();
        pn_north.repaint();
    }

}
