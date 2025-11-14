import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String email;
        String username;
        String dominio;

        System.out.println("inserisci la tua mail");
        email = scanner.nextLine();

        if(email.contains("@") && !email.substring(email.indexOf("@") + 1).isEmpty()){
            username = email.substring(0, email.indexOf("@"));
            dominio = email.substring(email.indexOf("@") + 1);
            System.out.println(username);
            System.out.println(dominio);
        }else{
            System.out.println("mail non valida");
        }
    }
}