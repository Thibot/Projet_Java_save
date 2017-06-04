package View;


import Controller.Session_connexion_controller;
import Model.Conjugaison;
import Model.Langue;
import Model.Lecon;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

/**
 * Created by thibaut on 04/06/17.
 */
public class Mode_anonym_view extends Mode_view_abstract{

    private JButton btn_accueil = new JButton("Accueil");
    private JButton btn_lecons = new JButton("Leçons");
    private JButton btn_quitter = new JButton("Quitter");
    private JLabel lb_titre = new JLabel("Accueil",JLabel.CENTER);
    private JLabel lb_contenu = new JLabel("",JLabel.CENTER);
    private JComboBox cb_lecon = new JComboBox();
    private JPanel pn_north;
    private JPanel pn_north_bis=new JPanel();
    private JPanel pn_center=new JPanel();
    private JLabel lb_exo = new JLabel();
    private Vector<Lecon> list_lecon=new Vector<>();


    public Mode_anonym_view(Vector<Lecon> list_Lecon)
    {
        for(int i=0;i<list_Lecon.size();i++)
        {
            this.list_lecon.add(list_Lecon.get(i));
        }

        cb_lecon.addItem("");
        cb_lecon.addItem("Conjugaison");
        cb_lecon.addItem("Grammaire");
        cb_lecon.addItem("Orthographe");
        cb_lecon.addItem("Vocabulaire");
        cb_lecon.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    AfficheListeExo(cb_lecon.getSelectedItem().toString());
                }
            }
        );

        getContentPane().setLayout(new BoxLayout(getContentPane(),BoxLayout.X_AXIS));
        Init_pn_menu();
        Init_pn_contenu();

        btn_accueil.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        pn_center.removeAll();
                        pn_north.removeAll();
                        lb_contenu.setText("Merci de créer un compte pour obtenir un historique");
                        pn_north.add(lb_contenu);
                        pn_center.add(pn_north,BorderLayout.NORTH);
                        pn_center.revalidate();
                        pn_center.repaint();
                    }
                }
        );

        btn_lecons.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
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
        lb_contenu.setText("Merci de créer un compte pour obtenir un historique");
        getContentPane().add(pn_contenu);
        pn_contenu.setLayout(new BorderLayout());
        pn_contenu.add(lb_titre,BorderLayout.NORTH);
        lb_titre.setFont(new Font("TimesNewRoman",Font.BOLD,24));
        pn_center.setLayout(new BorderLayout());
        pn_north = new JPanel();
        pn_north.add(lb_contenu);
        pn_north.setVisible(true);
        pn_north.setBorder(BorderFactory.createLineBorder(Color.white));
        pn_center.add(pn_north,BorderLayout.NORTH);
        pn_contenu.add(pn_center, BorderLayout.CENTER);
    }

    private void LeconBTN_Step1_Contenu()
    {

        pn_north.removeAll();
        pn_north.setLayout(new FlowLayout());
        lb_contenu.setText("Choisir un type de leçon : ");

        pn_north.add(lb_contenu);
        pn_north.add(cb_lecon);

        pn_north.revalidate();
        pn_north.repaint();
    }

    private void AfficheListeExo(String type_lecon)
    {
        if(!type_lecon.equals("")) {
            pn_north_bis.removeAll();
            JComboBox<String> cb_exo = new JComboBox<>();
            Boolean stop = true;
            pn_north.removeAll();

            int i = 0;

            while (stop) {
                if (list_lecon.get(i).toString().equals(type_lecon)) {
                    stop = false;
                } else {
                    i++;
                }
            }
            cb_exo.addItem("");
            for (int j = 0; j < list_lecon.get(i).getList_exercices().size(); j++) {
                cb_exo.addItem(list_lecon.get(i).getList_exercices().get(j).getNom());
            }

            cb_exo.addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            AfficheExo(cb_lecon.getSelectedItem().toString(), cb_exo.getSelectedItem().toString());
                        }
                    }
            );

            pn_north.add(lb_contenu);
            pn_north.add(cb_lecon);
            pn_north_bis.setLayout(new FlowLayout());
            pn_north_bis.add(cb_exo);
            pn_north_bis.revalidate();
            pn_north_bis.repaint();
            pn_north.add(pn_north_bis);
            pn_north.revalidate();
            pn_north.repaint();
        }
    }
    private void AfficheExo(String type_lecon,String exo)
    {
        if(!type_lecon.equals("") && !exo.equals("")) {
            Boolean stop = true;
            int i = 0;

            while (stop) {
                if (list_lecon.get(i).toString().equals(type_lecon)) {
                    stop = false;
                } else {
                    i++;
                }
            }
            stop = true;
            int j = 0;
            while (stop) {
                if (list_lecon.get(i).getList_exercices().get(j).getNom().equals(exo)) {
                    stop = false;
                } else {
                    j++;
                }
            }
            lb_exo.setText(list_lecon.get(i).getList_exercices().get(j).getContenu());

            pn_center.add(lb_exo, BorderLayout.CENTER);
            pn_center.revalidate();
            pn_center.repaint();
        }
    }
}
