public class Ordine {
    private double codice;
    private String cliente;
    private double importo;
    private boolean isPremium;
    private boolean assicurazione;
    private boolean programma;
    private int giorno_cons;
    private int mese_cons;
    private int anno_cons;
    private int costo_spedizione = 0;
    static int counter;
    private boolean standard = false;

    Ordine(double codice, String cliente, double importo) {
        if (importo < 0 || codice < 0 || cliente.isEmpty()) {
            throw new IllegalArgumentException();
        } else {
            this.codice = codice;
            this.cliente = cliente;
            this.importo = importo;
            this.standard = true;
            if (importo < 200) {
                this.importo += 4.99;
                this.costo_spedizione += 4.99; //spedizione base
            }
        }
        counter++;
    }
    Ordine(double codice, String cliente, double importo, boolean isPremium, boolean programma, int giorno, int mese, int anno, boolean assicurazione) {
        if (importo < 0 || codice < 0 || cliente.isEmpty()) {
            throw new IllegalArgumentException();
        } else {
            this.codice = codice;
            this.cliente = cliente;
            this.importo = importo;
            this.standard = true;
            if (importo < 200) {
                this.importo += 4.99;
                this.costo_spedizione += 4.99; //spedizione base
            }
        }
        if(isPremium){
            this.programma = false;
            this.costo_spedizione = (int) 23.99;
            this.importo += 23.99;
            this.giorno_cons = giorno;
            this.mese_cons = mese;
            this.anno_cons = anno;
            this.isPremium =  true;
            this.standard = false;
        }
        if(programma){
            this.costo_spedizione = (int) 7.99;
            this.importo += 7.99;
            this.giorno_cons = giorno;
            this.mese_cons = mese;
            this.anno_cons = anno;
            this.standard = false;
        }
        this.assicurazione = assicurazione;
        if (this.assicurazione) {
            this.importo += 79.99; //sovraccarico per l'assicurazione;
        }
        counter++;
    }
    @Override
    public java.lang.String toString() {
        if (this.programma){
            return "code: " + this.codice + "\n" + "cliente: " + this.cliente + "\n" + "importo: " + this.importo + "$\n" + "$ spedizione: " + this.costo_spedizione + "$\n" + "Data arrivo: " + this.giorno_cons + "/" + this.mese_cons + "/" + this.anno_cons + "\n" + "spediizione standard 12gg lavorativi" + "\nassicurazione (79.99$): " + this.assicurazione;
        }else if(this.standard){
            return "code: " + this.codice + "\n" + "cliente: " + this.cliente + "\n" + "importo: " + this.importo + "$\n" + "$ spedizione: " + this.costo_spedizione + "$\n" + "spedizione standard 12gg lavorativi" + "\nassicurazione (79.99$): " + this.assicurazione;
        }else if(isPremium){
            return "code: " + this.codice + "\n" + "cliente: " + this.cliente + "\n" + "importo: " + this.importo + "$\n" + "$ spedizione: " + this.costo_spedizione + "$\n" + "Data arrivo: " + this.giorno_cons + "/" + this.mese_cons + "/" + this.anno_cons + "\n" + "spediizione PREMIUM 3gg lavorativi" + "\nassicurazione (79.99$): " + this.assicurazione;
        }
        return null;
    }
}
