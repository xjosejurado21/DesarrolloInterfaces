package Calculadora;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleController extends JFrame {

    private JTextField display;
    private String input;

    public SimpleController() {
        setTitle("Calculadora Simple");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));

        String[] buttonLabels = {"1", "2", "3", "C",
                                 "4", "5", "6", "%",
                                 "7", "8", "9", "0",
                                 "+", "-", "*", "/"};

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            String buttonText = source.getText();

            switch (buttonText) {
                case "=":
                    calculateResult();
                    break;
                case "C":
                    clearInput();
                    break;
                default:
                    updateInput(buttonText);
                    break;
            }
        }
    }

    private void calculateResult() {
        try {
            // Evaluar la expresión matemática
            double result = eval(input);
            display.setText(Double.toString(result));
            input = "";
        } catch (Exception ex) {
            // Manejar errores, por ejemplo, división por cero
            display.setText("Error");
            input = "";
        }
    }

    private void clearInput() {
        input = "";
        display.setText("");
    }

    private void updateInput(String buttonText) {
        input += buttonText;
        display.setText(input);
    }

    // Método para evaluar la expresión matemática
    private double eval(String expression) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < expression.length()) ? expression.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < expression.length()) throw new RuntimeException("Caracter inesperado: " + (char) ch);
                return x;
            }

            double parseExpression() {
                double x = parseTerm();
                for (; ; ) {
                    if (eat('+')) x += parseTerm(); // Suma
                    else if (eat('-')) x -= parseTerm(); // Resta
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (; ; ) {
                    if (eat('*')) x *= parseFactor(); // Multiplicación
                    else if (eat('/')) x /= parseFactor(); // División
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor(); // Unary plus
                if (eat('-')) return -parseFactor(); // Unary minus

                double x;
                int startPos = this.pos;
                if (eat('(')) { // Paréntesis
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // Números
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(expression.substring(startPos, this.pos));
                } else {
                    throw new RuntimeException("Número, paréntesis o operador esperado, pero se encontró: " + (char) ch);
                }

                return x;
            }
        }.parse();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SimpleController calculator = new SimpleController();
            calculator.setVisible(true);
        });
    }
}
