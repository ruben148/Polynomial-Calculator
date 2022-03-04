import java.util.ListIterator;

public class test {
    public static void main(String[] args){
        String _P = "x^3+2x-1+x^3";
        String _Q = "-4*x^3-7*x^2";
        _P = Model.firstTransform(_P);
        _Q = Model.firstTransform(_Q);
        System.out.println("P= "+_P);
        System.out.println("Q= "+_Q);



        Polynomial P = Model.secondTransform(_P);
        Polynomial Q = Model.secondTransform(_Q);

        Polynomial Product = Model.multiplyPolynomials(P,Q);
        Polynomial Subtract = Model.subtractPolynomials(P,Q);
        Polynomial Sum = Model.addPolynomials(P,Q);
        Model.integral(P);
        Model.derivative(Q);


        System.out.print("\nProduct: ");
        for(Monomial m : Product.getMonomials())
            System.out.format("%+d*x^%d", m.getQ(), m.getPower());

        System.out.print("\n\nSubtract: ");
        for(Monomial m : Subtract.getMonomials())
            System.out.format("%+d*x^%d", m.getQ(), m.getPower());

        System.out.print("\n\nSum: ");
        for(Monomial m : Sum.getMonomials())
            System.out.format("%+d*x^%d", m.getQ(), m.getPower());
        P.showList();
        Q.showList();
        System.out.println("\n\n");

        GUI gui = new GUI();

    }
}
