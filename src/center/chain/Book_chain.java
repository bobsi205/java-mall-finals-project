package center.chain;

import center.Chain;

public class Book_chain extends Chain {
    private String bestSeller; // max 30 chars

    public Book_chain(String name, String bestSeller) {
        super(name);
        this.bestSeller = bestSeller;
    }

    @Override
    public String toString() {
        return super.toString() + "Book_chain [bestSeller=" + bestSeller + "]";
    }

}
