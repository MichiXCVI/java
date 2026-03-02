public abstract class Persone {
    private String nome;
    private String cognome;
    private String dataDiNascita;
    public Persone(String nome, String cognome, String nascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = nascita;
    }
    public String getNome() {
        return nome;
    }
    public String getCognome() {
        return cognome;
    }
    public String getNascita() {
        return dataDiNascita;
    }
}
