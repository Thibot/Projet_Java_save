package View;

import Controller.Historique_Controller;
import Controller.Session_connexion_controller;
import Controller.User_controller;
import Model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by thibaut on 29/05/17.
 */
public class form_create_user extends JFrame {
    protected Toolkit kit = Toolkit . getDefaultToolkit ();
    protected Dimension d = kit.getScreenSize();
    private JLabel lb_nom = new JLabel("Nom : ");
    private JLabel lb_prenom = new JLabel("Prénom : ");
    private JLabel lb_id = new JLabel("ID : ");
    private JLabel lb_mdp = new JLabel("Mot de passe : ");
    private JLabel lb_age = new JLabel("Age : ");
    private JLabel lb_genre = new JLabel("Genre (H/F) : ");
    private JLabel lb_langue = new JLabel("Langue : ");
    private JTextField tf_nom = new JTextField("",10);
    private JTextField tf_prenom = new JTextField("",10);
    private JTextField tf_id = new JTextField("",10);
    private JPasswordField pf_mdp = new JPasswordField("",10);
    private JTextField tf_age = new JTextField("",10);
    private JTextField tf_genre = new JTextField("",10);
    private JComboBox cb_langue = new JComboBox();
    private Vector<Lecon> list_lecon = new Vector<>();

    /**
     * Constructeur de la vue du formulaire d'inscription
     * @param liste_utilisateur,histo
     */
    public form_create_user(ArrayList<User> liste_utilisateur, Historique_Controller histo)
    {

        for(Langue lang : Langue.values()){
            cb_langue.addItem(lang.toString());
        }

        JButton btn_retour = new JButton("Retour");
        JButton btn_valider = new JButton("Valider");
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(new GridBagLayout());

        //colonne gauche
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.insets = new Insets(20, 20, 5, 5);
        getContentPane().add(lb_nom,gbc);
        gbc.gridy=1;
        gbc.insets = new Insets(5, 20, 5, 5);
        getContentPane().add(lb_prenom,gbc);
        gbc.gridy=2;
        getContentPane().add(lb_id,gbc);
        gbc.gridy=3;
        getContentPane().add(lb_mdp,gbc);
        gbc.gridy=4;
        getContentPane().add(lb_age,gbc);
        gbc.gridy=5;
        getContentPane().add(lb_genre,gbc);
        gbc.gridy=6;
        getContentPane().add(lb_langue,gbc);
        gbc.gridy=7;
        gbc.insets = new Insets(5, 20, 20, 5);
        getContentPane().add(btn_retour,gbc);

        //Colonne droite
        gbc.gridx=1;
        gbc.gridy=0;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(20, 5, 5, 20);
        getContentPane().add(tf_nom,gbc);
        gbc.gridy=1;
        gbc.insets = new Insets(5, 5, 5, 20);
        getContentPane().add(tf_prenom,gbc);
        gbc.gridy=2;
        getContentPane().add(tf_id,gbc);
        gbc.gridy=3;
        getContentPane().add(pf_mdp,gbc);
        gbc.gridy=4;
        getContentPane().add(tf_age,gbc);
        gbc.gridy=5;
        getContentPane().add(tf_genre,gbc);
        gbc.gridy=6;
        getContentPane().add(cb_langue,gbc);
        gbc.gridy=7;
        gbc.insets = new Insets(5, 5, 20, 20);
        getContentPane().add(btn_valider,gbc);

        //Listener
        btn_retour.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                        menu_profil f = new menu_profil(liste_utilisateur,histo);
                    }
                }
        );

        btn_valider.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        User_controller user_c = new User_controller();
                        if(user_c.UserExist(tf_id.getText(),liste_utilisateur) && user_c.CreateUser(tf_nom.getText(),tf_prenom.getText(),tf_id.getText(),pf_mdp.getText(),Integer.parseInt(tf_age.getText()),tf_genre.getText(),cb_langue.getSelectedItem().toString()))
                        {
                            liste_utilisateur.add(user_c.getUser());
                            dispose();
                            Session_connexion_controller session_controller = new Session_connexion_controller();
                            session_controller.setSession("CONFIRMED",tf_id.getText());
                            generateLecon();
                            Mode_confirmed_view next_view = new Mode_confirmed_view(session_controller,liste_utilisateur,histo,list_lecon);
                        }
                    }
                }
        );
        setTitle ("Création d'un compte") ;
        setSize(d.width / 2, d.height /2);
        setLocation(d.width /4, d.height /4);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible (true);
    }

    /**
     * Méthode générant la liste de lecon qui, avec une base de données, serait récupérée par un requette
     */
    private void generateLecon()   //Evolution : rechercher une liste de lecons correspondante à la langue sélectionnée
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
