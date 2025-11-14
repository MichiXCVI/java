import java.util.Scanner;
public class persona {
    String nome;
    String cognome;
    int età;
    double altezza;
    int giorno_compleanno;
    int mese_compleanno;

    void stampa(){
        System.out.println("Nome: "+ nome + " " + cognome);
        System.out.println("Età: "+ età);
        System.out.println("Altezza: "+ altezza);
        System.out.println("Giorno Compleanno: "+ giorno_compleanno);
        switch(mese_compleanno){
            case 1:
                System.out.println("Mese: Gennaio");
                break;
            case 2:
                System.out.println("Mese: Febbraio");
                break;
            case 3:
                System.out.println("Mese: Marzo");
                break;
            case 4:
                System.out.println("Mese: Aprile");
                break;
            case 5:
                System.out.println("Mese: Maggio");
                break;
            case 6:
                System.out.println("Mese: Giugno");
                break;
            case 7:
                System.out.println("Mese: Luglio");
                break;
            case 8:
                System.out.println("Mese: Agosto");
                break;
            case 9:
                System.out.println("Mese: Settembre");
                break;
            case 10:
                System.out.println("Mese: Ottobre");
                break;
            case 11:
                System.out.println("Mese: Novembre");
                break;
            case 12:
                System.out.println("Mese: Dicembre");
                break;
        }
    }
}
