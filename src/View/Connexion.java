package View;

import Model.User;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by thibaut on 30/05/17.
 */
public class Connexion extends JFrame {
    protected Toolkit kit = Toolkit . getDefaultToolkit ();
    protected Dimension d = kit.getScreenSize();
    public Connexion(ArrayList<User> liste_utilisateur)
    {
        JLabel lb_id = new JLabel("Identifiant : ");
        JTextField tf_id = new JTextField("",10);
        JLabel lb_mdp = new JLabel("Mot de passe : ");
        JPasswordField pf_mdp = new JPasswordField("",10);
        JButton btn_connexion = new JButton("Connexion");
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(new GridBagLayout());

        



        setTitle ("Se connecter") ;
        setSize(d.width / 2, d.height /2);
        setLocation(d.width /4, d.height /4);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible (true);
    }
}
