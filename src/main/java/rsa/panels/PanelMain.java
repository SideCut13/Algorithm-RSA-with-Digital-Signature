package rsa.panels;

import javax.swing.*;
import java.awt.*;

public class PanelMain extends JPanel {
    //-----------------------------ALL PANELS--------------------------------------
    private PanelInstructionRSA panelInstructionRSA;
    private PanelRSA panelRSA;
    private PanelEncryptionDecryptionRSA panelEncryptionDecryptionRSA;
    private PanelDigitalSignature panelDigitalSignature;
    private PanelInstructionDigitalSignature panelInstructionDigitalSignature;
    private final String PANEL_INSTRUCTION = "PANEL_INSTRUCTION";
    private final String PANEL_ALGORITHM_RSA = "PANEL_ALGORITHM_RSA";
    private final String PANEL_ENCRYPTION_DECRYPTION_RSA = "PANEL_ENCRYPTION_DECRYPTION_RSA";
    private final String PANEL_DIGITAL_SIGNATURE = "PANEL_DIGITAL_SIGNATURE";
    private final String PANEL_INSTRUCTION_DIGITAL_SIGNATURE = "PANEL_INSTRUCTION_DIGITAL_SIGNATURE";
    //-----------------------------ADDING PANELS TO MAIN PANEL--------------------------------------
    public PanelMain() {
        super(new CardLayout());
        panelInstructionRSA = new PanelInstructionRSA();
        add(panelInstructionRSA,PANEL_INSTRUCTION);
        panelRSA = new PanelRSA();
        add(panelRSA,PANEL_ALGORITHM_RSA);
        panelEncryptionDecryptionRSA = new PanelEncryptionDecryptionRSA();
        add(panelEncryptionDecryptionRSA, PANEL_ENCRYPTION_DECRYPTION_RSA);
        panelDigitalSignature = new PanelDigitalSignature();
        add(panelDigitalSignature,PANEL_DIGITAL_SIGNATURE);
        panelInstructionDigitalSignature = new PanelInstructionDigitalSignature();
        add(panelInstructionDigitalSignature, PANEL_INSTRUCTION_DIGITAL_SIGNATURE);
    }
    //-----------------------------CREATING MENU--------------------------------------
    public JMenuBar createMenuBar()
    {
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(203, 255, 181));
        JMenu menuPanele = new JMenu("Panels");

        JMenuItem menuPanelInstruction = new JMenuItem("Instruction of RSA Algorithm");
        menuPanelInstruction.setBackground(new Color(203, 255, 181));
        menuPanelInstruction.addActionListener(e -> {
            CardLayout cl = (CardLayout)getLayout();
            cl.show(this, PANEL_INSTRUCTION);
        });
        JMenuItem menuPanelInstructionDigitalSignature = new JMenuItem("Instruction of Digital Signature");
        menuPanelInstructionDigitalSignature.setBackground(new Color(203, 255, 181));
        menuPanelInstructionDigitalSignature.addActionListener(e -> {
            CardLayout cl = (CardLayout)getLayout();
            cl.show(this, PANEL_INSTRUCTION_DIGITAL_SIGNATURE);
        });
        JMenuItem menuPanelRSA = new JMenuItem("Algorithm RSA");
        menuPanelRSA.setBackground(new Color(203, 255, 181));
        menuPanelRSA.addActionListener(e -> {
            CardLayout cl = (CardLayout)getLayout();
            cl.show(this, PANEL_ALGORITHM_RSA);
        });
        JMenuItem menuPanelEncryptionDecryptionRSA = new JMenuItem("Encryption/Decryption with RSA");
        menuPanelEncryptionDecryptionRSA.setBackground(new Color(203, 255, 181));
        menuPanelEncryptionDecryptionRSA.addActionListener(e -> {
            CardLayout cl = (CardLayout)getLayout();
            cl.show(this, PANEL_ENCRYPTION_DECRYPTION_RSA);
        });
        JMenuItem menuPanelDigitalSignature = new JMenuItem("Digital signature");
        menuPanelDigitalSignature.setBackground(new Color(203, 255, 181));
        menuPanelDigitalSignature.addActionListener(e -> {
            CardLayout cl = (CardLayout)getLayout();
            cl.show(this, PANEL_DIGITAL_SIGNATURE);
        });
        menuPanele.add(menuPanelInstruction);
        menuPanele.addSeparator();
        menuPanele.add(menuPanelInstructionDigitalSignature);
        menuPanele.addSeparator();
        menuPanele.add(menuPanelRSA);
        menuPanele.addSeparator();
        menuPanele.add(menuPanelEncryptionDecryptionRSA);
        menuPanele.addSeparator();
        menuPanele.add(menuPanelDigitalSignature);
        menuBar.add(menuPanele);
        return menuBar;
    }
}
