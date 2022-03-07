import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    GUI ui;
    Model model;
    public Controller(GUI _ui, Model _model) {
        ui = _ui;
        model = _model;

        ui.addListeners(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        model.setP(ui.getFirstPolynomial());
                        model.setQ(ui.getSecondPolynomial());
                        model.addPolynomials();
                        ui.setResultPolynomial(model.getResult1().toString());
                    }
                }, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        model.setP(ui.getFirstPolynomial());
                        model.setQ(ui.getSecondPolynomial());
                        model.subtractPolynomials();
                        ui.setResultPolynomial(model.getResult1().toString());
                    }
                }, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        model.setP(ui.getFirstPolynomial());
                        model.setQ(ui.getSecondPolynomial());
                        model.multiplyPolynomials();
                        ui.setResultPolynomial(model.getResult1().toString());
                    }
                }, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        model.setP(ui.getFirstPolynomial());
                        model.setQ(ui.getSecondPolynomial());
                        model.multiplyPolynomials();
                        ui.setResultPolynomial(model.getResult1().toString());
                    }
                }, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        model.setP(ui.getFirstPolynomial());
                        model.derivePolynomial();
                        ui.setResultPolynomial(model.getResult1().toString());
                    }
                }, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        model.setP(ui.getSecondPolynomial());
                        model.integratePolynomial();
                        ui.setResultPolynomial(model.getResult1().toString());
                    }
                }, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        model.setP(ui.getFirstPolynomial());
                        model.integratePolynomial();
                        ui.setResultPolynomial(model.getResult1().toString());
                    }
                }, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        model.setP(ui.getSecondPolynomial());
                        model.integratePolynomial();
                        ui.setResultPolynomial(model.getResult1().toString());
                    }
                });
    }
}
