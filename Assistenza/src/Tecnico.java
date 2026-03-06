import java.util.HashMap;

public class Tecnico {
    static int counter;
    String nome;
    String cognome;
    HashMap<Integer, Double> ticketsToDo = new HashMap<>();

    public void newTicketAssigned(double id){
        ticketsToDo.put(counter, id);
        counter++;
    }

    public Tecnico(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }
    public String getCognome() {
        return cognome;
    }
    public String getNome() {
        return nome;
    }
}
