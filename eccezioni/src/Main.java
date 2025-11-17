import java.rmi.server.ExportException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Inserisci il dividendo: ");
            int a = scanner.nextInt();
            System.out.println("Inserisci il divisore: ");
            int b = scanner.nextInt();
            float r = a / b;
            System.out.println("risultato = " + r);
        }catch (ArithmeticException e){
            System.out.println("sei gay");
        }catch (InputMismatchException e){
            System.out.println("sei gay");
        }catch (Exception e){
            System.out.println("sei gay");
        }finally {
            System.out.println("sei gay in modo definitivo");
            scanner.close();
        }
    }
}