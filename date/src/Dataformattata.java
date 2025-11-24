public class Dataformattata {
    int giorno;
    int mese;
    int anno;

    Dataformattata(int giorno, int mese, int anno){
        this.giorno = giorno;
        this.mese = mese;
        if(anno < 100) {
            this.anno = 2000 + anno;
        }else{
            this.anno = anno;
        }
    }

    void StringFormattata(){
        System.out.println(this.giorno + " / " + MeseDs() + " / " + this.anno);
    }

    String MeseDs(){
        return switch (this.mese) {
            case 1  -> "gennaio";
            case 2  -> "febbraio";
            case 3  -> "marzo";
            case 4  -> "aprile";
            case 5  -> "maggio";
            case 6  -> "giugno";
            case 7  -> "luglio";
            case 8  -> "agosto";
            case 9  -> "settembre";
            case 10 -> "ottobre";
            case 11 -> "novembre";
            case 12 -> "dicembre";
            default -> "mese non valido";
        };
    }
}
