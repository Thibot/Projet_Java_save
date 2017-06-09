package View;

import Controller.Historique_Controller;
import Model.Conjugaison;
import Model.Lecon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

/**
 * Created by thibaut on 04/06/17.
 */
public abstract class Mode_view_abstract extends JFrame {
    protected Toolkit kit = Toolkit . getDefaultToolkit ();
    protected Dimension d = kit.getScreenSize();
    protected JPanel pn_menu = new JPanel(); // panel à gauche de la fenêtre avec le menu
    protected JPanel pn_contenu = new JPanel(); // panel central dont le contenu va changer en fonction de l'endroit dans le menu
    protected JPanel pn_north_bis=new JPanel();
    protected JPanel pn_north=new JPanel();
    protected Vector<Lecon> list_lecon=new Vector<>();
    protected JLabel lb_exo = new JLabel();
    protected JPanel pn_center=new JPanel();
    protected Historique_Controller histo=new Historique_Controller();
    protected String Langue;
    protected JComboBox cb_lecon = new JComboBox();
    protected JLabel lb_contenu = new JLabel("",JLabel.CENTER);
    protected JLabel lb_titre = new JLabel("Accueil",JLabel.CENTER);

    public Mode_view_abstract() {
        cb_lecon.addItem("");
        cb_lecon.addItem("Conjugaison");
        cb_lecon.addItem("Grammaire");
        cb_lecon.addItem("Orthographe");
        cb_lecon.addItem("Vocabulaire");

    }

    protected void Init_pn_menu() {}

    protected void Init_pn_contenu()
    {
        AfficheHistorique();

        getContentPane().add(pn_contenu);
        pn_contenu.setLayout(new BorderLayout());
        pn_contenu.add(lb_titre,BorderLayout.NORTH);
        lb_titre.setFont(new Font("TimesNewRoman",Font.BOLD,24));
        pn_center.setLayout(new BorderLayout());
        pn_north.add(lb_contenu);
        pn_north.setVisible(true);
        pn_north.setBorder(BorderFactory.createLineBorder(Color.white));
        pn_center.add(pn_north,BorderLayout.NORTH);
        pn_contenu.add(pn_center, BorderLayout.CENTER);
    }

    private void AfficheHistorique()
    {
        pn_center.removeAll();
        pn_north.removeAll();

        if(histo.getHistorique().size()==0)
        {
            lb_contenu.setText("Aucun historique à afficher");
            pn_north.add(lb_contenu);
            pn_north.revalidate();
            pn_north.repaint();
            pn_center.add(pn_north,BorderLayout.NORTH);
            pn_center.revalidate();
            pn_center.repaint();

        }else
        {
            histo.getHisto().AfficheHisto();
            lb_contenu.setText(histo.getHisto().getAfficheHisto());
            pn_north.add(lb_contenu);
            pn_north.revalidate();
            pn_north.repaint();
            pn_center.add(pn_north,BorderLayout.CENTER);
            pn_center.revalidate();
            pn_center.repaint();
        }

    }

    protected void AfficheListeExo(String type_lecon)
    {
        if(!type_lecon.equals("")) {
            pn_north_bis.removeAll();
            JComboBox cb_exo = new JComboBox();
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

    protected void AfficheExo(String type_lecon,String exo)
    {
        int i = 0;
        int j = 0;
        if(!type_lecon.equals("") && !exo.equals("")) {
            Boolean stop = true;

            while (stop) {
                if (list_lecon.get(i).toString().equals(type_lecon)) {
                    stop = false;
                } else {
                    i++;
                }
            }
            stop = true;

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
            histo.addExoHisto(cb_lecon.getSelectedItem().toString(),list_lecon.get(i).getList_exercices().get(j),Langue);
        }
    }

    protected void LeconBTN_Step1_Contenu()
    {

        cb_lecon.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        AfficheListeExo(cb_lecon.getSelectedItem().toString());
                    }
                }
        );

        pn_north.removeAll();
        pn_north.setLayout(new FlowLayout());
        lb_contenu.setText("Choisir un type de leçon : ");

        pn_north.add(lb_contenu);
        pn_north.add(cb_lecon);

        pn_north.revalidate();
        pn_north.repaint();
    }

}
