import java.util.HashMap;

class Menu {
    private HashMap<Integer, E> piatti;
    private HashMap<Integer, E> bevande;

    Menu() {
        piatti = new HashMap<>();
        bevande = new HashMap<>();

        piatti.put(0, new E("spaghetti", 4));
        piatti.put(1, new E("pizza", 3));
        piatti.put(2, new E("verdura", 2));
        piatti.put(3, new E("pesce", 5));
        piatti.put(4, new E("carne", 2));

        bevande.put(0, new E("acqua", 1));
        bevande.put(1, new E("vino", 3));
        bevande.put(2, new E("birra", 2));
    }

    public E getP(int j) { return piatti.get(j); }
    public E getB(int j) { return bevande.get(j); }

    public void mostraP() {
        for (int i : piatti.keySet())
            System.out.println(i + ". " + piatti.get(i).getNom());
    }

    public void mostraB() {
        for (int i : bevande.keySet())
            System.out.println(i + ". " + bevande.get(i).getNom());
    }
}
