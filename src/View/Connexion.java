package View;

import Controller.Historique_Controller;
import Controller.Session_connexion_controller;
import Model.*;

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
    private ArrayList<User> list_user;
    private Vector<Lecon> list_lecon = new Vector<>();
    private JButton btn_retour = new JButton("Retour");
    private JLabel lb_titre = new JLabel("Se connecter");
    private JLabel lb_id = new JLabel("Identifiant : ");
    private JTextField tf_id = new JTextField("",10);
    private JLabel lb_mdp = new JLabel("Mot de passe : ");
    private JPasswordField pf_mdp = new JPasswordField("",10);
    private JButton btn_connexion = new JButton("Connexion");
    private int nb_essais=3;

    /**
     * Constructeur de la vue de connexion
     * @param liste_utilisateur,session_controller,histo
     */
    public Connexion(ArrayList<User> liste_utilisateur, Session_connexion_controller session_controller, Historique_Controller histo)
    {

        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(new GridBagLayout());

        list_user=liste_utilisateur;

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
                        menu_profil f = new menu_profil(liste_utilisateur,histo);
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
                            generateLecon();
                            Mode_view_abstract next_view = new Mode_confirmed_view(session_controller, liste_utilisateur,histo,list_lecon);

                        } else {
                            nb_essais--;
                            if(nb_essais==0)
                            {
                                dispose();
                                menu_profil f = new menu_profil(liste_utilisateur,histo);
                            }else
                            {
                                JOptionPane.showMessageDialog(null, "Aucun utilisateur avec ces identifiants. Encore "+nb_essais+" essais disponibles","Erreur authentification",JOptionPane.ERROR_MESSAGE);
                            }
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

    /**
     * Méthode vérifiant la validité du mot de passe
     * @return boolean
     */
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

    /**
     * Méthode vérifiant si les identifiants sont ceux de l'administrateur pour une possible interface administrateur
     * @param id,mdp
     * @return boolean
     */
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

    /**
     * Méthode générant la liste de lecon qui, avec une base de données, serait récupérée par un requette
     */
    private void generateLecon()   //Evolution : rechercher une liste de lecons correspondante à la langue sélectionnée
    {
        Conjugaison conjugaison = new Conjugaison(getLangueById(tf_id.getText()));
        conjugaison.addExercice(new Exercice("Exercice Conjugaison 1"));
        conjugaison.addExercice(new Exercice("Exercice Conjugaison 2"));
        conjugaison.addExercice(new Exercice("Exercice Conjugaison 3"));
        conjugaison.addExercice(new Exercice("Exercice Conjugaison 4"));
        conjugaison.addExercice(new Exercice("Exercice Conjugaison 5"));
        Grammaire grammaire = new Grammaire(tf_id.getText());
        grammaire.addExercice(new Exercice("Exercice Grammaire 1"));
        grammaire.addExercice(new Exercice("Exercice Grammaire 2"));
        grammaire.addExercice(new Exercice("Exercice Grammaire 3"));
        grammaire.addExercice(new Exercice("Exercice Grammaire 4"));
        grammaire.addExercice(new Exercice("Exercice Grammaire 5"));
        Orthographe orthographe = new Orthographe(tf_id.getText());
        orthographe.addExercice(new Exercice("Exercice Orthographe 1"));
        orthographe.addExercice(new Exercice("Exercice Orthographe 2"));
        orthographe.addExercice(new Exercice("Exercice Orthographe 3"));
        orthographe.addExercice(new Exercice("Exercice Orthographe 4"));
        orthographe.addExercice(new Exercice("Exercice Orthographe 5"));
        Vocabulaire vocabulaire = new Vocabulaire(tf_id.getText());
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

    /**
     * Méthode retournant la langue d'un utilisateur
     * @param id
     * @return String
     */
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
}
