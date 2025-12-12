public class mago extends personaggio {

    private int mana = 10;

    mago(String nome, int vita) {
        super(nome, vita);
    }

    @Override
    int attacca() {
        if(mana >= 10){
            mana -= 10;
            super.setVita(25);
            return 25;
        }else{
            return super.attacca();
        }
    }

    @Override
    public String toString() {
        return super.toString() + " mana: " + this.mana;
    }
}
