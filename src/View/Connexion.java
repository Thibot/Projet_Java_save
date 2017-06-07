package View;

import Controller.Session_connexion_controller;
import Model.Session_connexion;
import Model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import static javax.swing.JOptionPane.showConfirmDialog;

/**
 * Created by thibaut on 30/05/17.
 */
public class Connexion extends JFrame {
    protected Toolkit kit = Toolkit . getDefaultToolkit ();
    protected Dimension d = kit.getScreenSize();
    public Connexion(ArrayList<User> liste_utilisateur, Session_connexion_controller session_controller)
    {
        JButton btn_retour = new JButton("Retour");
        JLabel lb_titre = new JLabel("Se connecter");
        JLabel lb_id = new JLabel("Identifiant : ");
        JTextField tf_id = new JTextField("",10);
        JLabel lb_mdp = new JLabel("Mot de passe : ");
        JPasswordField pf_mdp = new JPasswordField("",10);
        JButton btn_connexion = new JButton("Connexion");
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(new GridBagLayout());

        gbc.gridx=0;
        gbc.gridy=0;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(10, 15, 5, 15);
        getContentPane().add(lb_titre,gbc);
        gbc.gridx=0;
        gbc.gridy=1;
        gbc.gridwidth=1;
        gbc.insets = new Insets(10, 15, 5, 5);
        getContentPane().add(lb_id,gbc);
        gbc.gridx=0;
        gbc.gridy=2;
        gbc.insets = new Insets(5, 15, 10, 5);
        getContentPane().add(lb_mdp,gbc);
        gbc.gridx=0;
        gbc.gridy=3;
        gbc.insets = new Insets(5, 15, 5, 5);
        getContentPane().add(btn_retour,gbc);
        gbc.gridx=1;
        gbc.gridy=3;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(5, 5, 5, 15);
        getContentPane().add(btn_connexion,gbc);


        gbc.gridx=1;
        gbc.gridy=1;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(10, 5, 5, 15);
        getContentPane().add(tf_id,gbc);
        gbc.gridx=1;
        gbc.gridy=2;
        gbc.insets = new Insets(5, 5, 10, 15);
        getContentPane().add(pf_mdp,gbc);


        btn_retour.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                        menu_profil f = new menu_profil(liste_utilisateur);
                    }
                }
        );

        btn_connexion.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (isRoot(tf_id.getText(), pf_mdp.getText())) {
                            //Possibilité d'ajouter une interface d'administrateur
                        } else if (id_mdp_isValid(tf_id.getText(), pf_mdp.getText(), liste_utilisateur)) {
                            //Connexion donc passage à la fenêtre suivante
                            JOptionPane.showMessageDialog(null, "Bienvenue "+tf_id.getText(),"Accès autorisé",JOptionPane.INFORMATION_MESSAGE);
                            Session_connexion_controller session_controller = new Session_connexion_controller();
                            session_controller.setSession("CONFIRMED",tf_id.getText());
                            //Transmettre le controleur de session a la fenetre suivante
                            dispose();
                            Mode_view_abstract next_view = new Mode_confirmed_view(session_controller);

                        } else {
                            JOptionPane.showMessageDialog(null, "Aucun utilisateur avec ces identifiants","Erreur authentification",JOptionPane.ERROR_MESSAGE);
                        }

                    }
                }
        );


        setTitle ("Se connecter") ;
        setSize(d.width / 2, d.height /2);
        setLocation(d.width /4, d.height /4);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible (true);
    }

    public Boolean id_mdp_isValid(String id, String mdp, ArrayList<User> liste_utilisateur)
    {
        Boolean ok=false;
        int i;
        for(i=0;i<liste_utilisateur.size();i++)
        {
            if(liste_utilisateur.get(i).getID().equals(id) && liste_utilisateur.get(i).getMdp().equals(mdp))
            {
                ok=true;
            }
        }
        return ok;
    }

    public Boolean isRoot(String id, String mdp)
    {
        if(id.compareTo("root")==0 && mdp.compareTo("1234")==0)
        {
            return true;
        }else
        {
            return false;
        }
    }
}
