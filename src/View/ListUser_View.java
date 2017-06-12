package View;

import Controller.Historique_Controller;
import Model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by thibaut on 12/06/17.
 */
public class ListUser_View extends JFrame {
    private Toolkit kit = Toolkit . getDefaultToolkit ();
    private Dimension d = kit.getScreenSize();
    private JPanel pn_list=new JPanel();
    private JButton btn_retour=new JButton("Retour");

    public ListUser_View(ArrayList<User> Liste_utilisateur)
    {
        String s="";
        setLayout(new BorderLayout());
        getContentPane().add(pn_list,BorderLayout.CENTER);
        getContentPane().add(btn_retour,BorderLayout.SOUTH);
        pn_list.setLayout(new GridLayout(Liste_utilisateur.size()+1,5));

        JLabel lb_user = new JLabel("<html><h2>Nom</h2></html>");
        lb_user.setHorizontalAlignment(JLabel.CENTER);
        pn_list.add(lb_user);
        lb_user = new JLabel("<html><h2>Prénom</h2></html>");
        lb_user.setHorizontalAlignment(JLabel.CENTER);
        pn_list.add(lb_user);
        lb_user = new JLabel("<html><h2>ID</h2></html>");
        lb_user.setHorizontalAlignment(JLabel.CENTER);
        pn_list.add(lb_user);
        lb_user = new JLabel("<html><h2>Age</h2></html>");
        lb_user.setHorizontalAlignment(JLabel.CENTER);
        pn_list.add(lb_user);
        lb_user = new JLabel("<html><h2>Langue</h2></html>");
        lb_user.setHorizontalAlignment(JLabel.CENTER);
        pn_list.add(lb_user);

        for(int i=0;i<Liste_utilisateur.size();i++)
        {
            lb_user = new JLabel("");
            lb_user.setText(Liste_utilisateur.get(i).getNom());
            lb_user.setHorizontalAlignment(JLabel.CENTER);
            pn_list.add(lb_user);
            lb_user = new JLabel("");
            lb_user.setText(Liste_utilisateur.get(i).getPrenom());
            lb_user.setHorizontalAlignment(JLabel.CENTER);
            pn_list.add(lb_user);
            lb_user = new JLabel("");
            lb_user.setText(Liste_utilisateur.get(i).getID());
            lb_user.setHorizontalAlignment(JLabel.CENTER);
            pn_list.add(lb_user);
            lb_user = new JLabel("");
            lb_user.setText(Integer.toString(Liste_utilisateur.get(i).getAge()));
            lb_user.setHorizontalAlignment(JLabel.CENTER);
            pn_list.add(lb_user);
            lb_user = new JLabel("");
            lb_user.setText(Liste_utilisateur.get(i).getLangue());
            lb_user.setHorizontalAlignment(JLabel.CENTER);
            pn_list.add(lb_user);

        }

            /*System.out.println(lb_user.getText());
            System.out.println(Liste_utilisateur.size());
            System.out.println(i);*/

        //System.out.println(lb_user.getText());

        pn_list.revalidate();
        pn_list.repaint();

        btn_retour.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                    }
                }
        );


        setTitle ("Liste des utilisateurs") ;
        setSize(d.width / 2, d.height /2);
        setLocation(d.width /4, d.height /4);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible (true);
    }
}
