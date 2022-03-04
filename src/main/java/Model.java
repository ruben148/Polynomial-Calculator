import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Model {

    static String firstTransform(String _polynomial){               /////add missing '*', '+' (at the beginning) or '1*'

        if(_polynomial.charAt(0) == 'x' || (_polynomial.charAt(0) > 47 && _polynomial.charAt(0) <= 57))
            _polynomial = "+" + _polynomial;

        int index = _polynomial.indexOf('x');
        while(index >= 0) {
            if (_polynomial.charAt(index - 1) == '+' || _polynomial.charAt(index - 1) == '-')
                _polynomial = _polynomial.substring(0, index) + "1" + _polynomial.substring(index);
            if ((_polynomial.charAt(index - 1) > 47 && _polynomial.charAt(index - 1) <= 57))
                _polynomial = _polynomial.substring(0, index) + "*" + _polynomial.substring(index);
            index = _polynomial.indexOf('x',index+1);
        }

        return _polynomial;
    }

    static Polynomial secondTransform(String _polynomial){             /////split and create a Monomial List => Polynomial
        LinkedList<Monomial> monomials = new LinkedList<>();

        for (String _monomial : _polynomial.split("(?=\\+)|(?=-)"))
        {
            int q = 1;
            int power = 1;

            int indexOfX = _monomial.indexOf('*');
            int indexOfAt = _monomial.indexOf('^');

            if(indexOfX == -1){
                q = Integer.parseInt(_monomial);
                power = 0;
            }
            else {
                try {
                    q = Integer.parseInt(_monomial.substring(0, indexOfX));
                } catch (Exception ignored) {}
                try {
                    power = Integer.parseInt(_monomial.substring(indexOfAt + 1));
                } catch (Exception ignored) {}
            }
            monomials.add(new Monomial(q, power));
        }
        return new Polynomial(monomials);
    }

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
