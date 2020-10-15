import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

enum State {
    BASE, AMOUNT, DIFFERENCE, MULTIPLICATION, DEL
}
public class Calculator {
    private JTextField argumentFirst;
    private JTextField argumentSecond;
    private JTextField result;
    private State      state = State.BASE;
    private JPanel     buttonsPanel;
    private Component[] stateButtons;
    private DocumentListener myDocumentListener = new DocumentListener() {

        public void insertUpdate(DocumentEvent e) {
            calculation();
        }
        public void removeUpdate(DocumentEvent e) {
            calculation();
        }
        public void changedUpdate(DocumentEvent e) {
        }
    };
    private JFrame prepareFrame() {
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(300, 300));
        JPanel mainLayout = prepareMainLayout();
        frame.getContentPane().add(mainLayout);
        frame.pack();
        frame.setVisible(true);
        return frame;
    }
    private void prepareButtons() {
        JButton btnSum = new JButton("+");
        btnSum.setSize(50, 50);
        btnSum.addActionListener((event)-> { setEnabled(State.AMOUNT);
        });
        JButton btnMin = new JButton("-");
        btnMin.setSize(50, 50);
        btnMin.addActionListener((event)-> { setEnabled(State.DIFFERENCE);
        });
        JButton btnUmn = new JButton("*");
        btnUmn.setSize(50, 50);
        btnUmn.addActionListener((event)-> { setEnabled(State.MULTIPLICATION);
        });
        JButton btnDel = new JButton("/");
        btnDel.setSize(50, 50);
        btnDel.addActionListener((event)-> { setEnabled(State.DEL);
        });
        buttonsPanel.add(btnSum);
        buttonsPanel.add(btnMin);
        buttonsPanel.add(btnUmn);
        buttonsPanel.add(btnDel);
    }
    public Calculator() {
        argumentFirst = new JTextField();
        argumentFirst.setHorizontalAlignment(JTextField.CENTER);
        argumentFirst.setMaximumSize(new Dimension(50,50));
        argumentFirst.setPreferredSize(new Dimension(50, 50));
        argumentFirst.getDocument().addDocumentListener(myDocumentListener);

        argumentSecond = new JTextField();
        argumentSecond.setHorizontalAlignment(JTextField.CENTER);
        argumentSecond.setMaximumSize(new Dimension(50,50));
        argumentSecond.setPreferredSize(new Dimension(50, 50));
        argumentSecond.getDocument().addDocumentListener(myDocumentListener);

        result = new JTextField();
        result.setHorizontalAlignment(JTextField.CENTER);
        result.setEnabled(false);
        result.setMaximumSize(new Dimension(50,50));
        result.setPreferredSize(new Dimension(50,50));
        buttonsPanel = new JPanel(new FlowLayout());
        prepareButtons();
        stateButtons = buttonsPanel.getComponents();
    }
    private JPanel prepareMainLayout() {
        JPanel textFields = new JPanel(new GridLayout(4,1));
        textFields.add(argumentFirst);
        textFields.add(buttonsPanel);
        textFields.add(argumentSecond);
        textFields.add(result);

        JPanel mainLayout = new JPanel(new FlowLayout(FlowLayout.CENTER));
        mainLayout.add(textFields);

        return mainLayout;
    }
    private void calculation() {
        double A = Float.parseFloat(argumentFirst.getText());
        double B = Float.parseFloat(argumentSecond.getText());

        switch (this.state) {
            case AMOUNT: {
                double ans = A + B;
                result.setText(String.valueOf(ans));
                break;
            }
            case DIFFERENCE: {
                double ans = A - B;
                result.setText(String.valueOf(ans));
                break;
            }
            case DEL: {
                double ans = A / B;
                result.setText(String.valueOf(ans));
                break;
            }
            case MULTIPLICATION: {
                double ans = A * B;
                result.setText(String.valueOf(ans));
                break;
            }
            case BASE: {
                break;
            }
        }
    }
    private void setEnabled(State state) {
        switch (this.state) {
            case AMOUNT: {
                JButton btn = (JButton) stateButtons[0];
                btn.setSelected(false);
                break;
            }
            case DIFFERENCE :{
                JButton btn = (JButton) stateButtons[1];
                btn.setSelected(false);
                break;
            }
            case MULTIPLICATION :{
                JButton btn = (JButton) stateButtons[2];
                btn.setSelected(false);
                break;
            }
            case DEL : {
                JButton btn = (JButton) stateButtons[3];
                btn.setSelected(false);
                break;
            }
        }
        switch (state) {
            case AMOUNT: {
                JButton btn = (JButton) stateButtons[0];
                btn.setSelected(true);
                break;
            }
            case DIFFERENCE :{
                JButton btn = (JButton) stateButtons[1];
                btn.setSelected(true);
                break;
            }
            case MULTIPLICATION :{
                JButton btn = (JButton) stateButtons[2];
                btn.setSelected(true);
                break;
            }
            case DEL : {
                JButton btn = (JButton) stateButtons[3];
                btn.setSelected(true);
                break;
            }
        }
        this.state = state;
        calculation();
    }
    public void move() {
        JFrame frame = prepareFrame();

    }
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.move();
    }
}