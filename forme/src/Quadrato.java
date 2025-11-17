public class Quadrato {
    double lato;

    double perimetro;
    double area;

    Quadrato(double lato){
        this.lato = lato;
        this.perimetro = lato * 4;
        this.area = lato * lato;
    }
}
