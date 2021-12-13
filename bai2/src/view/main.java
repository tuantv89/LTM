package view;

/**
 *
 * @author Thiều Văn Tuấn
 */
import controller.CalculatorControl;
import model.CalculatorModel;

public class main {

    public static void main(String[] args) {
        CalculatorModel model = new CalculatorModel();
        CalculatorView view = new CalculatorView(model);
        CalculatorControl control = new CalculatorControl(view);
        view.setVisible(true);
    }
}
