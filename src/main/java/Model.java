import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Model {
    private Polynomial P = null;
    private Polynomial Q = null;
    private Polynomial result1 = null;
    private Polynomial remainder = null;

    public void addPolynomials(){
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
        result1 = new Polynomial(monomials);
        result1.deleteFirstZeroQ();
    }

    public void subtractPolynomials(){
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
        result1 = new Polynomial(monomials);
        result1.deleteFirstZeroQ();
    }

    public static Monomial multiplyMonomials(Monomial m1, Monomial m2) {
        return new Monomial(m1.getQ() * m2.getQ(), m1.getPower() + m2.getPower());
    }

    public void multiplyPolynomials(){
        Polynomial mul = new Polynomial();
        for(Monomial m1 : P.getMonomials())
            for(Monomial m2 : Q.getMonomials())
                mul.addMonomial(multiplyMonomials(m1,m2));
        result1 = mul;
        result1.deleteFirstZeroQ();
    }

    public static Monomial divideMonomials(Monomial m1, Monomial m2){
        return new Monomial(m1.getQ()/ m2.getQ(), m1.getPower()-m2.getPower());
    }

    public void dividePolynomials() {
        Polynomial mul = new Polynomial();
        Polynomial De = P;
        Polynomial I = Q;
        Polynomial sub = De;
        while (I.getDegree() <= sub.getDegree()) {
            Monomial m = divideMonomials(sub.getHighestDegreeMonomial(), I.getHighestDegreeMonomial());
            mul.addMonomial(m);
            P = new Polynomial();
            P.addMonomial(m);
            Q = I;
            multiplyPolynomials();
            P = sub;
            Q = result1;
            subtractPolynomials();
            sub = result1;
        }
        result1 = mul;
        result1.deleteFirstZeroQ();
        remainder = sub;
    }

    public void derivePolynomial(){
        Monomial m_remove = null;
        Polynomial result = new Polynomial(P);
        for(Monomial m : result.getMonomials()){
            m.setQ(m.getQ() * m.getPower());
            m.setPower(m.getPower() - 1);
            m_remove = m;
        }
        result.getMonomials().remove(m_remove);
        result.addMissingPowers();
        result.mergeMonomials();
        result1 = result;
        result1.deleteFirstZeroQ();
    }

    public void integratePolynomial(){
        Polynomial result = new Polynomial(P);
        for(Monomial m : result.getMonomials()){
            m.setQ(m.getQ()/(m.getPower()+1));
            m.setPower(m.getPower()+1);
        }
        result.addMissingPowers();
        result1 = result;
        result.addMissingPowers();
        result.mergeMonomials();
    }

    public void setP(Polynomial p) {
        P = p;
    }

    public void setQ(Polynomial q) {
        Q = q;
    }

    public void setP(String p) {
        P = new Polynomial(p);
    }

    public void setQ(String q) {
        Q = new Polynomial(q);
    }

    public Polynomial getResult1() {
        return result1;
    }

    public Polynomial getRemainder() {
        return remainder;
    }
}
