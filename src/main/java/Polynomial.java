import java.util.*;

public class Polynomial {

    private LinkedList<Monomial> monomials;
    private int degree;

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
