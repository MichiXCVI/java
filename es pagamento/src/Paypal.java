import java.sql.Struct;

public class Paypal {
    String email;
    String password;
    Paypal(String email, String Password){
        this.email = email;
        this.password = Password;
        System.out.println("you logged in");
    }
}
