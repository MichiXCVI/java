import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args){
        ArrayList<Integer> numbers = new ArrayList<>();
        HashMap<String, ArrayList<Integer>> registro = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci nome e voto:");
        registro.put(scanner.nextLine(), new ArrayList<>(scanner.nextInt()));
        scanner.next();
        System.out.println("Inserisci nome e voto:");
        registro.put(scanner.nextLine(), new ArrayList<>(scanner.nextInt()));
        System.out.println("Inserisci nome e voto:");
        registro.put(scanner.nextLine(), new ArrayList<>(scanner.nextInt()));
        System.out.println("Aggiungi un voto ad uno studente, (scrivi nome e poi il voto");
        registro.get(scanner.nextLine()).add(scanner.nextInt());

        for(String chiave : registro.keySet()){
            System.out.println(chiave + " - Voto: " + registro.get(chiave));
        }
    }
}