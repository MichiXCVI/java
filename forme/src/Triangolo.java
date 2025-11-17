public class Triangolo {
    double lato;
    double lato1;
    double lato2;
    double area;
    double perimetro;

    Triangolo(double lato, double lato1, double lato2){
        this.lato = lato;
        this.lato1 = lato1;
        this.lato2 = lato2;
        this.perimetro = lato + lato1 + lato2;
    }
}
