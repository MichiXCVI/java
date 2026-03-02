
import java.util.ArrayList;
import java.util.List;

public class Teachers extends Persone {
    private List<String> materie;
    public Teachers(String nome, String cognome, String dataDiNascita) {
        super(nome, cognome, dataDiNascita);
        this.materie = new ArrayList<>();
    }
    public void addMateria(String materia) {
        materie.add(materia);
    }
}
