//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            personaggio personaggio = new personaggio("diocane", 100);
            mago mago = new mago("dioboia", 100);
            System.out.println(personaggio);
            System.out.println(mago);
            System.out.println(personaggio.attacca());
            System.out.println(mago.attacca());
            System.out.println(personaggio);
            System.out.println(mago);
        }catch (IllegalArgumentException e) {
            System.out.println("sei gay");
        }
    }
}