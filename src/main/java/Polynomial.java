import java.util.*;

public class Polynomial {

    private LinkedList<Monomial> monomials;
    private int degree;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Polynomial that = (Polynomial) o;
        if(degree != that.degree)
            return false;
        LinkedList<Monomial> thatMonomials = that.getMonomials();
        if (thatMonomials.size() != monomials.size())
            return false;
        for(int i=0;i<thatMonomials.size();i++)
            if(!thatMonomials.get(i).equals(monomials.get(i)))
                return false;
        return true;
    }

    public static String stringTransform(String _polynomial){               /////add missing '*', '1*'

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

    public static LinkedList<Monomial> split(String _polynomial){             /////split and create a Monomial List => Polynomial
        LinkedList<Monomial> monomials = new LinkedList<>();
        _polynomial = stringTransform(_polynomial);
        for (String _monomial : _polynomial.split("(?=\\+)|(?=-)"))
        {
            double q = 1;
            int power = 1;

            int indexOfX = _monomial.indexOf('*');
            int indexOfAt = _monomial.indexOf('^');

            if(indexOfX == -1){
                q = Double.parseDouble(_monomial);
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
        return monomials;
    }

    public void print(){
        System.out.println("");
        System.out.println("");
        for(Monomial m : monomials){
            System.out.println(m.getQ()+"*x^"+m.getPower());
        }
        System.out.println("");
        System.out.println("");
    }

    public String toString(){
        String polynomial = "";
        boolean first = true;
        String q = "";
        for(Monomial m : monomials){
            if(m.getQ() == (long) m.getQ())
                q = String.format("%d",(long)m.getQ());
            else
                q = String.format("%.3f",m.getQ());
            if(m.getQ()!=0) {
                if (!first)
                    if (m.getQ() > 0)
                        polynomial += "+";
                if(m.getQ() != 1 && m.getPower() != 0)
                    polynomial += q + "*";
                else if(m.getPower() == 0)
                    polynomial += q;

                if (m.getPower() == 1)
                    polynomial += "x";
                else if (m.getPower() != 0)
                    polynomial += "x^" + m.getPower();
                first = false;
            }
        }
        return polynomial;
    }

    public void addMissingPowers(){
        ListIterator<Monomial> itr = monomials.listIterator();
        Monomial m1 = null;
        Monomial m2 = null;
        if(itr.hasNext())
            m1 = itr.next();
        while(true) {
            if(itr.hasNext()) {
                m2 = itr.next();
                if (m1.getPower() - m2.getPower() > 1) {
                    itr.previous();
                    itr.add(new Monomial(0, m2.getPower() + 1));
                    itr.previous();
                }
                else
                    m1 = m2;
            }
            else {
                if(m2 == null)
                    m2 = m1;
                if (m2.getPower() > 0) {
                    itr.add(new Monomial(0, m2.getPower() - 1));
                    itr.previous();
                    m2 = itr.next();
                } else break;
            }
        }
    }

    public void mergeMonomials(){
        ListIterator<Monomial> itr = monomials.listIterator();
        Monomial m1 = null;
        Monomial m2;
        if(itr.hasNext())
            m1 = itr.next();
        while(itr.hasNext()){
            m2 = itr.next();
            if (m1.getPower() == m2.getPower()) {
                m1.setQ(m1.getQ() + m2.getQ());
                itr.remove();
                itr.next();
                m2=itr.previous();
            }
            else
                m1 = m2;
        }
    }

    public Polynomial (LinkedList<Monomial> _monomials){
        monomials = _monomials;

        Collections.sort(monomials, (m1, m2) -> m2.getPower() - m1.getPower());

        addMissingPowers();

        mergeMonomials();

        degree = monomials.get(0).getPower();
    }

    public Polynomial (String _polynomial){
        this(split(_polynomial));
    }

    public Polynomial (Polynomial copy_from){
        this.monomials = (LinkedList<Monomial>) copy_from.getMonomials().clone();
        this.degree = copy_from.getDegree();
    }

    public int getDegree() {
        return degree;
    }

    public LinkedList<Monomial> getMonomials() {
        return monomials;
    }

    public Monomial getHighestDegreeMonomial() {
        return monomials.get(0);
    }

}
