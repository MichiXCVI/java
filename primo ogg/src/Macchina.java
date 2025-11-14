public class Macchina {
    String produttore = "McLaren";
    String modello = "P1";
    int anno = 2024;
    double prezzo = 1200000;
    boolean acceso = false;

    void accendi(){
        acceso = true;
        System.out.println("hai acceso la macchina");
    }
    void spegni(){
        acceso = false;
        System.out.println("hai spento la macchina");
    }
    void guida(){
        System.out.println("stai guidando la " + modello);
    }
    void fermati(){
        System.out.println("hai fermato la " + modello);
    }
}
