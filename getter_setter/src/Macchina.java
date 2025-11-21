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
        if(prezzo > 0){
            return "$" + prezzo;
        }else{
            return "la macchina è gratis";
        }
    }
    void setColore(String colore){
        this.colore = colore;
    }
    void setPrezzo(int prezzo) {
        if (prezzo >= 0) {
            this.prezzo = prezzo;
        } else {
            System.out.println("Inserisci un prezzo valido");
        }
    }
}
