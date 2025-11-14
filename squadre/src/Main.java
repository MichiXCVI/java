import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci i nomi delle due squadre");
        String squadra;
        squadra = scanner.nextLine();
        String squadra2;
        squadra2 = scanner.nextLine();
        System.out.println("Inserisci i gol segnati");
        int goal;
        goal = scanner.nextInt();
        int goal2;
        goal2 = scanner.nextInt();
        if(goal > goal2){
            System.out.println("Vince la squadra 1");
        }else if (goal2 == goal){
            System.out.println("pareggio");
        }else{
            System.out.println("Vince la quadra 2");
        }
        goal = goal + goal2;
        System.out.println("goal totali: "+ goal);
    }
}