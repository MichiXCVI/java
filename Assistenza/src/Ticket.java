public class Ticket {
    static int assign_id;
    double id;
    String description;
    int priority;
    int status; //0 open; 1 working; 2 closed
    int index_tecnico;

    Ticket(String description, int priority){
        assign_id++;
        id = assign_id;
        this.description = description;
        this.priority = priority;
        status = 0;
    }

    double getId(){
        return this.id;
    }
    int getStatus(){
        return this.status;
    }
    String getDescription(){
        return this.description;
    }
}
