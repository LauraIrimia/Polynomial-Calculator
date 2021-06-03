package model;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {
    private ArrayList<Monomial> polinom = new ArrayList<Monomial>();

    public void addMonom(Monomial monom) {
        this.polinom.add(monom);
    }

    public void removeMonom(int poz) {
        this.polinom.remove(poz);
    }

    public void setPolinom(ArrayList<Monomial> polinom) {
        this.polinom = polinom;
    }

    public ArrayList<Monomial> getPolinom() {
        return polinom;
    }

    public static void verificareInput(String input) throws Exception {
        String c = "0123456789+-x^";
        int ok = 0;
        for (int i = 0; i < input.length(); i++) {
            ok = 0;
            for (int j = 0; j < c.length(); j++) {
                if (input.charAt(i) == c.charAt(j))
                    ok = 1;
            }
            if (ok == 0)
                throw new Exception(input);
        }
    }

    public static Polynomial transformarePolinom(String input) {
        ArrayList<Double> c = new ArrayList<Double>();
        ArrayList<Integer> pr = new ArrayList<Integer>();
        input = Polynomial.transformare(input);
        c = Polynomial.identificareCoeficient(input);
        pr = Polynomial.identificarePutere(input);
        Polynomial.adaugareTermeni(c, pr);
        Polynomial polinom = Polynomial.crearePolinom(c, pr);
        return polinom;
    }

    public static String transformare(String input) {
        StringBuilder sb = new StringBuilder(input);
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'x') {
                if (i == 0) {
                    sb.insert(i, '1');
                    input = sb.toString();
                } else if (i > 0 && (input.charAt(i - 1) == '+' || input.charAt(i - 1) == '-')) {
                    sb.insert(i, '1');
                    input = sb.toString();
                } else if (i == input.length() - 1 || i < input.length() - 1 && (input.charAt(i + 1) == '+' || input.charAt(i + 1) == '-')) {
                    sb.insert(i + 1, "^1");
                    input = sb.toString();
                }
            }
        }
        int i = input.length() - 1;
        if (Character.isDigit(input.charAt(i))) {
            while (i > 0 && Character.isDigit(input.charAt(i))) {
                i--;
            }
            if (i == 0 || input.charAt(i) != '^')
                input = input + "x^0";
        }
        return input;
    }

    public static ArrayList<Double> identificareCoeficient(String input) {
        ArrayList<Double> c = new ArrayList<Double>();
        Pattern p = Pattern.compile("(-?\\d+)[x]?\\^?(-?\\d+)?");
        Matcher m = p.matcher(input);
        while (m.find()) {
            c.add(Double.parseDouble(m.group(1).toString()));
        }
        return c;
    }

    public static ArrayList<Integer> identificarePutere(String input) {
        ArrayList<Integer> pr = new ArrayList<Integer>();
        Pattern p = Pattern.compile("(-?\\d+)[x]?\\^?(-?\\d+)?");
        Matcher m = p.matcher(input);
        while (m.find()) {
            pr.add(Integer.parseInt(m.group(2).toString()));
        }
        return pr;
    }

    public static void adaugareTermeni(ArrayList<Double> c, ArrayList<Integer> pr) {
        for (int i1 = 1; i1 < c.size(); i1++) {
            if (pr.get(i1) + 1 != pr.get(i1 - 1)) {
                c.add(i1, (double) 0);
                pr.add(i1, pr.get(i1 - 1) - 1);
            }
        }
        int d = pr.get(pr.size() - 1);
        if (pr.size() == 1) {
            if (d > 1) {
                for (int i2 = 1; i2 <= d; i2++) {
                    pr.add(i2, d - i2);
                    c.add(i2, (double) 0);
                }
            }
        }
        if (pr.get(pr.size() - 1) != 0) {
            c.add(pr.size(), (double) 0);
            pr.add(pr.size(), 0);
        }
    }

    public static Polynomial crearePolinom(ArrayList<Double> c, ArrayList<Integer> pr) {
        Monomial monom;
        Polynomial polinom = new Polynomial();
        for (int x = 0; x < c.size(); x++) {
            monom = new Monomial(c.get(x), pr.get(x));
            polinom.addMonom(monom);
        }
        return polinom;
    }

    public String toString() {
        String p = "";
        int z = 0;
        for (Monomial i : this.polinom)
            if (i.getCoeficient() != 0)
                z = 1;
        if (z == 0)
            p = p + "0";
        else {
            for (Monomial m : this.polinom)
                if (m.toString() != null)
                    p = p + m.toString();
        }
        if (p.charAt(0) == '+')
            p = p.substring(1, p.length());
        return p;
    }
}
