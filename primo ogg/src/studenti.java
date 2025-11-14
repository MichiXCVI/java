public class studenti {
    String nome;
    int età;
    double media;
    boolean iscritto;

    studenti(String nome, int età, double media){
        this.nome = nome;
        this.età = età;
        this.media = media;
    }
    void studia(){
        System.out.println(this.nome + " sta studiando");
    }
}
