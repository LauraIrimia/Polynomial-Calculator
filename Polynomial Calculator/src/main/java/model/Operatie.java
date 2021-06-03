package model;

import java.util.ArrayList;

public class Operatie {
    public static Polynomial adunare(Polynomial p1, Polynomial p2) {
        Polynomial p = new Polynomial();
        Polynomial poli = new Polynomial();
        Monomial m;
        int size1 = p1.getPolinom().size() - 1, size2 = p2.getPolinom().size() - 1;
        while (size1 >= 0 && size2 >= 0) {
            m = new Monomial(p1.getPolinom().get(size1).getCoeficient() + p2.getPolinom().get(size2).getCoeficient(),
                    p1.getPolinom().get(size1).getPutere());
            p.addMonom(m);
            size1--;
            size2--;
        }
        while (size1 >= 0) {
            m = new Monomial(p1.getPolinom().get(size1).getCoeficient(), p1.getPolinom().get(size1).getPutere());
            p.addMonom(m);
            size1--;
        }
        while (size2 >= 0) {
            m = new Monomial(p2.getPolinom().get(size2).getCoeficient(), p2.getPolinom().get(size2).getPutere());
            p.addMonom(m);
            size2--;
        }
        for (int i = p.getPolinom().size() - 1; i >= 0; i--)
            poli.addMonom(p.getPolinom().get(i));
        return poli;
    }

    public static Polynomial scadere(Polynomial p1, Polynomial p2) {
        Polynomial p = new Polynomial();
        Polynomial poli = new Polynomial();
        Monomial m;
        int size1 = p1.getPolinom().size() - 1, size2 = p2.getPolinom().size() - 1;
        while (size1 >= 0 && size2 >= 0) {
            m = new Monomial(p1.getPolinom().get(size1).getCoeficient() - p2.getPolinom().get(size2).getCoeficient(),
                    p1.getPolinom().get(size1).getPutere());
            p.addMonom(m);
            size1--;
            size2--;
        }
        while (size1 >= 0) {
            m = new Monomial(p1.getPolinom().get(size1).getCoeficient(), p1.getPolinom().get(size1).getPutere());
            p.addMonom(m);
            size1--;
        }
        while (size2 >= 0) {
            m = new Monomial(-p2.getPolinom().get(size2).getCoeficient(), p2.getPolinom().get(size2).getPutere());
            p.addMonom(m);
            size2--;
        }
        for (int i = p.getPolinom().size() - 1; i >= 0; i--)
            poli.addMonom(p.getPolinom().get(i));
        return poli;
    }

    public static Polynomial inmultire(Polynomial p1, Polynomial p2) {
        Polynomial p = new Polynomial();
        Polynomial poli = new Polynomial();
        Monomial m;
        for (Monomial i : p1.getPolinom()) {
            for (Monomial j : p2.getPolinom()) {
                m = new Monomial(i.getCoeficient() * j.getCoeficient(), i.getPutere() + j.getPutere());
                p.addMonom(m);
            }
        }
        for (int i = 0; i < p.getPolinom().size(); i++) {
            for (int j = i + 1; j < p.getPolinom().size(); j++) {
                if (p.getPolinom().get(i).getPutere() == p.getPolinom().get(j).getPutere()) {
                    p.getPolinom().get(i).setCoeficient(p.getPolinom().get(i).getCoeficient() +
                            p.getPolinom().get(j).getCoeficient());
                    p.getPolinom().remove(j);
                }
            }
            poli.addMonom(p.getPolinom().get(i));
        }
        return poli;
    }

    public static Polynomial derivare(Polynomial p1) {
        for (Monomial i : p1.getPolinom()) {
            if (i.getPutere() == 0) {
                i.setCoeficient(0);
            } else if (i.getPutere() == 1) {
                i.setCoeficient(i.getCoeficient());
                i.setPutere(i.getPutere() - 1);
            } else {
                i.setCoeficient(i.getCoeficient() * i.getPutere());
                i.setPutere(i.getPutere() - 1);
            }
        }
        return p1;
    }

    public static Polynomial integrare(Polynomial p1) {
        for (Monomial i : p1.getPolinom()) {
            i.setPutere(i.getPutere() + 1);
            i.setCoeficient(i.getCoeficient() / i.getPutere());
        }
        return p1;
    }

    public static void impartire(Polynomial p1, Polynomial p2, Polynomial cat, Polynomial rest) {
        Polynomial p, poli, aux = new Polynomial();
        if (p1.getPolinom().get(0).getPutere() < p2.getPolinom().get(0).getPutere()) {
            aux = p1;
            p1 = p2;
            p2 = aux;
        }
        do {
            ArrayList<Double> c = new ArrayList<Double>();
            ArrayList<Integer> pr = new ArrayList<Integer>();
            c.add(p1.getPolinom().get(0).getCoeficient() / p2.getPolinom().get(0).getCoeficient());
            pr.add(p1.getPolinom().get(0).getPutere() - p2.getPolinom().get(0).getPutere());
            Polynomial.adaugareTermeni(c, pr);
            p = Polynomial.crearePolinom(c, pr);
            cat.addMonom(p.getPolinom().get(0));
            poli = Operatie.inmultire(p2, p);
            p1 = Operatie.scadere(p1, poli);
            p1.removeMonom(0);
        } while (p.getPolinom().size() > 1);
        if (p1.getPolinom().size() != 0) {
            for (Monomial i : p1.getPolinom())
                rest.addMonom(i);
        } else rest.addMonom(new Monomial(0, 0));
    }
}
