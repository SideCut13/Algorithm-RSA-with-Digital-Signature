package rsa.panels;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class PanelDigitalSignature extends JPanel {

    private JLabel lAlgorithmRSA = new JLabel("Digital Signature with RSA");

    private JLabel lText = new JLabel("Enter text:");
    private JTextField tfText = new JTextField(18);

    private JLabel lTextInBytes = new JLabel("Text in bytes:");
    private JTextField tfTextInBytes = new JTextField(18);
    private JButton btnTextInBytes = new JButton("Get text in bytes");

    private JLabel lLoadN = new JLabel("n:");
    private JTextField tfLoadN = new JTextField(18);
    private JButton btnLoadN = new JButton("Get n from file");

    private JLabel lEncryptedText = new JLabel("Encrypted text:");
    private JTextField tfEncryptedText = new JTextField(18);
    private JButton btnEncryptFromFile =  new JButton("Encrypt with private key from file");

    private JLabel lPublicKey = new JLabel("Public key:");
    private JTextField tfPublicKey = new JTextField(18);
    private JButton btnPublicKey = new JButton("Get public key from file");

    private JLabel lDecryptedText = new JLabel("Decrypted text:");
    private JTextField tfDecryptedText = new JTextField(18);
    private JButton btnDecryptFromFile = new JButton("Decrypt with public key from file");

    private String[] encryptedMessage;

    public PanelDigitalSignature() {
        super(new GridBagLayout());
        setBackground(new Color(0, 208, 166));
        //-------------------------ALGORITHM RSA LABEL-----------------------------------------
        JPanel panelAlgorithmRSA = new JPanel(new GridBagLayout());
        GridBagConstraints gbcPanelAlgorithmRSA = new GridBagConstraints();
        panelAlgorithmRSA.setBackground(new Color(0, 208, 166));

        gbcPanelAlgorithmRSA.gridx = 0;
        gbcPanelAlgorithmRSA.gridy = 0;
        gbcPanelAlgorithmRSA.insets = new Insets(10,0,10,0);
        lAlgorithmRSA.setFont(new Font("Calibri", Font.BOLD, 16));
        panelAlgorithmRSA.add(lAlgorithmRSA, gbcPanelAlgorithmRSA);

        //-------------------------TEXT ALGORITHM RSA-----------------------------------------
        JPanel panelText = new JPanel(new GridBagLayout());
        GridBagConstraints gbcPanelText = new GridBagConstraints();
        panelText.setBackground(new Color(0, 208, 166));

        gbcPanelText.gridx = 0;
        gbcPanelText.gridy = 0;
        gbcPanelText.insets = new Insets(10, 5, 5, 5);
        lText.setFont(new Font("Calibri", Font.PLAIN, 16));
        panelText.add(lText, gbcPanelText);

        gbcPanelText.gridx = 1;
        gbcPanelText.gridy = 0;
        gbcPanelText.insets = new Insets(10, 5, 5, 5);
        tfText.setEditable(true);
        tfText.setBorder(BorderFactory.createLoweredBevelBorder());
        tfText.setBackground(new Color(255, 255, 255));
        panelText.add(tfText, gbcPanelText);
        //-------------------------TEXT IN BYTES-----------------------------------------
        JPanel panelTextInBytes = new JPanel(new GridBagLayout());
        GridBagConstraints gbcPanelTextInBytes = new GridBagConstraints();
        panelTextInBytes.setBackground(new Color(0, 208, 166));

        gbcPanelTextInBytes.gridx = 0;
        gbcPanelTextInBytes.gridy = 1;
        gbcPanelTextInBytes.insets = new Insets(5, 5, 5, 5);
        lTextInBytes.setFont(new Font("Calibri", Font.PLAIN, 16));
        panelTextInBytes.add(lTextInBytes, gbcPanelTextInBytes);

        gbcPanelTextInBytes.gridx = 1;
        gbcPanelTextInBytes.gridy = 1;
        gbcPanelTextInBytes.insets = new Insets(5, 5, 5, 5);
        tfTextInBytes.setEditable(false);
        tfTextInBytes.setBorder(BorderFactory.createLoweredBevelBorder());
        tfTextInBytes.setBackground(new Color(255, 255, 255));
        panelTextInBytes.add(tfTextInBytes, gbcPanelTextInBytes);
        //-------------------------TEXT IN BYTES BUTTON-----------------------------------------
        JPanel panelTextInBytesButton = new JPanel(new GridBagLayout());
        GridBagConstraints gbcPanelTextInBytesButton = new GridBagConstraints();
        panelTextInBytesButton.setBackground(new Color(0, 208, 166));

        gbcPanelTextInBytesButton.gridx = 0;
        gbcPanelTextInBytesButton.gridy = 0;
        gbcPanelTextInBytesButton.insets = new Insets(5, 5, 0, 5);
        btnTextInBytes.setPreferredSize(new Dimension(150, 30));
        btnTextInBytes.setBorder(BorderFactory.createRaisedBevelBorder());
        btnTextInBytes.setBackground(new Color(203, 255, 181));
        btnTextInBytes.addActionListener(e->getTextInBytes());
        panelTextInBytesButton.add(btnTextInBytes, gbcPanelTextInBytesButton);
        //------------------------- N -----------------------------------------
        JPanel panelLoadN = new JPanel(new GridBagLayout());
        GridBagConstraints gbcPanelLoadN = new GridBagConstraints();
        panelLoadN.setBackground(new Color(0, 208, 166));

        gbcPanelLoadN.gridx = 0;
        gbcPanelLoadN.gridy = 1;
        gbcPanelLoadN.insets = new Insets(10, 5, 5, 5);
        lLoadN.setFont(new Font("Calibri", Font.PLAIN, 16));
        panelLoadN.add(lLoadN, gbcPanelLoadN);

        gbcPanelLoadN.gridx = 1;
        gbcPanelLoadN.gridy = 1;
        gbcPanelLoadN.insets = new Insets(10, 150, 5, 5);
        tfLoadN.setEditable(false);
        tfLoadN.setBorder(BorderFactory.createLoweredBevelBorder());
        tfLoadN.setBackground(new Color(255, 255, 255));
        panelLoadN.add(tfLoadN, gbcPanelLoadN);
        //-------------------------LOAD N BUTTON-----------------------------------------
        JPanel panelLoadNButton = new JPanel(new GridBagLayout());
        GridBagConstraints gbcPanelLoadNButton = new GridBagConstraints();
        panelLoadNButton.setBackground(new Color(0, 208, 166));

        gbcPanelLoadNButton.gridx = 0;
        gbcPanelLoadNButton.gridy = 0;
        gbcPanelLoadNButton.insets = new Insets(5, 5, 5, 5);
        btnLoadN.setPreferredSize(new Dimension(150, 30));
        btnLoadN.setBorder(BorderFactory.createRaisedBevelBorder());
        btnLoadN.setBackground(new Color(203, 255, 181));
        btnLoadN.addActionListener(e->loadN());
        panelLoadNButton.add(btnLoadN, gbcPanelLoadNButton);
        //-------------------------ENCRYPTED TEXT-----------------------------------------
        JPanel panelEncryptedText = new JPanel(new GridBagLayout());
        GridBagConstraints gbcPanelEncryptedText = new GridBagConstraints();
        panelEncryptedText.setBackground(new Color(0, 208, 166));

        gbcPanelEncryptedText.gridx = 0;
        gbcPanelEncryptedText.gridy = 0;
        gbcPanelEncryptedText.insets = new Insets(5, 5, 5, 5);
        lEncryptedText.setFont(new Font("Calibri", Font.PLAIN, 16));
        panelEncryptedText.add(lEncryptedText, gbcPanelEncryptedText);

        gbcPanelEncryptedText.gridx = 1;
        gbcPanelEncryptedText.gridy = 0;
        gbcPanelEncryptedText.insets = new Insets(5, 5, 5, 5);
        tfEncryptedText.setEditable(true);
        tfEncryptedText.setBorder(BorderFactory.createLoweredBevelBorder());
        tfEncryptedText.setBackground(new Color(255, 255, 255));
        panelEncryptedText.add(tfEncryptedText, gbcPanelEncryptedText);
        //-------------------------ENCRYPT BUTTON-----------------------------------------
        JPanel panelEncryptButton = new JPanel(new GridBagLayout());
        GridBagConstraints gbcPanelEncryptButton = new GridBagConstraints();
        panelEncryptButton.setBackground(new Color(0, 208, 166));

        gbcPanelEncryptButton.gridx = 0;
        gbcPanelEncryptButton.gridy = 0;
        gbcPanelEncryptButton.insets = new Insets(5, 10, 5, 5);
        btnEncryptFromFile.setPreferredSize(new Dimension(200, 30));
        btnEncryptFromFile.setBorder(BorderFactory.createRaisedBevelBorder());
        btnEncryptFromFile.setBackground(new Color(203, 255, 181));
        btnEncryptFromFile.addActionListener(e-> encryptFormFileWithPrivateKey());
        panelEncryptButton.add(btnEncryptFromFile, gbcPanelEncryptButton);
        //-------------------------PUBLIC KEY TEXT-----------------------------------------
        JPanel panelPublicKeyText = new JPanel(new GridBagLayout());
        GridBagConstraints gbcPanelPublicKeyText = new GridBagConstraints();
        panelPublicKeyText.setBackground(new Color(0, 208, 166));

        gbcPanelPublicKeyText.gridx = 0;
        gbcPanelPublicKeyText.gridy = 0;
        gbcPanelPublicKeyText.insets = new Insets(5, 5, 5, 5);
        lPublicKey.setFont(new Font("Calibri", Font.PLAIN, 16));
        panelPublicKeyText.add(lPublicKey, gbcPanelPublicKeyText);

        gbcPanelPublicKeyText.gridx = 1;
        gbcPanelPublicKeyText.gridy = 0;
        gbcPanelPublicKeyText.insets = new Insets(5, 5, 5, 5);
        tfPublicKey.setEditable(true);
        tfPublicKey.setBorder(BorderFactory.createLoweredBevelBorder());
        tfPublicKey.setBackground(new Color(255, 255, 255));
        panelPublicKeyText.add(tfPublicKey, gbcPanelPublicKeyText);
        //-------------------------PUBLIC KEY BUTTON-----------------------------------------
        JPanel panelPublicKeyButton = new JPanel(new GridBagLayout());
        GridBagConstraints gbcPanelPublicKeyButton = new GridBagConstraints();
        panelPublicKeyButton.setBackground(new Color(0, 208, 166));

        gbcPanelPublicKeyButton.gridx = 0;
        gbcPanelPublicKeyButton.gridy = 0;
        gbcPanelPublicKeyButton.insets = new Insets(5, 10, 5, 5);
        btnPublicKey.setPreferredSize(new Dimension(150, 30));
        btnPublicKey.setBorder(BorderFactory.createRaisedBevelBorder());
        btnPublicKey.setBackground(new Color(203, 255, 181));
        btnPublicKey.addActionListener(e-> publicKeyFromFile("publicKey.txt"));
        panelPublicKeyButton.add(btnPublicKey, gbcPanelPublicKeyButton);
        //-------------------------DECRYPTED TEXT-----------------------------------------
        JPanel panelDecryptedText = new JPanel(new GridBagLayout());
        GridBagConstraints gbcPanelDecryptedText = new GridBagConstraints();
        panelDecryptedText.setBackground(new Color(0, 208, 166));

        gbcPanelDecryptedText.gridx = 0;
        gbcPanelDecryptedText.gridy = 0;
        gbcPanelDecryptedText.insets = new Insets(5, 5, 5, 5);
        lDecryptedText.setFont(new Font("Calibri", Font.PLAIN, 16));
        panelDecryptedText.add(lDecryptedText, gbcPanelDecryptedText);

        gbcPanelDecryptedText.gridx = 1;
        gbcPanelDecryptedText.gridy = 0;
        gbcPanelDecryptedText.insets = new Insets(5, 5, 5, 5);
        tfDecryptedText.setEditable(false);
        tfDecryptedText.setBorder(BorderFactory.createLoweredBevelBorder());
        tfDecryptedText.setBackground(new Color(255, 255, 255));
        panelDecryptedText.add(tfDecryptedText, gbcPanelDecryptedText);
        //-------------------------DECRYPT BUTTON-----------------------------------------
        JPanel panelDencryptButton = new JPanel(new GridBagLayout());
        GridBagConstraints gbcPanelDecryptButton = new GridBagConstraints();
        panelDencryptButton.setBackground(new Color(0, 208, 166));

        gbcPanelDecryptButton.gridx = 0;
        gbcPanelDecryptButton.gridy = 0;
        gbcPanelDecryptButton.insets = new Insets(5, 10, 5, 5);
        btnDecryptFromFile.setPreferredSize(new Dimension(200, 30));
        btnDecryptFromFile.setBorder(BorderFactory.createRaisedBevelBorder());
        btnDecryptFromFile.setBackground(new Color(203, 255, 181));
        btnDecryptFromFile.addActionListener(e-> decryptFromFileWithPublicKey());
        panelDencryptButton.add(btnDecryptFromFile, gbcPanelDecryptButton);
        //-------------------------MAIN-----------------------------------------
        GridBagConstraints gbcMain = new GridBagConstraints();
        gbcMain.gridx = 0;
        gbcMain.gridy = 0;
        add(panelAlgorithmRSA, gbcMain);
        gbcMain.gridx = 0;
        gbcMain.gridy = 1;
        add(panelText, gbcMain);
        gbcMain.gridx = 0;
        gbcMain.gridy = 2;
        add(panelTextInBytes, gbcMain);
        gbcMain.gridx = 0;
        gbcMain.gridy = 3;
        add(panelTextInBytesButton, gbcMain);
        gbcMain.gridx = 0;
        gbcMain.gridy = 4;
        add(panelEncryptedText, gbcMain);
        gbcMain.gridx = 0;
        gbcMain.gridy = 5;
        add(panelEncryptButton, gbcMain);
        gbcMain.gridx = 0;
        gbcMain.gridy = 6;
        add(panelPublicKeyText, gbcMain);
        gbcMain.gridx = 0;
        gbcMain.gridy = 7;
        add(panelPublicKeyButton, gbcMain);
        gbcMain.gridx = 0;
        gbcMain.gridy = 8;
        add(panelDecryptedText, gbcMain);
        gbcMain.gridx = 0;
        gbcMain.gridy = 9;
        add(panelDencryptButton, gbcMain);
    }
    //GET TEXT IN BYTES TO ENCRYPT
    public void getTextInBytes(){
        byte[] message = tfText.getText().getBytes();
        tfTextInBytes.setText(Arrays.toString(message).replaceAll("\\[|\\]|,", "").trim());
    }
    //LOAD N FROM FILE
    public void loadN(){
        String n = fromFile();
        tfLoadN.setText(n);
    }
    public void encryptFormFileWithPrivateKey(){
        BigInteger n = new BigInteger(fromFile());
        BigInteger d = new BigInteger(fromFile());
        byte[] message = tfText.getText().getBytes();
        String[] tempStringArray = new String[message.length];
        encryptedMessage = new String[message.length];
        for (int i = 0; i < message.length; i++) {
            tempStringArray[i] = String.valueOf(message[i]);
            encryptedMessage[i] = String.valueOf(new BigInteger(tempStringArray[i]).modPow(d,n));
        }
        tfEncryptedText.setText(Arrays.toString(encryptedMessage).replaceAll("\\[|\\]|,", "").trim());
    }
    public void decryptFromFileWithPublicKey(){
        BigInteger n = new BigInteger(fromFile());
        BigInteger e = new BigInteger(fromFile());
        String s = tfEncryptedText.getText();
        String[] encrypted = s.split(" ");
        String[] decrypted = new String[encrypted.length];
        for (int i = 0; i < encrypted.length; i++) {
            decrypted[i] = String.valueOf(new BigInteger(encrypted[i]).modPow(e, n));
        }
        char[] charCode = new char[decrypted.length];
        for (int i = 0; i < charCode.length; i++) {
            charCode[i] = (char)Integer.parseInt(decrypted[i]);
        }
        String decryptedString = String.valueOf(charCode);
        tfDecryptedText.setText(decryptedString);
    }
    public String publicKeyFromFile(String filename){
        String s = "";
        File file = new File(filename);
        try {
            Scanner sc = new Scanner(file);
            while(sc.hasNext()){
                s = sc.next();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        tfPublicKey.setText(s);
        return s;
    }
    //GET TEXT FROM FILE WITH JFILECHOOSER FUNCTION
    public String fromFile(){
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        String s = "";
        jfc.setDialogTitle("Select a text file");
        jfc.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
        jfc.addChoosableFileFilter(filter);
        int returnValue = jfc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            try {
                Scanner sc = new Scanner(selectedFile);
                while(sc.hasNext()){
                    s = sc.nextLine();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return s;
    }
}
