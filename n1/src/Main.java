import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci il tuo nome");
        String nome = scanner.nextLine();

        System.out.println("Inserisci la tua età");
        int età = scanner.nextInt();

        System.out.println("Inserisci la tua media scolastica");
        double media = scanner.nextDouble();

        System.out.println("sei uno studente? (T/F)");
        boolean studente = scanner.nextBoolean();

        System.out.println("Il tuo nome è " + nome);
        System.out.println("hai  " + età + " anni");
        System.out.println("la tua media è: " + media);

        if(studente){
            System.out.println("Sei uno studente");
        }else{
            System.out.println("Non sei uno studente");
        }
    }
}
