public class Voto {
    private String data;
    private String materia;
    private double valore;
    public Voto(String data, String materia, double valore) {
        this.data = data;
        this.materia = materia;
        this.valore = valore;
    }
    public String getData() {
        return data;
    }
    public String getMateria() {
        return materia;
    }
    public double getValore() {
        return valore;
    }
}