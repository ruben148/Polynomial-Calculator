import java.util.ListIterator;

public class test {
    public static void main(String[] args){
        String _P = "2x^4+x^3+2x-1";
        String _Q = "-4x^5-7x^3";
        _P = Model.firstTransform(_P);
        _Q = Model.firstTransform(_Q);
        System.out.println("P= "+_P);
        System.out.println("Q= "+_Q);

        Polynomial P = Model.secondTransform(_P);
        Polynomial Q = Model.secondTransform(_Q);

        Polynomial Sum = Model.addPolynomials(P,Q);

        Polynomial Product = Model.multiplyPolynomials(P,Q);

        System.out.println("Product: ");
        for(Monomial m : Product.getMonomials()){
            System.out.println(m.getQ()+"*x^"+m.getPower());
        }

    }
}
