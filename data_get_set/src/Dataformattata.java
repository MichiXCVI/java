import static java.lang.System.exit;

public class Dataformattata {
    private int giorno;
    private int mese;
    private int anno;
    private boolean bisestile;

    void setMese(int mese){
        if(mese > 12){
            System.out.println("Mese invalido");
            exit();
        }else{
            this.mese = mese;
        }
    }

    private void exit() {
        exit();
    }
    void isBisestile() {
        if((anno % 400 == 0) || (anno % 4 == 0 && anno % 100 != 0)){
            this.bisestile = true;
        }
    }
    void setAnno(int anno){
        if(anno < 100 && anno > 25) {
            this.anno = anno += 1900;
        }else if(anno > 0){
            this.anno = anno += 2000;
        }else{
            this.anno = anno;
        }
        if(this.anno > 2025){
            System.out.println("Anno invalido");
            exit();
        }
        isBisestile();
    }

    void setGiorno(int giorno){
        if(this.mese == 1 || this.mese == 3 || this.mese == 5 || this.mese == 7 || this.mese == 8 || this.mese == 10 || this.mese == 12){
            if(giorno > 31){
                System.out.println("Giorno invalido");
                exit();
            }else{
                this.giorno = giorno;
            }
        }
        if(this.mese == 4 || this.mese == 6 || this.mese == 9 || this.mese == 11){
            if(giorno > 30){
                System.out.println("Giorno invalido");
                exit();
            }else{
                this.giorno = giorno;
            }
        }
        if(this.mese == 2){
            if(!this.bisestile){
                if(giorno > 28){
                    System.out.println("Giorno invalido");
                    exit();
                }else{
                    this.giorno = giorno;
                }
            }else{
                if(giorno > 29){
                    System.out.println("Giorno invalido");
                    exit();
                }else{
                    this.giorno = giorno;
                }
            }
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
