//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try{
            rettangolo rettangolo = new rettangolo(3,4);
            quadrato quadrato = new quadrato(3);
            System.out.println(rettangolo);
            System.out.println(quadrato);
        } catch (IllegalArgumentException e) {
            System.out.println("Errore nella creazione del rettangolo");
        }
    }
}