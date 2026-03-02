//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Frazione a = new Frazione(2, 3);
        Frazione b = new Frazione(4, 5);

        System.out.println("a = " + a); //tostring a
        System.out.println("b = " + b); //tostring b

        System.out.println("Somma: " + a.somma(b));
        System.out.println("Differenza: " + a.differenza(b));
        System.out.println("Prodotto: " + a.prodotto(b));
        System.out.println("Quoziente: " + a.quoziente(b));
        System.out.println("Inverso di a: " + a.inverso());
        System.out.println("a^3 = " + a.potenza(3));
        System.out.println("Somma: " + b.somma(b));
        System.out.println("Differenza: " + b.differenza(b));
        System.out.println("Prodotto: " + b.prodotto(b));
        System.out.println("Quoziente: " + b.quoziente(b));
        System.out.println("Inverso di a: " + b.inverso());
        System.out.println("a^3 = " + b.potenza(3));
    }
}