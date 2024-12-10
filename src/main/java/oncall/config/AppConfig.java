package oncall.config;

import oncall.controller.OnCallController;
import oncall.view.InputView;
import oncall.view.OutputView;

public class AppConfig {
    public OnCallController onCallController() {
        return new OnCallController(inputView(), outputView());
    }

    private InputView inputView() {
        return new InputView();
    }

    private OutputView outputView() {
        return new OutputView();
    }
}
