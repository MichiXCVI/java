import com.sun.security.jgss.GSSUtil;

import java.util.ArrayList;

public class Assistenza {
    ArrayList<Ticket> tickets = new ArrayList<>();
    ArrayList<Tecnico> tecnici = new ArrayList<>();

    public void addTecnici(){
        Tecnico tecnico = new Tecnico("mario" , "rossi");
        tecnici.add(tecnico);
        Tecnico tecnico1 = new Tecnico("riccardo" , "paterno");
        tecnici.add(tecnico1);
        Tecnico tecnico2 = new Tecnico("enrico" , "montanari");
        tecnici.add(tecnico2);
    }
    public void ApriTicket(String description, int priority){
        Ticket ticket = new Ticket(description, priority);
        tickets.add(ticket);
        assignTechnician(ticket.getId());
        System.out.println("Il ticket è stato aperto con id " + ticket.getId());
    }
    public void closeTickets(double id){
        int found = 0;
        for(Ticket tickets : tickets){
            if(tickets.getId() == id && tickets.getStatus() != 2){
                tickets.status = 2;
                System.out.println("Il ticket è stato chiuso");
                found = 1;
            }else if(tickets.getId() == id && tickets.getStatus() == 2){
                System.out.println("Ticket Gia chiuso");
            }
        }if(found == 0){
            System.out.println("Ticket inesistente");
        }
    }

    public void assignTechnician(double id){
        for(Ticket ticket : tickets){
            try {
                if (ticket.getId() == id && ticket.getStatus() == 0) {
                    int i = 0;
                    int randomNum = (int) (Math.random() * tecnici.size());
                    Tecnico t = tecnici.get(randomNum);
                    t.newTicketAssigned(id);
                    tecnici.set(randomNum, t);
                    ticket.status = 1;
                } else if (ticket.getId() == id && ticket.getStatus() == 1) {
                    throw new IllegalArgumentException("Il ticket è gia in fase di lavorazione");
                } else if (ticket.getId() == id && ticket.getStatus() == 2) {
                    throw new IllegalArgumentException("Il ticket è gia stato chiuso");
                }
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Ticket inesistente");
            }
        }
    }

    Assistenza(){
        addTecnici();
    }

    @Override
    public String toString(){
        System.out.println("----- ASSISTENZA -----");
        for(Ticket ticket : tickets){
            if(ticket.status == 1) {
                int k = 0;
                for (Tecnico tecnico : tecnici) {
                    k++;
                    double temp = ticket.getId();
                    Boolean j = tecnico.ticketsToDo.containsValue(temp);
                    if (j) {
                        break;
                    }
                }
                Tecnico t = tecnici.get(k);
                System.out.println("ID: " + ticket.getId() + "\n Desc: " + ticket.getDescription() + "\n Tecnico: "+ t.getNome() + " " + t.getCognome());
            }else if(ticket.status == 0) {
                System.out.println("ID: " + ticket.getId() + "\n Desc: " + ticket.getDescription() + "\n Ticket non ancora assegnato!");
            }else if(ticket.status == 2){
                System.out.println("ID: " + ticket.getId() + "\n Desc: " + ticket.getDescription() + "\n Ticket chiuso");
            }
        }
        System.out.println("----- Tecnici -----");
        for (Tecnico tecnico : tecnici) {
            System.out.println("Tecnico: " + tecnico.getCognome() + " " + tecnico.nome + " Tickets: " + tecnico.ticketsToDo.size());
        }
        return null;
    }
}
