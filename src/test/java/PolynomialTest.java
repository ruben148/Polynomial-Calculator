import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class PolynomialTest {

    @Test
    void splitTest() {
        Polynomial t1 = new Polynomial("6x^4-2x^2+3x+1");
        Polynomial t2 = new Polynomial("6x^4-2x^2");
        Assertions.assertEquals(4, t1.getDegree());
        LinkedList<Monomial> t1L = new LinkedList<>();
        LinkedList<Monomial> t2L = new LinkedList<>();

        t1L.add(new Monomial(6,4));
        t1L.add(new Monomial(0,3));
        t1L.add(new Monomial(-2,2));
        t1L.add(new Monomial(3,1));
        t1L.add(new Monomial(1,0));

        t2L.add(new Monomial(6,4));
        t2L.add(new Monomial(0,3));
        t2L.add(new Monomial(-2,2));
        t2L.add(new Monomial(0,1));
        t2L.add(new Monomial(0,0));

        assertArrayEquals(t1L.toArray(),t1.getMonomials().toArray());
        assertArrayEquals(t2L.toArray(),t2.getMonomials().toArray());
    }
}