package factoria5.javamasa;

import factoria5.javamasa.Controller.BMIController;
import factoria5.javamasa.View.BMIView;

public class App {
    public static void main(String[] args) {
        BMIView view = new BMIView();
        BMIController controller = new BMIController(view);

        controller.start();

        view.close();
    }
}
