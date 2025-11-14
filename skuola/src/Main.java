public class Main {
    public static void main(String[] args) {
        casa casa_pat = new casa("riccardo", true, 10, 250);

        System.out.println("nome = "+ casa_pat.nome);
        if(casa_pat.fibraottica){
            System.out.println("fibra ottica presente");
        }else{
            System.out.println("fibra ottica non presente");
        }
        System.out.println("numero stanze = "+ casa_pat.numstanze);
        System.out.println("dimensione = " + casa_pat.metriquadri + "mq");

        System.out.println( );
        casa casa_negro = new casa("Casa negro", false, 3000, 42069.6761);

        System.out.println("nome = "+ casa_negro.nome);
        if(casa_negro.fibraottica){
            System.out.println("fibra ottica presente");
        }else{
            System.out.println("fibra ottica non presente");
        }
        System.out.println("numero stanze = "+ casa_negro.numstanze);
        System.out.println("dimensione = " + casa_negro.metriquadri + "mq");
    }
}