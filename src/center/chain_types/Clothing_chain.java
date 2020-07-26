package center.chain_types;

import center.Chain;

public class Clothing_chain extends Chain {
    private String importer;// 20 chars

    public Clothing_chain(String name, String importer) {
        super(name);
        this.importer = importer;
    }

    @Override
    public String toString() {
        return super.toString() + "Clothing_chain [importer=" + importer + "]";
    }

}
