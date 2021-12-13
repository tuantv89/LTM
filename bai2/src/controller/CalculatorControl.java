package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.CalculatorModel;
import view.CalculatorView;

/**
 *
 * @author Thiều Văn Tuấn
 */
public class CalculatorControl {

    private CalculatorView view;
    private CalculatorModel model;

    public CalculatorControl(CalculatorView view) {
        this.view = view;
        view.addButtonCalculateListener(new CalculatorListener());
        view.addButton0Listener((e) -> {
            String text = view.getText();
            text += "0";
            view.setText(text);
        });
        view.addButton1Listener((e) -> {
            String text = view.getText();
            text += "1";
            view.setText(text);
        });
        view.addButton2Listener((e) -> {
            String text = view.getText();
            text += "2";
            view.setText(text);
        });
        view.addButton3Listener((e) -> {
            String text = view.getText();
            text += "3";
            view.setText(text);
        });
        view.addButton4Listener((e) -> {
            String text = view.getText();
            text += "4";
            view.setText(text);
        });
        view.addButton5Listener((e) -> {
            String text = view.getText();
            text += "5";
            view.setText(text);
        });
        view.addButton6Listener((e) -> {
            String text = view.getText();
            text += "6";
            view.setText(text);
        });
        view.addButton7Listener((e) -> {
            String text = view.getText();
            text += "7";
            view.setText(text);
        });
        view.addButton8Listener((e) -> {
            String text = view.getText();
            text += "8";
            view.setText(text);
        });
        view.addButton9Listener((e) -> {
            String text = view.getText();
            text += "9";
            view.setText(text);
        });
        view.addButtonDotListener((e) -> {
            String text = view.getText();
            text += ".";
            view.setText(text);
        });
        view.addButtonClearListener((e) -> {
            view.setText("");
        });
        view.addButtonAddListener((e) -> {
            if (!isValid()) {
                return;
            }
            String text = view.getText();
            text += "+";
            view.setText(text);
        });
        view.addButtonSubListener((e) -> {
            if (!isValid()) {
                return;
            }
            String text = view.getText();
            text += "-";
            view.setText(text);
        });
        view.addButtonMultiListener((e) -> {
            if (!isValid()) {
                return;
            }
            String text = view.getText();
            text += "*";
            view.setText(text);
        });
        view.addButtonDivideListener((e) -> {
            if (!isValid()) {
                return;
            }
            String text = view.getText();
            text += "/";
            view.setText(text);
        });
    }

    public boolean isValid() {
        String text = view.getText();
        for (int i = 0; i < text.length(); i++) {
            if (i > 0 && Character.isDigit(text.charAt(i - 1)) && text.charAt(i) != '.' && !Character.isDigit(text.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public String[] getResult() {
        try {
            model = view.getCalculatorModel();
            Double firstNumber = model.getFirstNumber();
            Double secondNumber = model.getSecondNumber();
            char operator = model.getOperator();
            if (operator == '+') {
                Double answer = firstNumber + secondNumber;
                String a[] = {"true", String.valueOf(answer)};
                return a;
            } else if (operator == '-') {
                Double answer = firstNumber - secondNumber;
                String a[] = {"true", String.valueOf(answer)};
                return a;
            } else if (operator == '*') {
                Double answer = firstNumber * secondNumber;
                String a[] = {"true", String.valueOf(answer)};
                return a;
            } else if (operator == '/') {
                if (secondNumber.equals(new Double(0))) {
                    String a[] = {"false", "0.0"};
                    return a;
                } else {
                    Double answer = firstNumber / secondNumber;
                    String a[] = {"true", String.valueOf(answer)};
                    return a;
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        String a[] = {"false", "0.0"};
        return a;
    }

    class CalculatorListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
//                if (isValid()) {
//                    return;
//                }
                String ans[] = getResult();
                if (ans[0].equals("false")) {
                    view.shoMessage("Lỗi");
                    return;
                } else {
                    view.setText(ans[1]);
                }
            } catch (Exception ex) {
                view.shoMessage(ex.toString());
            }
        }
    }
}
