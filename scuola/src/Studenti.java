import java.util.ArrayList;
import java.util.List;

public class Studenti extends Persone {
    private List<Voto> voti;
    public Studenti(String nome, String cognome, String data) {
        super(nome, cognome, data);
        this.voti = new ArrayList<>();
    }
    public List<Voto> getVoti() {
        return voti;
    }
    public void addVoto(Voto voto) {
    voti.add(voto);
    }
}
