package View;

import Model.Langue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by thibaut on 04/06/17.
 */
public class Anonym_langue extends JFrame {
    private Toolkit kit = Toolkit . getDefaultToolkit ();
    private Dimension d = kit.getScreenSize();
    private JComboBox<String> cb_langue = new JComboBox<>();
    private JButton btn_valider = new JButton("Valider");

    public Anonym_langue()
    {
        for(Langue lang : Langue.values()){
            cb_langue.addItem(lang.toString());
        }

        btn_valider.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                        Mode_view_abstract anonym_view = new Mode_anonym_view(cb_langue.getSelectedItem().toString());
                    }
                }
        );

        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(cb_langue);
        getContentPane().add(btn_valider);

        setTitle ("Sélection d'une langue") ;
        setSize(d.width / 2, d.height /2);
        setLocation(d.width /4, d.height /4);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible (true);
    }
}
