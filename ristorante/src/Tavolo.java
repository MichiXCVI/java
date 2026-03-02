import java.util.HashMap;

class Tavolo {
    private int id, nCoperti;
    private HashMap<Integer, E> lista;
    private int counter = 0;

    Tavolo(int i, int nCop) {
        id = i;
        nCoperti = nCop;
        lista = new HashMap<>();
    }

    public void ins(E e) {
        lista.put(counter++, e);
    }

    private int calcolaSaldo() {
        int tot = 0;
        for (E e : lista.values()) tot += e.getPrz();
        return tot;
    }

    public int getId() { return id; }
    public int getNcop() { return nCoperti; }
    public int getSaldo() { return calcolaSaldo(); }

    public String getLista() {
        String s = "\n";
        for (E e : lista.values()) {
            s += e.getNom() + " - " + e.getPrz() + "\n";
        }
        return s;
    }

    public String toString() {
        return id + ":" + nCoperti + ":" + getLista() + "\nsaldo:" + getSaldo();
    }
}
