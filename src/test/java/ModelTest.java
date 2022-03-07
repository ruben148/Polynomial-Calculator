import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {

    @ParameterizedTest
    @MethodSource("input")
    void addPolynomials(Polynomial a, Polynomial b, Polynomial sum, Polynomial sub, Polynomial mul, Polynomial div, Polynomial der, Polynomial in) {
        Model model = new Model();
        model.setP(a);
        model.setQ(b);
        model.addPolynomials();
        assertEquals(sum,model.getResult1());
    }

    @ParameterizedTest
    @MethodSource("input")
    void subtractPolynomials(Polynomial a, Polynomial b, Polynomial sum, Polynomial sub, Polynomial mul, Polynomial div, Polynomial der, Polynomial in) {
        Model model = new Model();
        model.setP(a);
        model.setQ(b);
        model.subtractPolynomials();
        assertEquals(sub,model.getResult1());
    }

    @ParameterizedTest
    @MethodSource("input")
    void multiplyPolynomials(Polynomial a, Polynomial b, Polynomial sum, Polynomial sub, Polynomial mul, Polynomial div, Polynomial der, Polynomial in) {
        Model model = new Model();
        model.setP(a);
        model.setQ(b);
        model.multiplyPolynomials();
        assertEquals(mul,model.getResult1());
    }

    @ParameterizedTest
    @MethodSource("input")
    void derivativeP(Polynomial a, Polynomial b, Polynomial sum, Polynomial sub, Polynomial mul, Polynomial div, Polynomial der, Polynomial in) {
        Model model = new Model();
        model.setP(a);
        model.setQ(b);
        model.derivePolynomial();
        assertEquals(der,model.getResult1());
    }

    @ParameterizedTest
    @MethodSource("input")
    void integrateP(Polynomial a, Polynomial b, Polynomial sum, Polynomial sub, Polynomial mul, Polynomial div, Polynomial der, Polynomial in) {
        Model model = new Model();
        model.setP(a);
        model.setQ(b);
        model.integratePolynomial();
        assertEquals(in,model.getResult1());
    }

    private static List<Arguments> input(){
        List<Arguments> argumentsList = new ArrayList<>();
        argumentsList.add(Arguments.of(
                new Polynomial("4x^6+x^5-2x^2+1"), //P
                new Polynomial("3x^5+2x^3-2x"), //Q
                new Polynomial("4x^6+4x^5+2x^3-2x^2-2x+1"), //Sum
                new Polynomial("4x^6-2x^5-2x^3-2x^2+2x+1"), //Subtract
                new Polynomial("12x^11+3x^10+8x^9+2x^8-14x^7-2x^6-x^5+6x^3-2x"), //Multiply
                new Polynomial("x"), //Divide
                new Polynomial("24x^5+5x^4-4x"), //Derivative
                new Polynomial("x"))); //Integral
        argumentsList.add(Arguments.of(
                new Polynomial("4x^6+x^5-2x^2+1"), //P
                new Polynomial("3x^5+2x^3-2x"), //Q
                new Polynomial("4x^6+4x^5+2x^3-2x^2-2x+1"), //Sum
                new Polynomial("4x^6-2x^5-2x^3-2x^2+2x+1"), //Subtract
                new Polynomial("12x^11+3x^10+8x^9+2x^8-14x^7-2x^6-x^5+6x^3-2x"), //Multiply
                new Polynomial("x"), //Divide
                new Polynomial("24x^5+5x^4-4x"), //Derivative
                new Polynomial("x"))); //Integral
        argumentsList.add(Arguments.of(
                new Polynomial("4x^6+x^5-2x^2+1"), //P
                new Polynomial("3x^5+2x^3-2x"), //Q
                new Polynomial("4x^6+4x^5+2x^3-2x^2-2x+1"), //Sum
                new Polynomial("4x^6-2x^5-2x^3-2x^2+2x+1"), //Subtract
                new Polynomial("12x^11+3x^10+8x^9+2x^8-14x^7-2x^6-x^5+6x^3-2x"), //Multiply
                new Polynomial("x"), //Divide
                new Polynomial("24x^5+5x^4-4x"), //Derivative
                new Polynomial("x"))); //Integral
        argumentsList.add(Arguments.of(
                new Polynomial("4x^6+x^5-2x^2+1"), //P
                new Polynomial("3x^5+2x^3-2x"), //Q
                new Polynomial("4x^6+4x^5+2x^3-2x^2-2x+1"), //Sum
                new Polynomial("4x^6-2x^5-2x^3-2x^2+2x+1"), //Subtract
                new Polynomial("12x^11+3x^10+8x^9+2x^8-14x^7-2x^6-x^5+6x^3-2x"), //Multiply
                new Polynomial("x"), //Divide
                new Polynomial("24x^5+5x^4-4x"), //Derivative
                new Polynomial("x"))); //Integral
        argumentsList.add(Arguments.of(
                new Polynomial("4x^6+x^5-2x^2+1"), //P
                new Polynomial("3x^5+2x^3-2x"), //Q
                new Polynomial("4x^6+4x^5+2x^3-2x^2-2x+1"), //Sum
                new Polynomial("4x^6-2x^5-2x^3-2x^2+2x+1"), //Subtract
                new Polynomial("12x^11+3x^10+8x^9+2x^8-14x^7-2x^6-x^5+6x^3-2x"), //Multiply
                new Polynomial("x"), //Divide
                new Polynomial("24x^5+5x^4-4x"), //Derivative
                new Polynomial("x"))); //Integral
        return argumentsList;
    }

}