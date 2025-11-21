import static java.lang.Math.sqrt;

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
        if (lato + lato1 > lato2 && lato + lato2 > lato1 && lato1 + lato2 > lato) {
            double semiperimetro = perimetro / 2.0;
            this.area = sqrt(semiperimetro * (semiperimetro - lato) * (semiperimetro - lato1) * (semiperimetro - lato2));
        } else {
            System.out.println("I valori inseriti NON formano un triangolo valido.");
        }
    }
}
