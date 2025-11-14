import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        persona tizio = new persona();
        persona tizio1 = new persona();
        persona tizio2 = new persona();
        persona tizio3 = new persona();
        persona tizio4 = new persona();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci Nome:");
        tizio.nome = scanner.nextLine();
        System.out.println("Inserisci Cognome:");
        tizio.cognome = scanner.nextLine();
        System.out.println("Inserisci Età:");
        tizio.età = scanner.nextInt();
        System.out.println("Inserisci Altezza:");
        tizio.altezza = scanner.nextDouble();
        System.out.println("Inserisci Giorno del compleanno:");
        tizio.giorno_compleanno = scanner.nextInt();
        System.out.println("Inserisci Mese (numero):");
        tizio.mese_compleanno = scanner.nextInt();
        tizio.stampa();

        System.out.println("Inserisci Nome:");
        tizio1.nome = scanner.nextLine();
        System.out.println("Inserisci Cognome:");
        tizio1.cognome = scanner.nextLine();
        System.out.println("Inserisci Età:");
        tizio1.età = scanner.nextInt();
        System.out.println("Inserisci Altezza:");
        tizio1.altezza = scanner.nextDouble();
        System.out.println("Inserisci Giorno del compleanno:");
        tizio1.giorno_compleanno = scanner.nextInt();
        System.out.println("Inserisci Mese (numero):");
        tizio1.mese_compleanno = scanner.nextInt();
        tizio1.stampa();

        System.out.println("Inserisci Nome:");
        tizio2.nome = scanner.nextLine();
        System.out.println("Inserisci Cognome:");
        tizio2.cognome = scanner.nextLine();
        System.out.println("Inserisci Età:");
        tizio2.età = scanner.nextInt();
        System.out.println("Inserisci Altezza:");
        tizio2.altezza = scanner.nextDouble();
        System.out.println("Inserisci Giorno del compleanno:");
        tizio2.giorno_compleanno = scanner.nextInt();
        System.out.println("Inserisci Mese (numero):");
        tizio2.mese_compleanno = scanner.nextInt();
        tizio2.stampa();

        System.out.println("Inserisci Nome:");
        tizio3.nome = scanner.nextLine();
        System.out.println("Inserisci Cognome:");
        tizio3.cognome = scanner.nextLine();
        System.out.println("Inserisci Età:");
        tizio3.età = scanner.nextInt();
        System.out.println("Inserisci Altezza:");
        tizio3.altezza = scanner.nextDouble();
        System.out.println("Inserisci Giorno del compleanno:");
        tizio3.giorno_compleanno = scanner.nextInt();
        System.out.println("Inserisci Mese (numero):");
        tizio3.mese_compleanno = scanner.nextInt();
        tizio3.stampa();

        System.out.println("Inserisci Nome:");
        tizio4.nome = scanner.nextLine();
        System.out.println("Inserisci Cognome:");
        tizio4.cognome = scanner.nextLine();
        System.out.println("Inserisci Età:");
        tizio4.età = scanner.nextInt();
        System.out.println("Inserisci Altezza:");
        tizio4.altezza = scanner.nextDouble();
        System.out.println("Inserisci Giorno del compleanno:");
        tizio4.giorno_compleanno = scanner.nextInt();
        System.out.println("Inserisci Mese (numero):");
        tizio4.mese_compleanno = scanner.nextInt();
        tizio4.stampa();
        }
    }