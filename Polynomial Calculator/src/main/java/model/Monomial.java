package model;

public class Monomial {
    private int putere;
    private double coeficient;

    public Monomial(double coeficient, int putere) {
        this.setPutere(putere);
        this.setCoeficient(coeficient);
    }

    public int getPutere() {
        return putere;
    }

    public void setPutere(int putere) {
        this.putere = putere;
    }

    public double getCoeficient() {
        return coeficient;
    }

    public void setCoeficient(double coeficient) {
        this.coeficient = coeficient;
    }

    public String rescriereOutput(double c) {
        String o = "";
        if (c % 1 == 0) {
            int i = (int) c;
            o = o + i;
        } else {
            c = Math.round(c * 100.0) / 100.0;
            o = o + c;
        }
        return o;
    }

    public String toString() {
        if (this.putere == 1) {
            if (this.coeficient == Double.valueOf(0))
                return null;
            else if (this.coeficient == 1)
                return "+x";
            else if (this.coeficient == -1)
                return "-x";
            else if (this.coeficient > 1 || (this.coeficient < 1 && this.coeficient > 0))
                return "+" + this.rescriereOutput(this.coeficient) + "x";
            else return this.rescriereOutput(this.coeficient) + "x";
        } else if (this.putere == 0) {
            if (this.coeficient == Double.valueOf(0))
                return null;
            else if (this.coeficient >= 1 || (this.coeficient < 1 && this.coeficient > 0))
                return "+" + this.rescriereOutput(this.coeficient);
            else return this.rescriereOutput(this.coeficient) + "";
        } else {
            if (this.coeficient == Double.valueOf(0))
                return null;
            else if (this.coeficient == 1)
                return "+" + "x^" + this.putere;
            else if (this.coeficient == -1)
                return "-" + "x^" + this.putere;
            else if (this.coeficient > 1 || (this.coeficient < 1 && this.coeficient > 0))
                return "+" + this.rescriereOutput(this.coeficient) + "x^" + this.putere;
            else return this.rescriereOutput(this.coeficient) + "" + "x^" + this.putere;
        }
    }
}
