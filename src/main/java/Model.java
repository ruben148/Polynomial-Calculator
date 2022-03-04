import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Model {





    static Polynomial addPolynomials(Polynomial P, Polynomial Q){
        LinkedList<Monomial> monomials = new LinkedList<>();
        Iterator<Monomial> itrP = P.getMonomials().descendingIterator();
        Iterator<Monomial> itrQ = Q.getMonomials().descendingIterator();
        int power = 0;

        while(itrP.hasNext() || itrQ.hasNext()){
            Monomial m1,m2;
            try{
                m1 = itrP.next();
            } catch(Exception e){
                m1 = new Monomial(0, power);
            }
            try{
                m2 = itrQ.next();
            } catch(Exception e){
                m2 =new Monomial(0,power);
            }
            monomials.add(new Monomial(m1.getQ() + m2.getQ(), power));
            power++;
        }
        return new Polynomial(monomials);
    }

    static Polynomial subtractPolynomials(Polynomial P, Polynomial Q){
        LinkedList<Monomial> monomials = new LinkedList<>();
        Iterator<Monomial> itrP = P.getMonomials().descendingIterator();
        Iterator<Monomial> itrQ = Q.getMonomials().descendingIterator();
        int power = 0;
        while(itrP.hasNext() || itrQ.hasNext()){
            Monomial m1,m2;
            try{
                m1 = itrP.next();
            } catch(Exception e){
                m1 = new Monomial(0, power);
            }
            try{
                m2 = itrQ.next();
            } catch(Exception e){
                m2 =new Monomial(0,power);
            }
            monomials.add(new Monomial(m1.getQ() - m2.getQ(), power));
            power++;
        }
        return new Polynomial(monomials);
    }

    static Monomial multiplyMonomials(Monomial m1, Monomial m2){
        return new Monomial(m1.getQ()* m2.getQ(), m1.getPower()+ m2.getPower());
    }

    static Polynomial multiplyPolynomials(Polynomial P, Polynomial Q){
        LinkedList<Monomial> monomials = new LinkedList<>();
        for(Monomial m1 : P.getMonomials())
            for(Monomial m2 : Q.getMonomials())
                monomials.add(multiplyMonomials(m1,m2));
        return new Polynomial(monomials);
    }

    static void derivative(Polynomial P){
        Monomial m_remove = null;
        for(Monomial m : P.getMonomials()){
            m.setQ(m.getQ() * m.getPower());
            m.setPower(m.getPower() - 1);
            m_remove = m;
        }
        P.getMonomials().remove(m_remove);
    }

    static void integral(Polynomial P){
        for(Monomial m : P.getMonomials()){
            m.setQ(m.getQ()/(m.getPower()+1));
            m.setPower(m.getPower()+1);
        }
        P.addMissingPowers();
    }
}
