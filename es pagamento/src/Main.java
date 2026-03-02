import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Carrello carrello = new Carrello();
        System.out.println("Scegli metodo: true paypal false carta");
        boolean c;

        c = scanner.nextBoolean();
        if (c){
            System.out.println("Inserisci email e password");
            Paypal paypal = new Paypal(scanner.nextLine(), scanner.nextLine());
        }else{
            System.out.println("inserisci numero carta anno mese scandenza e cvv");
            Cartadicredito cdc = new Cartadicredito(scanner.nextDouble(),scanner.nextDouble(), scanner.nextDouble(), scanner.nextInt());
        }
        carrello.effettuaPagamento(c);
    }
}