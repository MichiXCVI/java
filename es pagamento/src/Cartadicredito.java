public class Cartadicredito {
    double numero;
    double anno_scadenza;
    double mese_scadenza;
    int cvv;
    Cartadicredito(double numero, double anno_scadenza, double mese_scadenza, int cvv){
        this.numero = numero;
        this.anno_scadenza = anno_scadenza;
        this.mese_scadenza = mese_scadenza;
        this.cvv = cvv;
        System.out.println("card is valid!");
    }
}
