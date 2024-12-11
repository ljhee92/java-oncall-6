package oncall.controller;

import oncall.domain.DayOfWeek;
import oncall.domain.Employees;
import oncall.domain.HolidayEmployees;
import oncall.domain.Month;
import oncall.domain.Schedule;
import oncall.domain.Scheduler;
import oncall.domain.WeekdayEmployees;
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
        List<Employees> employees = RetryHandler.repeat(this::getEmployees);
        Scheduler scheduler = Scheduler.create(schedule, employees);
        outputView.displayResult(scheduler);
    }

    private Schedule getSchedule() {
        List<String> input = inputView.requestMonthAndStartDay();
        return Schedule.of(Month.of(Parser.parseToInt(input.get(0))), DayOfWeek.of(input.get(1)));
    }

    private List<Employees> getEmployees() {
        Employees weekdaysEmployees = WeekdayEmployees.of(inputView.requestWeekDayEmployees());
        Employees holidayEmployees = HolidayEmployees.of(inputView.requestHolidayEmployees(), weekdaysEmployees);
        return List.of(weekdaysEmployees, holidayEmployees);
    }
}
