package center.chain;

public class Fast_food_chain extends Food_chain {
    private double bmPrice;
    private float studentDiscount;

    public Fast_food_chain(String name, int suppliers, double bmPrice, float studentDiscount) {
        super(name, suppliers);
        this.bmPrice = bmPrice;
        this.studentDiscount = studentDiscount;
    }

    @Override
    public String toString() {
        return super.toString() + "Fast_food_chain [bmPrice=" + bmPrice + ", studentDiscount=" + studentDiscount + "]";
    }

}
