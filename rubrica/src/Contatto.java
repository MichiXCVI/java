public class Contatto {
    String nome;
    String cognome;
    String numero;

    Contatto(String nome, String cognome, String numero){
        this.nome = nome;
        this.cognome = cognome;
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }
    public String getNumero(){
        return numero;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    @Override
    public String toString() {
        return nome + " " + cognome + ": " + numero;
    }
}