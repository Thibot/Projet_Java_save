package View;

import Controller.Session_connexion_controller;
import Model.Session_connexion;
import Model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * Created by thibaut on 29/05/17.
 */
public class menu_profil extends JFrame {
    protected Toolkit kit = Toolkit . getDefaultToolkit ();
    protected Dimension d = kit.getScreenSize();
    public ArrayList<User> list_user;
    public menu_profil(ArrayList<User> liste_utilisateur)
    {
        Session_connexion session = new Session_connexion();
        list_user=liste_utilisateur;

        JLabel lb_titre = new JLabel("Apprentissage des langues");
        JButton btn_connexion = new JButton("Se connecter");
        JButton btn_create = new JButton("Créer un compte");
        JButton btn_anonyme=new JButton("Anonyme");
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(new GridBagLayout());

        gbc.gridx=0;
        gbc.gridy=0;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(10, 15, 5, 15);
        getContentPane().add(lb_titre,gbc);
        gbc.gridx=0;
        gbc.gridy=1;
        gbc.insets = new Insets(5, 15, 5, 15);
        getContentPane().add(btn_connexion,gbc);
        gbc.gridx=0;
        gbc.gridy=2;
        getContentPane().add(btn_create,gbc);
        gbc.gridx=0;
        gbc.gridy=3;
        gbc.insets = new Insets(5, 15, 10, 15);
        getContentPane().add(btn_anonyme,gbc);

        btn_connexion.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                        Connexion ihm_connexion = new Connexion(liste_utilisateur,session);
                    }
                }
        );
        btn_create.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                        form_create_user create = new form_create_user(liste_utilisateur);
                    }
                }
        );
        btn_anonyme.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Session_connexion_controller session_controller = new Session_connexion_controller(session);
                        session_controller.setSession("CONFIRMED",null);
                    }
                }
        );

        setTitle ("Apprentissage des langues") ;
        setSize(d.width / 2, d.height /2);
        setLocation(d.width /4, d.height /4);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible (true);
    }
}
