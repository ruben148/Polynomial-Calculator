public class Monomial {

    private int q;
    private int power;

    public Monomial(int q, int power){
        this.q = q;
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public int getQ() {
        return q;
    }

    public void setQ(int q) {
        this.q = q;
    }
}
