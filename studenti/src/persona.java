import java.util.Scanner;
public class persona {
    String nome;
    String cognome;
    int età;
    int altezza;
    int giorno_compleanno;
    int mese_compleanno;

    Scanner scanner = new Scanner(System.in);
    void inserimento(){
        System.out.println("Inserisci Nome:");
        nome = scanner.nextLine();
        System.out.println("Inserisci Cognome:");
        System.out.println("Inserisci Età:");
        System.out.println("Inserisci Altezza:");
        System.out.println("Inserisci Giorno del compleanno:");
        System.out.println("Inserisci Mese (numero):");


    }
    void stampa(){
        System.out.println("Nome: "+ nome);
        System.out.println("Cognome: "+ cognome);
        System.out.println("Età: "+ età);
        System.out.println("Altezza: "+ altezza);
        System.out.println("Giorno Compleanno: "+ giorno_compleanno);
        switch(mese_compleanno){
            case 1:
                System.out.println("Mese: Gennaio");
            case 2:
                System.out.println("Mese: Febbraio");
            case 3:
                System.out.println("Mese: Marzo");
            case 4:
                System.out.println("Mese: Aprile");
            case 5:
                System.out.println("Mese: Maggio");
            case 6:
                System.out.println("Mese: Giugno");
            case 7:
                System.out.println("Mese: Luglio");
            case 8:
                System.out.println("Mese: Agosto");
            case 9:
                System.out.println("Mese: Settembre");
            case 10:
                System.out.println("Mese: Ottobre");
            case 11:
                System.out.println("Mese: Novembre");
            case 12:
                System.out.println("Mese: Dicembre");
        }
    }
}
