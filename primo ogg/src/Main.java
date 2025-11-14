public class Main {
    public static void main(String[] args) {

        Macchina macchina = new Macchina();
        Macchina macchina2 = new Macchina();

        System.out.println(macchina.anno);
        System.out.println(macchina.modello);
        System.out.println(macchina.produttore);
        System.out.println(macchina.acceso);
        System.out.println(macchina.prezzo);

        macchina.accendi();
        System.out.println(macchina.acceso);

        macchina.spegni();
        System.out.println(macchina.acceso);

        macchina.guida();
        macchina.fermati();

        studenti studente1 = new studenti("Michele Roncaglia", 17, 4.6);
        studenti studente2 = new studenti("Riky_Paaat_The_DestroASSyer56_08", 17, 6);
        studente1.studia();
        studente2.studia();
    }
}