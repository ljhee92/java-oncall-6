package oncall.controller;

import oncall.domain.DayOfWeek;
import oncall.domain.Month;
import oncall.domain.Schedule;
import oncall.util.Parser;
import oncall.util.RetryHandler;
import oncall.view.InputView;
import oncall.view.OutputView;

import java.util.List;

public class OnCallController {
    private final InputView inputView;
    private final OutputView outputView;

    public OnCallController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Schedule schedule = RetryHandler.repeat(this::getSchedule);
    }

    public Schedule getSchedule() {
        List<String> input = inputView.requestMonthAndStartDay();
        return Schedule.of(Month.of(Parser.parseInt(input.get(0))), DayOfWeek.of(input.get(1)));
    }
}
