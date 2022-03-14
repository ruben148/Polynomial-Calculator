import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class GUI extends JFrame {

    private JPanel numbers = new JPanel();
    private JPanel controls = new JPanel();
    private JPanel polynomial_labels = new JPanel();
    private JPanel polynomials = new JPanel();

    private Font font1 = new Font("Arial", Font.PLAIN, 30);
    private Font font2 = new Font("Arial", Font.PLAIN, 20);
    private Font font3 = new Font("Arial", Font.PLAIN, 14);

    private JLabel firstPolynomial_label = new JLabel("First polynomial ");
    private JLabel secondPolynomial_label = new JLabel("Second polynomial ");
    private JLabel resultPolynomial_label = new JLabel("Result ");

    private JButton btn0 = new JButton("0");
    private JButton btn1 = new JButton("1");
    private JButton btn2 = new JButton("2");
    private JButton btn3 = new JButton("3");
    private JButton btn4 = new JButton("4");
    private JButton btn5 = new JButton("5");
    private JButton btn6 = new JButton("6");
    private JButton btn7 = new JButton("7");
    private JButton btn8 = new JButton("8");
    private JButton btn9 = new JButton("9");
    private JButton btnX = new JButton("x");
    private JButton btnPow = new JButton("^");
    private JButton btnPlus = new JButton("+");
    private JButton btnMinus = new JButton("-");
    private JButton btnTimes = new JButton("*");
    private JButton btnPoint = new JButton(".");
    private JButton btnC = new JButton("C");
    private JButton btnBackspace = new JButton("<");
    private JButton btnSlash = new JButton("/");
    private JButton btnEmpty = new JButton("");

    private JTextField firstPolynomial = new JTextField("6x^4-9x^2+18");
    private JTextField secondPolynomial = new JTextField("x-3");
    private JTextField resultPolynomial = new JTextField();

    private JButton btnAdd = new JButton("Add");
    private JButton btnSubtract = new JButton("Subtract");
    private JButton btnMultiply = new JButton("Multiply");
    private JButton btnDivide = new JButton("Divide");
    private JButton btnDerive1 = new JButton("Derivate1");
    private JButton btnIntegrate1 = new JButton("Integrate1");
    private JButton btnDerive2 = new JButton("Derivate2");
    private JButton btnIntegrate2 = new JButton("Integrate2");

    private JPanel derive = new JPanel();
    private JPanel integrate = new JPanel();

    private JSplitPane splitPane2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, controls, numbers);
    private JSplitPane splitPane3 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, polynomial_labels, polynomials);
    private JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, splitPane3, splitPane2);

    GUI() {
        super("Polynomial calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 600);
        setLocationRelativeTo(null);

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object s = e.getSource();
                Component comp = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
                if(comp instanceof JTextComponent)
                    ((JTextComponent) comp).setText(((JTextComponent) comp).getText() + ((JButton) s).getText());
            }
        };

        derive.setLayout(new GridLayout(1,2));
        integrate.setLayout(new GridLayout(1,2));
        derive.add(btnDerive1);
        derive.add(btnDerive2);
        integrate.add(btnIntegrate1);
        integrate.add(btnIntegrate2);
        btn0.addActionListener(actionListener);
        btn1.addActionListener(actionListener);
        btn2.addActionListener(actionListener);
        btn3.addActionListener(actionListener);
        btn4.addActionListener(actionListener);
        btn5.addActionListener(actionListener);
        btn6.addActionListener(actionListener);
        btn7.addActionListener(actionListener);
        btn8.addActionListener(actionListener);
        btn9.addActionListener(actionListener);
        btnPlus.addActionListener(actionListener);
        btnMinus.addActionListener(actionListener);
        btnPow.addActionListener(actionListener);
        btnSlash.addActionListener(actionListener);
        btnPoint.addActionListener(actionListener);
        btnTimes.addActionListener(actionListener);
        btnX.addActionListener(actionListener);

        btnBackspace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component comp = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
                if(comp instanceof JTextComponent)
                    if(((JTextComponent) comp).getText().length() > 0)
                        ((JTextComponent) comp).setText(((JTextComponent) comp).getText().substring(0,((JTextComponent) comp).getText().length()-1));
            }
        });

        btnC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component comp = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
                if(comp instanceof JTextComponent)
                    ((JTextComponent) comp).setText("");
            }
        });

        //resultPolynomial.setFocusable(false);
        resultPolynomial.setEditable(false);

        btn0.setFocusable(false);
        btn1.setFocusable(false);
        btn2.setFocusable(false);
        btn3.setFocusable(false);
        btn4.setFocusable(false);
        btn5.setFocusable(false);
        btn6.setFocusable(false);
        btn7.setFocusable(false);
        btn8.setFocusable(false);
        btn9.setFocusable(false);
        btnX.setFocusable(false);
        btnPow.setFocusable(false);
        btnMinus.setFocusable(false);
        btnPlus.setFocusable(false);
        btnTimes.setFocusable(false);
        btnSlash.setFocusable(false);
        btnPoint.setFocusable(false);
        btnC.setFocusable(false);
        btnBackspace.setFocusable(false);
        btnEmpty.setFocusable(false);

        numbers.setLayout(new GridLayout(5, 4));
        controls.setLayout(new GridLayout(3, 2));

        firstPolynomial.setFont(font2);
        secondPolynomial.setFont(font2);
        resultPolynomial.setFont(font2);


        firstPolynomial_label.setHorizontalAlignment(SwingConstants.RIGHT);
        secondPolynomial_label.setHorizontalAlignment(SwingConstants.RIGHT);
        resultPolynomial_label.setHorizontalAlignment(SwingConstants.RIGHT);

        firstPolynomial_label.setFont(font3);
        secondPolynomial_label.setFont(font3);
        resultPolynomial_label.setFont(font3);


        btn0.setFont(font1);
        btn1.setFont(font1);
        btn2.setFont(font1);
        btn3.setFont(font1);
        btn4.setFont(font1);
        btn5.setFont(font1);
        btn6.setFont(font1);
        btn7.setFont(font1);
        btn8.setFont(font1);
        btn9.setFont(font1);
        btnX.setFont(font1);
        btnPow.setFont(font1);
        btnPlus.setFont(font1);
        btnMinus.setFont(font1);
        btnPoint.setFont(font1);
        btnC.setFont(font1);
        btnBackspace.setFont(font1);
        btnSlash.setFont(font1);
        btnEmpty.setFont(font1);

        numbers.add(btnC);
        numbers.add(btnEmpty);
        numbers.add(btnX);
        numbers.add(btnBackspace);

        numbers.add(btn7);
        numbers.add(btn8);
        numbers.add(btn9);
        numbers.add(btnMinus);

        numbers.add(btn4);
        numbers.add(btn5);
        numbers.add(btn6);
        numbers.add(btnPlus);


        numbers.add(btn1);
        numbers.add(btn2);
        numbers.add(btn3);
        numbers.add(btnTimes);

        numbers.add(btn0);
        numbers.add(btnPoint);
        numbers.add(btnPow);
        numbers.add(btnSlash);

        numbers.setVisible(true);

        btnAdd.setFont(font2);
        btnSubtract.setFont(font2);
        btnMultiply.setFont(font2);
        btnDivide.setFont(font2);
        btnDerive1.setFont(font3);
        btnDerive2.setFont(font3);
        btnIntegrate1.setFont(font3);
        btnIntegrate2.setFont(font3);

        controls.add(btnAdd);
        controls.add(btnSubtract);
        controls.add(btnMultiply);
        controls.add(btnDivide);
        controls.add(derive);
        controls.add(integrate);

        polynomial_labels.setLayout(new GridLayout(3, 1));
        polynomials.setLayout(new GridLayout(3, 1));
        polynomial_labels.add(firstPolynomial_label);
        polynomial_labels.add(secondPolynomial_label);
        polynomial_labels.add(resultPolynomial_label);
        polynomials.add(firstPolynomial);
        polynomials.add(secondPolynomial);
        polynomials.add(resultPolynomial);


        splitPane3.setDividerSize(1);
        splitPane3.setContinuousLayout(true);
        splitPane2.setDividerSize(1);
        splitPane2.setContinuousLayout(true);
        splitPane.setDividerSize(1);
        splitPane.setContinuousLayout(true);

        splitPane3.setVisible(true);
        splitPane2.setVisible(true);
        splitPane.setVisible(true);

        splitPane3.setEnabled(false);
        splitPane2.setEnabled(false);
        splitPane.setEnabled(false);

        add(splitPane);

        setVisible(true);

        splitPane.setDividerLocation(.3);
        splitPane2.setDividerLocation(.4);
        splitPane3.setDividerLocation(132);

        addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent evt) {
                splitPane.setDividerLocation(.3);
                splitPane2.setDividerLocation(.4);
                splitPane3.setDividerLocation(132);
            }
        });


    }

    public String getFirstPolynomial() {
        return firstPolynomial.getText();
    }

    public String getSecondPolynomial() {
        return secondPolynomial.getText();
    }

    public String getResultPolynomial() {
        return resultPolynomial.getText();
    }

    public void addListeners(ActionListener sum, ActionListener sub, ActionListener mul, ActionListener div, ActionListener der1, ActionListener der2, ActionListener in1, ActionListener in2){
        btnAdd.addActionListener(sum);
        btnSubtract.addActionListener(sub);
        btnMultiply.addActionListener(mul);
        btnDivide.addActionListener(div);
        btnDerive1.addActionListener(der1);
        btnDerive2.addActionListener(der2);
        btnIntegrate1.addActionListener(in1);
        btnIntegrate2.addActionListener(in2);
    }

    public void setFirstPolynomial(String _firstPolynomial) {
        firstPolynomial.setText(_firstPolynomial);
    }

    public void setSecondPolynomial(String _secondPolynomial) {
        secondPolynomial.setText(_secondPolynomial);
    }

    public void setResultPolynomial(String _resultPolynomial) {
        resultPolynomial.setText(_resultPolynomial);
    }
}
