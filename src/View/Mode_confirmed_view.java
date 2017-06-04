package View;

import Controller.Session_connexion_controller;

import javax.swing.*;
import java.awt.*;

import static java.lang.System.exit;

/**
 * Created by thibaut on 04/06/17.
 */
public class Mode_confirmed_view extends Mode_view_abstract{

    public Mode_confirmed_view(Session_connexion_controller session_controller)
    {
        getContentPane().setLayout(new GridBagLayout());

        setTitle ("Apprentissage des langues - "+session_controller.getSession().getId()) ;
        setSize(d.width / 2, d.height /2);
        setLocation(d.width /4, d.height /4);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //pack();
        setVisible (true);
    }

}
