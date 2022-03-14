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
    void addPolynomials(Polynomial a, Polynomial b, Polynomial sum, Polynomial sub, Polynomial mul, Polynomial div, Polynomial der1, Polynomial der2, Polynomial in1, Polynomial in2) {
        Model model = new Model();
        model.setP(a);
        model.setQ(b);
        model.addPolynomials();
        assertEquals(sum,model.getResult1());
    }

    @ParameterizedTest
    @MethodSource("input")
    void subtractPolynomials(Polynomial a, Polynomial b, Polynomial sum, Polynomial sub, Polynomial mul, Polynomial div, Polynomial der1, Polynomial der2, Polynomial in1, Polynomial in2) {
        Model model = new Model();
        model.setP(a);
        model.setQ(b);
        model.subtractPolynomials();
        assertEquals(sub,model.getResult1());
    }

    @ParameterizedTest
    @MethodSource("input")
    void multiplyPolynomials(Polynomial a, Polynomial b, Polynomial sum, Polynomial sub, Polynomial mul, Polynomial div, Polynomial der1, Polynomial der2, Polynomial in1, Polynomial in2) {
        Model model = new Model();
        model.setP(a);
        model.setQ(b);
        model.multiplyPolynomials();
        assertEquals(mul,model.getResult1());
    }

    @ParameterizedTest
    @MethodSource("input")
    void dividePolynomials(Polynomial a, Polynomial b, Polynomial sum, Polynomial sub, Polynomial mul, Polynomial div, Polynomial der1, Polynomial der2, Polynomial in1, Polynomial in2) {
        Model model = new Model();
        model.setP(a);
        model.setQ(b);
        model.dividePolynomials();
        assertEquals(div,model.getResult1());
    }

    @ParameterizedTest
    @MethodSource("input")
    void derivativeP1(Polynomial a, Polynomial b, Polynomial sum, Polynomial sub, Polynomial mul, Polynomial div, Polynomial der1, Polynomial der2, Polynomial in1, Polynomial in2) {
        Model model = new Model();
        model.setP(a);
        model.derivePolynomial();
        assertEquals(der1,model.getResult1());
    }

    @ParameterizedTest
    @MethodSource("input")
    void integrateP1(Polynomial a, Polynomial b, Polynomial sum, Polynomial sub, Polynomial mul, Polynomial div, Polynomial der1, Polynomial der2, Polynomial in1, Polynomial in2) {
        Model model = new Model();
        model.setP(a);
        model.integratePolynomial();
        assertEquals(in1,model.getResult1());
    }

    @ParameterizedTest
    @MethodSource("input")
    void derivativeP2(Polynomial a, Polynomial b, Polynomial sum, Polynomial sub, Polynomial mul, Polynomial div, Polynomial der1, Polynomial der2, Polynomial in1, Polynomial in2) {
        Model model = new Model();
        model.setP(b);
        model.derivePolynomial();
        assertEquals(der2,model.getResult1());
    }

    @ParameterizedTest
    @MethodSource("input")
    void integrateP2(Polynomial a, Polynomial b, Polynomial sum, Polynomial sub, Polynomial mul, Polynomial div, Polynomial der1, Polynomial der2, Polynomial in1, Polynomial in2) {
        Model model = new Model();
        model.setP(b);
        model.integratePolynomial();
        assertEquals(in2,model.getResult1());
    }

    private static List<Arguments> input(){
        List<Arguments> argumentsList = new ArrayList<>();
        argumentsList.add(Arguments.of(
                new Polynomial("4x^6+x^5-2x^2+1"), //P
                new Polynomial("3x^5+2x^3-2x"), //Q
                new Polynomial("4x^6+4x^5+2x^3-2x^2-2x+1"), //Sum
                new Polynomial("4x^6-2x^5-2x^3-2x^2+2x+1"), //Subtract
                new Polynomial("12x^11+3x^10+8x^9+2x^8-14x^7-2x^6-x^5+6x^3-2x"), //Multiply
                new Polynomial("4/3x+1/3"), //Divide
                new Polynomial("24x^5+5x^4-4x"), //Derivative1
                new Polynomial("15x^4+6x^2-2"), //Derivative2
                new Polynomial("4/7x^7+1/6x^6-2/3x^3+x"), //Integral1
                new Polynomial("1/2x^6+1/2x^4-x^2"))); //Integral2

        argumentsList.add(Arguments.of(
                new Polynomial("2x^4-3x^3-15x^2+32x-12"), //P
                new Polynomial("x^2-4x-12"), //Q
                new Polynomial("2x^4-3x^3-14x^2+28x-24"), //Sum
                new Polynomial("2x^4-3x^3-16x^2+36x"), //Subtract
                new Polynomial("2x^6-11x^5-27x^4+128x^3+40x^2-336x+144"), //Multiply
                new Polynomial("2x^2+5x+29"), //Divide
                new Polynomial("8x^3-9x^2-30x+32"), //Derivative1
                new Polynomial("2x-4"), //Derivative2
                new Polynomial("2/5x^5-3/4x^4-5x^3+16x^2-12x"), //Integral1
                new Polynomial("1/3x^3-2x^2-12x"))); //Integral2
        return argumentsList;
    }

}