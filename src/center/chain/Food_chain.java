package center.chain;

import center.Chain;

public class Food_chain extends Chain {
    protected int suppliers;

    public Food_chain(String name, int suppliers) {
        super(name);
        this.suppliers = suppliers;
    }

    @Override
    public String toString() {
        return super.toString() + "Food_chain [suppliers=" + suppliers + "]";
    }

}
