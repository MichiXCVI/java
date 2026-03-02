import java.util.Scanner;

import static java.lang.System.exit;

public class Carrello {
    int prezzo1 = 50;
    int prezzo2 = 120;
    int prezzo3 = 5;
    int prezzo4 = 3850;
    int totale;

    Carrello(){
        totale = prezzo1 + prezzo2 + prezzo3 + prezzo4;
    }
    void effettuaPagamento(boolean metodo){
        boolean z;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Continuare col pagamento?? (true/false)");
        z = scanner.nextBoolean();
        if (!z){
            exit(0);
        }
        if(metodo){
            System.out.println("Hai pagato " + this.totale + "$ con PayPal");
        }else{
            System.out.println("Hai pagato " + this.totale + "$ con la carta");
        }
    }
}
