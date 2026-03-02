import java.util.ArrayList;
import java.util.HashMap;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] arg){
        Rubrica rubrica = new Rubrica();
        rubrica.addContact("ricky", "pat", "3483489");
        rubrica.addContact("Lokukata", "Godage Dilly", "45656");
        rubrica.addContact("Giulio", "Bicicletta", "45533345");
        rubrica.addContact("checcoglione", "Cogniglietto", "12345 67 69");
        System.out.println(rubrica.cerca("Giulio", "Bicicletta"));
        rubrica.toString();
        rubrica.rimuoviContatto("ricky", "pat");
        rubrica.toString();
    }
}