public class Main {
    public static void main(String[] args) {
        Triangolo triangolo = new Triangolo(3.0, 2.0 ,3.0);
        Quadrato quadrato = new Quadrato(4);

        System.out.println("<------- Triangolo ------->");
        if(triangolo.lato == triangolo.lato1 && triangolo.lato1 == triangolo.lato2){
            System.out.println("Tipo:  Equilatero");
        }else if(triangolo.lato == triangolo.lato1 || triangolo.lato1 == triangolo.lato2 || triangolo.lato == triangolo.lato2){
            System.out.println("Tipo:  Isoscele");
        }else{
            System.out.println("Tipo:  Scaleno");
        }
        System.out.println("Base:  " + triangolo.lato);
        System.out.println("Lato1: " + triangolo.lato1);
        System.out.println("Lato2: " + triangolo.lato2);
        System.out.println("2p:    " + triangolo.perimetro);
        System.out.println("Area:  " + triangolo.area);
        System.out.println();
        System.out.println("<------- Quadrato ------->");
        System.out.println("Base:  " + quadrato.lato);
        System.out.println("2p:    " + quadrato.perimetro);
        System.out.println("Area:  " + quadrato.area);

        System.out.println("madonna ladra");
    }
}