import java.util.*;

public class Polynomial {

    private LinkedList<Monomial> monomials;
    private int degree;

    Polynomial (LinkedList<Monomial> _monomials){
        monomials = _monomials;

        /////sort by power
        Collections.sort(monomials, (m1, m2) -> m2.getPower() - m1.getPower());
        ListIterator<Monomial> itr = monomials.listIterator();              /////add missing powers
        Monomial m1;
        Monomial m2;
        while(itr.hasNext()){
            m1 = itr.next();
            if(itr.hasNext())
            {
                m2 = itr.next();
                if(m1.getPower() - m2.getPower() > 1){
                    itr.previous();
                    itr.add(new Monomial(0, m1.getPower()-1));
                }
            }
            else if(m1.getPower()!=0){
                itr.add(new Monomial(0, m1.getPower()-1));
                itr.previous();
            }
        }
        degree = monomials.get(0).getPower();
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
