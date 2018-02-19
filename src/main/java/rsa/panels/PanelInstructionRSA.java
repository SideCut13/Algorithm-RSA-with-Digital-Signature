package rsa.panels;

import javax.swing.*;
import java.awt.*;

public class PanelInstructionRSA extends JPanel {
    private JLabel lInstruction = new JLabel("Instruction of using RSA Algorithm");
    private JTextArea taInstruction = new JTextArea("• RSA generates public and private key.\n" +
            "• Fist of all in Algorithm RSA - generate part\n    we must generate two prime numbers: p and q.\n" +
            "• Then we must multiply them and the result\n    is product n which is from formula: n = p·q. It can be saved to file.\n" +
            "• The next value is φ which is from formula:\n    phi = (p-1)·(q-1).\n" +
            "• Public key: is value e generated randomly\n    so that together with the φ is relatively prime.\n" +
            "• Private key: is value d generated with Euclidean algorithm\n    from formula: d ≡(e^-1)modφ.\n" +
            "• This algorithm can generate p and q from four ranges:\n    0-99, 100-999, 1000-9999, 10000-99999. \n" +
            "• The user must choose one of them before start (otherwise range is 11-50).\n• The rest values are generate by pressing buttons.\n" +
            "• Order of pressing the buttons is from top to bottom.\n" +
            "• In next part (encryption/decryption) user must enter text to encrypt in text field.\n" +
            "• This text can be display in bytes by pressing right button.\n" +
            "• Text to encrypt is separate into block with length one letter.\n" +
            "• The public and private keys can be save in *.txt files\n" +
            "    and encrypted/decrypted text too.\n• Private key is not presented " +
            "in field\n    cause... it's private :)");
    public PanelInstructionRSA(){
        super(new GridBagLayout());
        setBackground(new Color(0, 208, 166));
        //-----------------------INSTRUCTION----------------------------------------
        JPanel panelInstruction = new JPanel(new GridBagLayout());
        GridBagConstraints gbcPanelInstruction = new GridBagConstraints();
        panelInstruction.setBackground(new Color(0, 208, 166));
        gbcPanelInstruction.gridx = 0;
        gbcPanelInstruction.gridy = 0;

        gbcPanelInstruction.insets = new Insets(10, 0, 10, 0);
        lInstruction.setFont(new Font("Calibri", Font.BOLD, 16));
        panelInstruction.add(lInstruction, gbcPanelInstruction);

        gbcPanelInstruction.gridx = 0;
        gbcPanelInstruction.gridy = 1;
        taInstruction.setFont(new Font("Calibri", Font.PLAIN, 14));
        taInstruction.setAlignmentX(Component.CENTER_ALIGNMENT);
        taInstruction.setBackground(new Color(0, 208, 166));
        panelInstruction.add(taInstruction, gbcPanelInstruction);
        //------------------------MAIN---------------------
        GridBagConstraints gbcMain = new GridBagConstraints();
        gbcMain.gridx = 0;
        gbcMain.gridy = 0;
        add(panelInstruction, gbcMain);
    }
}
