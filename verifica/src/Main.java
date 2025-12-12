// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        try{
            Ordine ordine = new Ordine(30, "Michele", 350, true, false, 30, 11, 2024, true);
            System.out.println(ordine);
            Ordine ordine1 = new Ordine(31, "Riccardo", 100);
            System.out.println(ordine1);
            System.out.println("numero ordini: " + Ordine.counter);
        }catch(IllegalArgumentException e){
            System.out.println("qualcosa è andato storto riprova");
            System.exit(0);
        }
    }
}