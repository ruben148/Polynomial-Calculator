import java.util.*;

public class Polynomial {

    private LinkedList<Monomial> monomials;
    private int degree;

    static String stringTransform(String _polynomial){               /////add missing '*', '1*'

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

    static LinkedList<Monomial> split(String _polynomial){             /////split and create a Monomial List => Polynomial
        LinkedList<Monomial> monomials = new LinkedList<>();
        _polynomial = stringTransform(_polynomial);
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
        return monomials;
    }

    public void showList(){
        System.out.println("");
        System.out.println("");
        for(Monomial m : monomials){
            System.out.println(m.getQ()+"*x^"+m.getPower());
        }
        System.out.println("");
        System.out.println("");
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
            else if(m2.getPower()>0)
            {
                itr.add(new Monomial(0, m2.getPower() - 1));
                itr.previous();
                m2 = itr.next();
            }
            else break;
        }
    }

    private void mergeMonomials(){
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
        LinkedList<Monomial> _monomials = split(_polynomial);
        this(_monomials);
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

    //get monomial list
    //get monomial with the highest degree
    //get degree

}
