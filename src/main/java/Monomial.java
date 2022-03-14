public class Monomial {

    private double q;
    private int power;

    @Override
    public String toString(){
        String s = Double.toString(q)+"*x^"+Integer.toString(power);
        return s;
    }

    public void print(){
        System.out.println(q+"*x^"+power);
    }

    @Override
    public boolean equals(Object o){
        if(this == o)
            return true;
        if(o == null || getClass() != o.getClass())
            return false;
        Monomial monomial = (Monomial) o;
        if(monomial.getQ() == q && monomial.getPower() == power)
            return true;
        return false;

    }

    public Monomial(double q, int power){
        this.q = q;
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public double getQ() {
        return q;
    }

    public void setQ(double q) {
        this.q = q;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
