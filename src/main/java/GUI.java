import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class GUI extends JFrame {
    GUI() {
        super("Polynomial calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 600);
        setLocationRelativeTo(null);

        JPanel numbers = new JPanel();
        JPanel controls = new JPanel();
        JPanel polynomial_labels = new JPanel();
        JPanel polynomials = new JPanel();

        numbers.setLayout(new GridLayout(5, 4));
        controls.setLayout(new GridLayout(3, 2));

        Font font1 = new Font("Arial", Font.PLAIN, 30);
        Font font2 = new Font("Arial", Font.PLAIN, 20);
        Font font3 = new Font("Arial", Font.PLAIN, 14);

        JTextField polynomial1 = new JTextField();
        JTextField polynomial2 = new JTextField();
        JTextField polynomial_result = new JTextField();
        polynomial1.setFont(font2);
        polynomial2.setFont(font2);
        polynomial_result.setFont(font2);

        JLabel polynomial1_label = new JLabel("First polynomial ");
        JLabel polynomial2_label = new JLabel("Second polynomial ");
        JLabel polynomial_result_label = new JLabel("Result ");

        polynomial1_label.setHorizontalAlignment(SwingConstants.RIGHT);
        polynomial2_label.setHorizontalAlignment(SwingConstants.RIGHT);
        polynomial_result_label.setHorizontalAlignment(SwingConstants.RIGHT);

        polynomial1_label.setFont(font3);
        polynomial2_label.setFont(font3);
        polynomial_result_label.setFont(font3);

        JButton btn0 = new JButton("0");
        JButton btn1 = new JButton("1");
        JButton btn2 = new JButton("2");
        JButton btn3 = new JButton("3");
        JButton btn4 = new JButton("4");
        JButton btn5 = new JButton("5");
        JButton btn6 = new JButton("6");
        JButton btn7 = new JButton("7");
        JButton btn8 = new JButton("8");
        JButton btn9 = new JButton("9");
        JButton btnX = new JButton("x");
        JButton btnPow = new JButton("^");
        JButton btnPlus = new JButton("+");
        JButton btnMinus = new JButton("-");
        JButton btnTimes = new JButton("*");
        JButton btnPoint = new JButton(".");
        JButton btnC = new JButton("C");
        JButton btnBackspace = new JButton("<");
        JButton btnSlash = new JButton("/");
        JButton btnEmpty = new JButton("");

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

        JButton btnAdd = new JButton("Add");
        JButton btnSubtract = new JButton("Subtract");
        JButton btnMultiply = new JButton("Multiply");
        JButton btnDivide = new JButton("Divide");
        JButton btnDerivative = new JButton("Derivative");
        JButton btnIntegrate = new JButton("Integrate");

        btnAdd.setFont(font2);
        btnSubtract.setFont(font2);
        btnMultiply.setFont(font2);
        btnDivide.setFont(font2);
        btnDerivative.setFont(font2);
        btnIntegrate.setFont(font2);

        controls.add(btnAdd);
        controls.add(btnSubtract);
        controls.add(btnMultiply);
        controls.add(btnDivide);
        controls.add(btnDerivative);
        controls.add(btnIntegrate);

        polynomial_labels.setLayout(new GridLayout(3,1));
        polynomials.setLayout(new GridLayout(3,1));
        polynomial_labels.add(polynomial1_label);
        polynomial_labels.add(polynomial2_label);
        polynomial_labels.add(polynomial_result_label);
        polynomials.add(polynomial1);
        polynomials.add(polynomial2);
        polynomials.add(polynomial_result);

        JSplitPane splitPane2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, controls,numbers);
        JSplitPane splitPane3 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, polynomial_labels, polynomials);
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, splitPane3, splitPane2);


        splitPane3.setDividerSize( 1 );
        splitPane3.setContinuousLayout( true );
        splitPane2.setDividerSize( 1 );
        splitPane2.setContinuousLayout( true );
        splitPane.setDividerSize( 1 );
        splitPane.setContinuousLayout( true );

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
        splitPane3.setDividerLocation(.3);

        addComponentListener(new ComponentAdapter()
        {
            public void componentResized(ComponentEvent evt) {
                splitPane.setDividerLocation(.3);
                splitPane2.setDividerLocation(.4);
                splitPane3.setDividerLocation(.3);
            }
        });






    }
}
