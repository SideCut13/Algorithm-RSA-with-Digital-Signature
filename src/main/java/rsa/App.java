package rsa;

import rsa.panels.PanelMain;

import javax.swing.*;
import java.awt.*;
public class App 
{
    public static void createAndShowGui()
    {
        JFrame frame = new JFrame("Algorithm RSA with Digital Signature - author: Anna Zdrojewska");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PanelMain panel = new PanelMain();
        panel.setVisible(true);
        frame.setContentPane(panel);
        frame.setJMenuBar(panel.createMenuBar());
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(214, 240, 248));
    }
    public static void main( String[] args )
    {
        javax.swing.SwingUtilities.invokeLater(
                () -> createAndShowGui()
        );
    }
}
