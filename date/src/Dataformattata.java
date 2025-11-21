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
        switch (this.mese) {
            case 1:
                return "gennaio";
            case 2:
                return "febbraio";
            case 3:
                return "marzo";
            case 4:
                return "aprile";
            case 5:
                return "maggio";
            case 6:
                return "giugno";
            case 7:
                return "luglio";
            case 8:
                return "agosto";
            case 9:
                return "settembre";
            case 10:
                return "ottobre";
            case 11:
                return "novembre";
            case 12:
                return "dicembre";
            default:
                return "mese non valido";
        }
    }
}
