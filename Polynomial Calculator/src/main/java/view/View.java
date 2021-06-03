package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JFrame {
    private JPanel contentPane;
    private JTextField polinom1;
    private JTextField polinom2;
    private JLabel rezultat1;
    private JLabel rezultat2;
    private JButton adunare;
    private JButton scadere;
    private JButton inmultire;
    private JButton impartire;
    private JButton derivare;
    private JButton integrare;

    public View() {
        this.setTitle("Polynomial Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 350, 300);
        contentPane = new JPanel();
        this.setContentPane(contentPane);
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        JPanel panel1 = new JPanel();
        JPanel panel11 = new JPanel();
        JLabel lblNewLabel = new JLabel("Polynomial Calculator");
        panel11.add(lblNewLabel);
        JPanel panel12 = new JPanel();
        panel1.setLayout(new FlowLayout());
        JPanel panel13 = new JPanel();
        panel1.setLayout(new FlowLayout());
        JPanel panel14 = new JPanel();
        panel1.setLayout(new FlowLayout());
        JLabel lblNewLabel_1 = new JLabel("First polynomial:");
        panel12.add(lblNewLabel_1);
        polinom1 = new JTextField(20);
        panel12.add(polinom1);
        JLabel lblNewLabel_2 = new JLabel("Second polynomial:");
        panel13.add(lblNewLabel_2);
        polinom2 = new JTextField(20);
        panel13.add(polinom2);
        rezultat1 = new JLabel("");
        rezultat2 = new JLabel("");
        panel14.add(rezultat1);
        panel14.add(rezultat2);
        panel14.setLayout(new BoxLayout(panel14, BoxLayout.Y_AXIS));
        panel1.add(panel11);
        panel1.add(panel12);
        panel1.add(panel13);
        panel1.add(panel14);
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        contentPane.add(panel1);
        JPanel panel2 = new JPanel();
        adunare = new JButton("Adunare");
        panel2.add(adunare);
        scadere = new JButton("Scadere");
        panel2.add(scadere);
        inmultire = new JButton("Inmultire");
        panel2.add(inmultire);
        impartire = new JButton("Impartire");
        panel2.add(impartire);
        derivare = new JButton("Derivare");
        panel2.add(derivare);
        integrare = new JButton("Integrare");
        panel2.add(integrare);
        panel2.setLayout(new GridLayout(0, 2));
        contentPane.add(panel2);
    }

    public void showError(String mesaj) {
        JOptionPane.showMessageDialog(this, mesaj);
    }

    public String getPolinom1() {
        return this.polinom1.getText();
    }

    public String getPolinom2() {
        return this.polinom2.getText();
    }

    public void setRezultat1(String rezultat) {
        this.rezultat1.setText(rezultat);
    }

    public void setRezultat2(String rezultat) {
        this.rezultat2.setText(rezultat);
    }

    public void addAdunareBtnListener(ActionListener actionListener) {
        this.adunare.addActionListener(actionListener);
    }

    public void addScadereBtnListener(ActionListener actionListener) {
        this.scadere.addActionListener(actionListener);
    }

    public void addInmultireBtnListener(ActionListener actionListener) {
        this.inmultire.addActionListener(actionListener);
    }

    public void addImpartireBtnListener(ActionListener actionListener) {
        this.impartire.addActionListener(actionListener);
    }

    public void addDerivareBtnListener(ActionListener actionListener) {
        this.derivare.addActionListener(actionListener);
    }

    public void addIntegrareBtnListener(ActionListener actionListener) {
        this.integrare.addActionListener(actionListener);
    }

}

