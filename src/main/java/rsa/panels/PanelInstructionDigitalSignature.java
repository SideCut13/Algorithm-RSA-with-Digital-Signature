package rsa.panels;

import javax.swing.*;
import java.awt.*;

public class PanelInstructionDigitalSignature extends JPanel {
    private JLabel lInstruction = new JLabel("Instruction of using Digital Signature");
    private JTextArea taInstruction = new JTextArea("• First of all we must generate public key.\n" +
            "and private key in RSA Algorithm Panel\n" +
            "• Then we must enter text to encrypt in Digital Signature Panel\n" +
            "• We can change text to bytes using right button\n" +
            "• We use private key from file in project 'privateKey.txt'\n    and public key from 'publicKey.txt'.\n" +
            "• We use private key to encrypt text\n    and public key to decrypt.\n");
    public PanelInstructionDigitalSignature(){
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