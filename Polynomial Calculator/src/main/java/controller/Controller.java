package controller;

import model.Operatie;
import model.Polynomial;
import view.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private View view;

    public Controller(View view) {
        this.view = view;
        view.addAdunareBtnListener(new AdunareListener());
        view.addScadereBtnListener(new ScadereListener());
        view.addInmultireBtnListener(new InmultireListener());
        view.addImpartireBtnListener(new ImpartireListener());
        view.addDerivareBtnListener(new DerivareListener());
        view.addIntegrareBtnListener(new IntegrareListener());
    }

    class AdunareListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                String input1 = view.getPolinom1();
                String input2 = view.getPolinom2();
                Polynomial.verificareInput(input1);
                Polynomial.verificareInput(input2);
                Polynomial polinom1 = Polynomial.transformarePolinom(input1);
                Polynomial polinom2 = Polynomial.transformarePolinom(input2);
                Polynomial suma = Operatie.adunare(polinom1, polinom2);
                view.setRezultat1("Adunare: " + suma.toString());
                view.setRezultat2("");
            } catch (Exception ex) {
                view.showError("Bad input: " + ex.getMessage());
            }
        }
    }

    class ScadereListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                String input1 = view.getPolinom1();
                String input2 = view.getPolinom2();
                Polynomial.verificareInput(input1);
                Polynomial.verificareInput(input2);
                Polynomial polinom1 = Polynomial.transformarePolinom(input1);
                Polynomial polinom2 = Polynomial.transformarePolinom(input2);
                Polynomial dif = Operatie.scadere(polinom1, polinom2);
                view.setRezultat1("Scadere: " + dif.toString());
                view.setRezultat2("");
            } catch (Exception ex) {
                view.showError("Bad input: " + ex.getMessage());
            }
        }
    }

    class InmultireListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                String input1 = view.getPolinom1();
                String input2 = view.getPolinom2();
                Polynomial.verificareInput(input1);
                Polynomial.verificareInput(input2);
                Polynomial polinom1 = Polynomial.transformarePolinom(input1);
                Polynomial polinom2 = Polynomial.transformarePolinom(input2);
                Polynomial inmul = Operatie.inmultire(polinom1, polinom2);
                view.setRezultat1("Inmultire: " + inmul.toString());
                view.setRezultat2("");
            } catch (Exception ex) {
                view.showError("Bad input: " + ex.getMessage());
            }
        }
    }

    class ImpartireListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                String input1 = view.getPolinom1();
                String input2 = view.getPolinom2();
                Polynomial.verificareInput(input1);
                Polynomial.verificareInput(input2);
                Polynomial polinom1 = Polynomial.transformarePolinom(input1);
                Polynomial polinom2 = Polynomial.transformarePolinom(input2);
                Polynomial cat = new Polynomial();
                Polynomial rest = new Polynomial();
                Operatie.impartire(polinom1, polinom2, cat, rest);
                view.setRezultat1("Cat: " + cat.toString());
                view.setRezultat2("Rest: " + rest.toString());
            } catch (Exception ex) {
                view.showError("Bad input: " + ex.getMessage());
            }
        }
    }

    class DerivareListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                String input1 = view.getPolinom1();
                Polynomial.verificareInput(input1);
                Polynomial polinom1 = Polynomial.transformarePolinom(input1);
                Polynomial deriv = Operatie.derivare(polinom1);
                view.setRezultat1("Derivare: " + deriv.toString());
                view.setRezultat2("");
            } catch (Exception ex) {
                view.showError("Bad input: " + ex.getMessage());
            }
        }
    }

    class IntegrareListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                String input1 = view.getPolinom1();
                Polynomial.verificareInput(input1);
                Polynomial polinom1 = Polynomial.transformarePolinom(input1);
                Polynomial intg = Operatie.integrare(polinom1);
                view.setRezultat1("Integrare: " + intg.toString());
                view.setRezultat2("");
            } catch (Exception ex) {
                view.showError("Bad input: " + ex.getMessage());
            }
        }
    }
}
