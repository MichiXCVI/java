import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Torta torta = new Torta("si");
        Torta torta1 = new Torta("si", "no");
        Torta torta2 = new Torta("si", "no", "forse");
        Torta torta3 = new Torta("si", "no", "forse", 0);

        System.out.println("----- TORTA -----");
        System.out.println("Base:       " + torta.base);
        System.out.println("Farcitura:  " + torta.farcitura);
        System.out.println("Toppings:   " + torta.toppings);
        System.out.println("Peso:       " + torta.peso);
        System.out.println("Torte tot:  " + Torta.numero_torte);

        /*Scanner scanner = new Scanner(System.in);
        Torta torta = new Torta();
        System.out.println("Inserisci la base: ");
        torta.base = scanner.nextLine();
        System.out.println("Inserisci la farcitura");
        torta.farcitura = scanner.nextLine();
        System.out.println("Inserisci il topping");
        torta.toppings = scanner.nextLine();
        System.out.println("Inserisci il peso (kg):");
        torta.peso = scanner.nextInt();

        System.out.println("----- TORTA -----");
        System.out.println("Base:       " + torta.base);
        System.out.println("Farcitura:  " + torta.farcitura);
        System.out.println("Toppings:   " + torta.toppings);
        System.out.println("Peso:       " + torta.peso);
        */
    }
}