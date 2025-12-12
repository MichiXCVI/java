public class personaggio {
    private String nome;
    private int vita;

    personaggio(String nome, int vita) {
        if (vita > 100 || vita < 0) {
            throw new IllegalArgumentException();
        }else{
            this.nome = nome;
            this.vita = vita;
        }

    }

    void cura(int punti) {
        vita += punti;
        if (vita > 100) {
            vita = 100;
        }
    }

    int getVita(){
        return this.vita;
    }

    int attacca(){
        setVita(10);
        return 10;
    }

    void setVita(int vita){
        this.vita -= vita;
    }

    @Override
    public String toString() {
        return "nome: " + this.nome + ", vita: " + this.vita;
    }
}
