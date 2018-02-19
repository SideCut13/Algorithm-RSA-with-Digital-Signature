package rsa.panels;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.io.*;
import java.math.BigInteger;
import java.util.Random;

public class PanelRSA extends JPanel {
    private JLabel lAlgorithmRSA = new JLabel("Algorithm RSA - generation part");

    private JLabel lRange = new JLabel("Choose range to generate p and q:");
    private JRadioButton rbFromZero = new JRadioButton("0-99");
    private JRadioButton rbFromHundred = new JRadioButton("100-999");
    private JRadioButton rbFromThousand = new JRadioButton("1000-9999");
    private JRadioButton rbFromTenThousand = new JRadioButton("10000-99999");
    private ButtonGroup btnGroup = new ButtonGroup();

    private JLabel lP = new JLabel("p:");
    private JTextField tfP = new JTextField(10);
    private JLabel lQ = new JLabel("q:");
    private JTextField tfQ = new JTextField(10);
    private JButton btnPAndQ = new JButton("Generate p and q");

    private JLabel lPhi = new JLabel("φ:");
    private JTextField tfPhi = new JTextField(10);
    private JButton btnPhi = new JButton("Generate φ");

    private JLabel lN = new JLabel("n:");
    private JTextField tfN = new JTextField(10);
    private JButton btnN = new JButton("Generate n");
    private JButton btnSaveN = new JButton("Save n");

    private JLabel lE = new JLabel("Public key:");
    private JTextField tfE = new JTextField(18);
    private JButton btnE = new JButton("Generate public key");
    private JButton btnSaveE = new JButton("Save public key");

    private JButton btnD = new JButton("Generate private key");
    private JButton btnSaveD = new JButton("Save private key");

    public PanelRSA() {
        super(new GridBagLayout());
        setBackground(new Color(0, 208, 166));
        //-------------------------ALGORITHM RSA-----------------------------------------
        JPanel panelAlgorithmRSA = new JPanel(new GridBagLayout());
        GridBagConstraints gbcPanelAlgorithmRSA = new GridBagConstraints();
        panelAlgorithmRSA.setBackground(new Color(0, 208, 166));

        gbcPanelAlgorithmRSA.gridx = 0;
        gbcPanelAlgorithmRSA.gridy = 0;
        gbcPanelAlgorithmRSA.insets = new Insets(10, 0, 10, 0);
        lAlgorithmRSA.setFont(new Font("Calibri", Font.BOLD, 16));
        panelAlgorithmRSA.add(lAlgorithmRSA, gbcPanelAlgorithmRSA);
        //-------------------------RANGE FOR P AND Q-----------------------------------------
        JPanel panelRange = new JPanel(new GridBagLayout());
        GridBagConstraints gbcPanelRange = new GridBagConstraints();
        panelRange.setBackground(new Color(0, 208, 166));

        gbcPanelRange.gridx = 0;
        gbcPanelRange.gridy = 0;
        lRange.setFont(new Font("Calibri", Font.PLAIN, 16));
        panelRange.add(lRange, gbcPanelRange);
        //-------------------------RANGE RADIOBUTTONS FOR P AND Q-----------------------------------------
        JPanel panelRangeRadioButtons = new JPanel(new GridBagLayout());
        GridBagConstraints gbcPanelRangeRadioButtons = new GridBagConstraints();
        panelRangeRadioButtons.setBackground(new Color(0, 208, 166));

        gbcPanelRangeRadioButtons.gridx = 0;
        gbcPanelRangeRadioButtons.gridy = 0;
        rbFromZero.setBackground(new Color(0, 208, 166));
        rbFromZero.setFont(new Font("Calibri", Font.PLAIN, 16));
        panelRangeRadioButtons.add(rbFromZero, gbcPanelRangeRadioButtons);

        gbcPanelRangeRadioButtons.gridx = 1;
        gbcPanelRangeRadioButtons.gridy = 0;
        rbFromThousand.setBackground(new Color(0, 208, 166));
        rbFromThousand.setFont(new Font("Calibri", Font.PLAIN, 16));
        panelRangeRadioButtons.add(rbFromThousand, gbcPanelRangeRadioButtons);

        gbcPanelRangeRadioButtons.gridx = 0;
        gbcPanelRangeRadioButtons.gridy = 1;
        rbFromHundred.setBackground(new Color(0, 208, 166));
        rbFromHundred.setFont(new Font("Calibri", Font.PLAIN, 16));
        panelRangeRadioButtons.add(rbFromHundred, gbcPanelRangeRadioButtons);

        gbcPanelRangeRadioButtons.gridx = 1;
        gbcPanelRangeRadioButtons.gridy = 1;
        rbFromTenThousand.setBackground(new Color(0, 208, 166));
        rbFromTenThousand.setFont(new Font("Calibri", Font.PLAIN, 16));
        panelRangeRadioButtons.add(rbFromTenThousand, gbcPanelRangeRadioButtons);

        btnGroup.add(rbFromZero);
        btnGroup.add(rbFromHundred);
        btnGroup.add(rbFromThousand);
        btnGroup.add(rbFromTenThousand);
        //-------------------------P AND Q-----------------------------------------
        JPanel panelPAndQ = new JPanel(new GridBagLayout());
        GridBagConstraints gbcPanelPAndQ = new GridBagConstraints();
        panelPAndQ.setBackground(new Color(0, 208, 166));

        gbcPanelPAndQ.gridx = 0;
        gbcPanelPAndQ.gridy = 0;
        gbcPanelPAndQ.insets = new Insets(5, 5, 5, 5);
        lP.setFont(new Font("Calibri", Font.PLAIN, 16));
        panelPAndQ.add(lP, gbcPanelPAndQ);

        gbcPanelPAndQ.gridx = 1;
        gbcPanelPAndQ.gridy = 0;
        tfP.setEditable(false);
        tfP.setBorder(BorderFactory.createLoweredBevelBorder());
        tfP.setBackground(new Color(255, 255, 255));
        panelPAndQ.add(tfP, gbcPanelPAndQ);

        gbcPanelPAndQ.gridx = 2;
        gbcPanelPAndQ.gridy = 0;
        gbcPanelPAndQ.insets = new Insets(5, 5, 5, 5);
        lQ.setFont(new Font("Calibri", Font.PLAIN, 16));
        panelPAndQ.add(lQ, gbcPanelPAndQ);

        gbcPanelPAndQ.gridx = 3;
        gbcPanelPAndQ.gridy = 0;
        tfQ.setEditable(false);
        tfQ.setBorder(BorderFactory.createLoweredBevelBorder());
        tfQ.setBackground(new Color(255, 255, 255));
        panelPAndQ.add(tfQ, gbcPanelPAndQ);
        //-------------------------P AND Q BUTTON-----------------------------------------
        JPanel panelPAndQButton = new JPanel(new GridBagLayout());
        GridBagConstraints gbcPanelPAndQButton = new GridBagConstraints();
        panelPAndQButton.setBackground(new Color(0, 208, 166));

        gbcPanelPAndQButton.gridx = 0;
        gbcPanelPAndQButton.gridy = 0;
        gbcPanelPAndQButton.insets = new Insets(5, 5, 5, 5);
        btnPAndQ.setPreferredSize(new Dimension(150, 30));
        btnPAndQ.setBorder(BorderFactory.createRaisedBevelBorder());
        btnPAndQ.setBackground(new Color(203, 255, 181));
        btnPAndQ.addActionListener(e->generetePAndQ());
        panelPAndQButton.add(btnPAndQ, gbcPanelPAndQButton);
        //-------------------------PHI-----------------------------------------
        JPanel panelPhi = new JPanel(new GridBagLayout());
        GridBagConstraints gbcPanelPhi = new GridBagConstraints();
        panelPhi.setBackground(new Color(0, 208, 166));

        gbcPanelPhi.gridx = 0;
        gbcPanelPhi.gridy = 0;
        gbcPanelPhi.insets = new Insets(5, 5, 5, 5);
        lPhi.setFont(new Font("Calibri", Font.PLAIN, 16));
        panelPhi.add(lPhi, gbcPanelPhi);

        gbcPanelPhi.gridx = 1;
        gbcPanelPhi.gridy = 0;
        tfPhi.setEditable(false);
        tfPhi.setBorder(BorderFactory.createLoweredBevelBorder());
        tfPhi.setBackground(new Color(255, 255, 255));
        panelPhi.add(tfPhi, gbcPanelPhi);
        //-------------------------PHI BUTTON-----------------------------------------
        JPanel panelPhiButton = new JPanel(new GridBagLayout());
        GridBagConstraints gbcPanelPhiButton = new GridBagConstraints();
        panelPhiButton.setBackground(new Color(0, 208, 166));

        gbcPanelPhiButton.gridx = 0;
        gbcPanelPhiButton.gridy = 0;
        gbcPanelPhiButton.insets = new Insets(5, 5, 5, 10);
        btnPhi.setPreferredSize(new Dimension(150, 30));
        btnPhi.setBorder(BorderFactory.createRaisedBevelBorder());
        btnPhi.setBackground(new Color(203, 255, 181));
        btnPhi.addActionListener(e->generatePhi());
        panelPhiButton.add(btnPhi, gbcPanelPhiButton);
        //------------------------- N -----------------------------------------
        JPanel panelN = new JPanel(new GridBagLayout());
        GridBagConstraints gbcPanelN = new GridBagConstraints();
        panelN.setBackground(new Color(0, 208, 166));
        gbcPanelN.gridx = 0;
        gbcPanelN.gridy = 0;
        gbcPanelN.insets = new Insets(5, 5, 5, 5);
        lN.setFont(new Font("Calibri", Font.PLAIN, 16));
        panelN.add(lN, gbcPanelN);

        gbcPanelN.gridx = 1;
        gbcPanelN.gridy = 0;
        tfN.setEditable(false);
        tfN.setBorder(BorderFactory.createLoweredBevelBorder());
        tfN.setBackground(new Color(255, 255, 255));
        panelN.add(tfN, gbcPanelN);
        //------------------------- N BUTTON-----------------------------------------
        JPanel panelNButton = new JPanel(new GridBagLayout());
        GridBagConstraints gbcPanelNButton = new GridBagConstraints();
        panelNButton.setBackground(new Color(0, 208, 166));
        gbcPanelNButton.gridx = 0;
        gbcPanelNButton.gridy = 0;
        gbcPanelNButton.insets = new Insets(5, 5, 5, 5);
        btnN.setPreferredSize(new Dimension(150, 30));
        btnN.setBorder(BorderFactory.createRaisedBevelBorder());
        btnN.setBackground(new Color(203, 255, 181));
        btnN.addActionListener(e->generateN());
        panelNButton.add(btnN, gbcPanelNButton);

        gbcPanelNButton.gridx = 1;
        gbcPanelNButton.gridy = 0;
        gbcPanelNButton.insets = new Insets(5, 5, 5, 5);
        btnSaveN.setPreferredSize(new Dimension(150, 30));
        btnSaveN.setBorder(BorderFactory.createRaisedBevelBorder());
        btnSaveN.setBackground(new Color(203, 255, 181));
        btnSaveN.addActionListener(e->saveN());
        panelNButton.add(btnSaveN, gbcPanelNButton);
        //-------------------------PUBLIC KEY - E-----------------------------------------
        JPanel panelE = new JPanel(new GridBagLayout());
        GridBagConstraints gbcPanelE = new GridBagConstraints();
        panelE.setBackground(new Color(0, 208, 166));

        gbcPanelE.gridx = 0;
        gbcPanelE.gridy = 0;
        gbcPanelE.insets = new Insets(5, 5, 5, 5);
        lE.setFont(new Font("Calibri", Font.PLAIN, 16));
        panelE.add(lE, gbcPanelE);

        gbcPanelE.gridx = 1;
        gbcPanelE.gridy = 0;
        gbcPanelE.insets = new Insets(5, 5, 5, 5);
        tfE.setEditable(false);
        tfE.setBorder(BorderFactory.createLoweredBevelBorder());
        tfE.setBackground(new Color(255, 255, 255));
        panelE.add(tfE, gbcPanelE);
        //-------------------------PUBLIC KEY - E BUTTONS-----------------------------------------
        JPanel panelEButton = new JPanel(new GridBagLayout());
        GridBagConstraints gbcPanelEButton = new GridBagConstraints();
        panelEButton.setBackground(new Color(0, 208, 166));

        gbcPanelEButton.gridx = 0;
        gbcPanelEButton.gridy = 0;
        gbcPanelEButton.insets = new Insets(5, 5, 5, 5);
        btnE.setPreferredSize(new Dimension(150, 30));
        btnE.setBorder(BorderFactory.createRaisedBevelBorder());
        btnE.setBackground(new Color(203, 255, 181));
        btnE.addActionListener(e->generateE());
        panelEButton.add(btnE, gbcPanelEButton);

        gbcPanelEButton.gridx = 1;
        gbcPanelEButton.gridy = 0;
        gbcPanelEButton.insets = new Insets(5, 5, 5, 5);
        btnSaveE.setPreferredSize(new Dimension(150, 30));
        btnSaveE.setBorder(BorderFactory.createRaisedBevelBorder());
        btnSaveE.setBackground(new Color(203, 255, 181));
        btnSaveE.addActionListener(e->toFile(tfE.getText()));
        panelEButton.add(btnSaveE, gbcPanelEButton);
        //-------------------------PRIVATE KEY - D BUTTON-----------------------------------------
        JPanel panelDButton = new JPanel(new GridBagLayout());
        GridBagConstraints gbcPanelDButton = new GridBagConstraints();
        panelDButton.setBackground(new Color(0, 208, 166));

        gbcPanelDButton.gridx = 0;
        gbcPanelDButton.gridy = 0;
        gbcPanelDButton.insets = new Insets(5, 5, 0, 5);
        btnD.setPreferredSize(new Dimension(150, 30));
        btnD.setBorder(BorderFactory.createRaisedBevelBorder());
        btnD.setBackground(new Color(203, 255, 181));
        btnD.addActionListener(e->generateD());
        panelDButton.add(btnD, gbcPanelDButton);

        gbcPanelDButton.gridx = 1;
        gbcPanelDButton.gridy = 0;
        gbcPanelDButton.insets = new Insets(5, 5, 0, 5);
        btnSaveD.setPreferredSize(new Dimension(150, 30));
        btnSaveD.setBorder(BorderFactory.createRaisedBevelBorder());
        btnSaveD.setBackground(new Color(203, 255, 181));
        btnSaveD.addActionListener(e->toFile(generateD()));
        panelDButton.add(btnSaveD, gbcPanelDButton);
        //-------------------------MAIN-----------------------------------------
        GridBagConstraints gbcMain = new GridBagConstraints();
        gbcMain.gridx = 0;
        gbcMain.gridy = 0;
        add(panelAlgorithmRSA, gbcMain);
        gbcMain.gridx = 0;
        gbcMain.gridy = 1;
        add(panelRange, gbcMain);
        gbcMain.gridx = 0;
        gbcMain.gridy = 2;
        add(panelRangeRadioButtons, gbcMain);
        gbcMain.gridx = 0;
        gbcMain.gridy = 3;
        add(panelPAndQ, gbcMain);
        gbcMain.gridx = 0;
        gbcMain.gridy = 4;
        add(panelPAndQButton, gbcMain);
        gbcMain.gridx = 0;
        gbcMain.gridy = 5;
        add(panelPhi, gbcMain);
        gbcMain.gridx = 0;
        gbcMain.gridy = 6;
        add(panelPhiButton, gbcMain);
        gbcMain.gridx = 0;
        gbcMain.gridy = 7;
        add(panelN, gbcMain);
        gbcMain.gridx = 0;
        gbcMain.gridy = 8;
        add(panelNButton, gbcMain);
        gbcMain.gridx = 0;
        gbcMain.gridy = 9;
        add(panelE, gbcMain);
        gbcMain.gridx = 0;
        gbcMain.gridy = 10;
        add(panelEButton, gbcMain);
        gbcMain.gridx = 0;
        gbcMain.gridy = 11;
        add(panelDButton, gbcMain);
    }
    //CHECK IF OUR NUMBER IS PRIME OR NOT
    public boolean isPrime(Integer x){
        if(x == 0 || x == 4){
            return false;
        }
        for (int i = 2; i <= x/2; i++) {
            if(x%i == 0){
                return false;
            }
        }
        return true;
    }
    //GENERATE PRIME NUMBERS (P AND Q) WITH RANGE FROM RADIOBUTTONS
    public BigInteger generatePrimeNumbers(Integer x){
        Random rnd = new Random();
        if(rbFromZero.isSelected()){
            while(!isPrime(x)){
                x = rnd.nextInt(100)+ 0;
            }
        }
        if(rbFromHundred.isSelected()){
            while(!isPrime(x)){
                x = rnd.nextInt(900)+ 100;
            }
        }
        if(rbFromThousand.isSelected()){
            while(!isPrime(x)){
                x = rnd.nextInt(9000)+ 1000;
            }
        }
        if(rbFromTenThousand.isSelected()){
            while(!isPrime(x)){
                x = rnd.nextInt(90000)+ 10000;
            }
        }
        else{
            while (!isPrime(x)){
                x = rnd.nextInt(40)+ 11;
            }
        }
        BigInteger result = BigInteger.valueOf(x.intValue());
        return result;
    }
    //GENERATE P AND Q - TWO PRIME NUMBERS
    public void generetePAndQ(){
        BigInteger p = generatePrimeNumbers(0);
        BigInteger q = generatePrimeNumbers(0);
        while(p.equals(q)){
            p = generatePrimeNumbers(0);
            q = generatePrimeNumbers(0);
        }
        tfP.setText(String.valueOf(p));
        tfQ.setText(String.valueOf(q));
    }
    //GENERATE N FROM FORMULA N = P*Q
    public void generateN(){
        if(tfP.getText().isEmpty() || tfP.getText() == null || tfQ.getText().isEmpty() || tfQ.getText()==null){
            JOptionPane.showMessageDialog(null, "Please, generate P and Q!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            BigInteger p = new BigInteger(tfP.getText());
            BigInteger q = new BigInteger(tfQ.getText());
            BigInteger n = p.multiply(q);
            tfN.setText(String.valueOf(n));
        }
    }
    //SAVE N NUMBER
    public void saveN(){
        toFile(String.valueOf(tfN.getText()));
    }
    //GENERATE PHI FROM FORMULA PHI = (P-1)(Q-1)
    public void generatePhi(){
        if(tfP.getText().isEmpty() || tfP.getText() == null || tfQ.getText().isEmpty() || tfQ.getText()==null){
            JOptionPane.showMessageDialog(null, "Please, generate P and Q!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            BigInteger p = new BigInteger(tfP.getText());
            BigInteger q = new BigInteger(tfQ.getText());
            BigInteger phi = (p.subtract(BigInteger.ONE)).multiply((q.subtract(BigInteger.ONE)));
            tfPhi.setText(String.valueOf(phi));
        }
    }
    //CHECK IF PHI AND PUBLIC KEY E IS RELATIVELY PRIME
    public boolean relativelyPrime(BigInteger x, BigInteger phi){
        return greatestCommonDivisor(x.intValue(), phi.intValue()).equals(1);
    }
    //GREATEST COMMON DIVISOR OF PHI AND ANOTHER NUMBER FOR RELATIVELY PRIME FUNCTION
    public Integer greatestCommonDivisor(Integer x, Integer phi){
        BigInteger x1 = BigInteger.valueOf(x);
        BigInteger phi1 = BigInteger.valueOf(phi);
        BigInteger gcd = x1.gcd(phi1);
        return gcd.intValue();
    }
    //GENERATE PUBLIC KEY - E NUMBER wWHICH IS PRIME AND RELATIVELY PRIME WITH PHI
    public void generateE(){
        if(tfPhi.getText().isEmpty() || tfPhi.getText() == null){
            JOptionPane.showMessageDialog(null, "Please, generate φ!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            BigInteger phi = new BigInteger(tfPhi.getText());
            BigInteger e = BigInteger.ZERO;
            while(!relativelyPrime(e, phi)){
                e = generatePrimeNumbers(0);
            }
            tfE.setText(String.valueOf(e));
        }
    }
    //GENERATE PRIVATE KEY - D NUMBER
    public String generateD(){
        BigInteger d = BigInteger.ZERO;
        if(tfN.getText().isEmpty() || tfN.getText() == null){
            JOptionPane.showMessageDialog(null, "Please, generate n!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        if(tfE.getText().isEmpty() || tfE.getText() == null){
            JOptionPane.showMessageDialog(null, "Please, generate public key!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            BigInteger e = new BigInteger(tfE.getText());
            BigInteger phi = new BigInteger(tfPhi.getText());
            d = e.modInverse(phi);
        }
        return String.valueOf(d);
    }
    //FUNCTION SAVE TO FILE WITH JFILECHOOSER
    public void toFile(String output){
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setDialogTitle("Save a text file");
        jfc.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
        jfc.addChoosableFileFilter(filter);
        int returnValue = jfc.showSaveDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try{
                FileWriter fw = new FileWriter(jfc.getSelectedFile() + ".txt", false);
                PrintWriter pw = new PrintWriter(fw);
                pw.println(output);
                pw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
