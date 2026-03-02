import java.util.ArrayList;

public class Rubrica {
    ArrayList<Contatto> rubrica = new ArrayList<>();

    void addContact(String nome, String cognome, String telefono) {
        Contatto contatto = new Contatto(nome, cognome, telefono);
        rubrica.add(contatto);
    }

    void rimuoviContatto(String nome, String cognome) {
        for (int i = 0; i < rubrica.size(); i++) {
            Contatto c = rubrica.get(i);
            if (c.getNome().equals(nome) && c.getCognome().equals(cognome)) {
                rubrica.remove(i);
            }
        }
    }

    String cerca(String nome, String cognome) {
        for (Contatto contatto : rubrica) {
            if (contatto.getNome().equals(nome) && contatto.getCognome().equals(cognome)) {
                return "il numero di " + nome + " " + cognome + " è: " + contatto.getNumero();
            }
        }
        return "Contatto non trovato";
    }

    @Override
    public String toString() {
        for(Contatto contatto : rubrica){
            System.out.println(contatto.getNome() + " " + contatto.getCognome() + ": " + contatto.getNumero());
        }
        return "";
    }
}
