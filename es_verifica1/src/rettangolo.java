public class rettangolo {
    private double base;
    private double height;

    rettangolo(double base, double height) {
        if (base <= 0 || height <= 0) {
            throw new IllegalArgumentException();
        }else{
            this.height = height;
            this.base = base;
        }
    }

    double area() {
        return base*height;
    }

    double perimetro() {
        return (2*(base+height));
    }

    @Override
    public String toString() {
        return "Rettangolo base=" + this.base + ", altezza=" + this.height + ", area=" + area() + ", perimetro=" + perimetro();
    }
}
