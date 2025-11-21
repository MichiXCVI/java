public class Macchina {
    private String modello;
    private String colore;
    private int prezzo;

    Macchina(String modello, String colore, int prezzo){
        this.modello = modello;
        this.colore = colore;
        this.prezzo = prezzo;
    }

    String getModello(){
        return modello;
    }
    String getColore(){
        return colore;
    }
    String getPrezzo(){
        return "$" + prezzo;
    }
}
