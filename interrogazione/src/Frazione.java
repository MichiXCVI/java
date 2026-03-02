import java.util.InputMismatchException;

public class Frazione {
    private int numeratore;
    private int denominatore;

    Frazione(int numeratore, int denominatore) {
        if (denominatore == 0) {
            throw new InputMismatchException();
        }
        this.numeratore = numeratore;
        this.denominatore = denominatore;
        semplifica();
    }

    public int getNumeratore() {
        return numeratore;
    }

    public int getDenominatore() {
        return denominatore;
    }

    public void setNumeratore(int numeratore) {
        this.numeratore = numeratore;
        semplifica();
    }

    public void setDenominatore(int denominatore) {
        if (denominatore == 0) {
            throw new IllegalArgumentException("Il denominatore non può essere zero.");
        }
        this.denominatore = denominatore;
        semplifica();
    }

    private int mcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a); //valore assoluto
    }

    private void semplifica() {
        int mcd = mcd(numeratore, denominatore);
        numeratore = numeratore / mcd;
        if (denominatore == 0) {
            denominatore = 1;
        }else {
            denominatore = numeratore / mcd;
        }
    }

    public Frazione inverso() {
        return new Frazione(denominatore, numeratore);
    }

    public Frazione reciproco() {
        return inverso();
    }

    public Frazione somma(Frazione f) {
        int num = this.numeratore * f.denominatore + f.numeratore * this.denominatore;
        int den = this.denominatore * f.denominatore;
        return new Frazione(num, den);
    }

    public Frazione differenza(Frazione f) {
        int num = this.numeratore * f.denominatore - f.numeratore * this.denominatore;
        int den = this.denominatore * f.denominatore;
        return new Frazione(num, den);
    }

    public Frazione prodotto(Frazione f) {
        return new Frazione(this.numeratore * f.numeratore, this.denominatore * f.denominatore);
    }

    public Frazione quoziente(Frazione f) {
        return new Frazione(this.numeratore * f.denominatore, this.denominatore * f.numeratore);
    }

    public Frazione potenza(int esp) {
        return new Frazione((int)Math.pow(numeratore, esp), (int)Math.pow(denominatore, esp));
    }

    @Override
    public String toString() {
        return numeratore + "/" + denominatore;
    }
}
