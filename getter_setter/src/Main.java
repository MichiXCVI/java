public class Main {
    public static void main(String[] args){
        Macchina macchina = new Macchina("panda 4x4", "bianca", 50000);
        System.out.println(macchina.getModello());
        System.out.println(macchina.getColore());
        System.out.println(macchina.getPrezzo());
    }
}