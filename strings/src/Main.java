public class Main {
    public static void main(String[] args) {
        String nome = "Michele Roncaglia";

        if (nome.isEmpty()) {
            System.out.println("il nome è vuoto");
            System.exit(0);
        } else {
            System.out.println("il nome non è vuoto");
        }
        int lunghezza = nome.length();
        char lettera = nome.charAt(0);
        int indice = nome.indexOf("a");
        int ultimo_indice = nome.lastIndexOf("a");

        System.out.println(lunghezza);
        System.out.println(lettera);
        System.out.println(indice);
        System.out.println(ultimo_indice);

        nome = nome.toUpperCase();
        System.out.println(nome);
        nome = nome.toLowerCase();
        System.out.println(nome);
        nome = nome.trim();
        System.out.println(nome);
        nome = nome.replace("e","a");
        System.out.println(nome);

    }
}