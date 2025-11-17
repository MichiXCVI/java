public class Torta {
    String base;
    String farcitura;
    String toppings;
    int peso;
    static int numero_torte;
    Torta(String base, String farcitura, String toppings, int peso){
        this.base = base;
        this.farcitura = farcitura;
        this.toppings = toppings;
        this.peso = peso;
        numero_torte++;
    }

    Torta(String base){
        this.base = base;
        this.farcitura = "nessuno";
        this.toppings = "nessuno";
        this.peso = 2;
        numero_torte++;
    }

    Torta(String base, String farcitura, String toppings){
        this.base = base;
        this.farcitura = farcitura;
        this.toppings = toppings;
        this.peso = 2;
        numero_torte++;
    }

    Torta(String base, String farcitura){
        this.base = base;
        this.farcitura = farcitura;
        this.toppings = "nessuno";
        this.peso = 2;
        numero_torte++;
    }

    Torta(){
        numero_torte++;
    }

}
