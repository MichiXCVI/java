import java.util.HashMap;
import java.util.Scanner;

class Ristorante {
    public static void main(String args[]) {

        Scanner q = new Scanner(System.in);
        Tavolo t1 = new Tavolo(1, 3);
        Menu menu = new Menu();

        char ch;
        int j;

        do {
            System.out.print("Bevanda, Piatto o eXit (p/b/x)?: ");
            ch = q.nextLine().charAt(0);

            if (ch == 'p') menu.mostraP();
            else if (ch == 'b') menu.mostraB();
            else break;

            System.out.print("ins.index: ");
            j = q.nextInt();
            q.nextLine(); // pulizia buffer

            E e = null;

            if (ch == 'p') e = menu.getP(j);
            else if (ch == 'b') e = menu.getB(j);

            if (e != null) t1.ins(e);

        } while (ch != 'x');

        System.out.println(t1);
    }
}
