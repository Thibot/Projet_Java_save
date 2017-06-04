package View;

import Model.Conjugaison;
import Model.Lecon;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by thibaut on 04/06/17.
 */
public abstract class Mode_view_abstract extends JFrame {
    protected Toolkit kit = Toolkit . getDefaultToolkit ();
    protected Dimension d = kit.getScreenSize();
    protected JPanel pn_menu = new JPanel(); // panel à gauche de la fenêtre avec le menu
    protected JPanel pn_contenu = new JPanel(); // panel central dont le contenu va changer en fonction de l'endroit dans le menu

    public Mode_view_abstract() {}

    protected void Init_pn_menu() {}

    protected void Init_pn_contenu() {}

}
