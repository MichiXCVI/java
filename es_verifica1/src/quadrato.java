public class quadrato extends rettangolo {
    private double lato;

    quadrato(double lato) {
        super(lato, lato);
        this.lato = lato;
    }

    double area() {
        return lato*lato;
    }

    double perimetro() {
        return 4*lato;
    }

    @Override
    public String toString() {
        return "quadrato lato=" + this.lato + ", area=" + area() + ", perimetro=" + perimetro();
    }
}
