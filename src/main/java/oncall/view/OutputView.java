package oncall.view;

import oncall.domain.Scheduler;
import oncall.util.OutputWriter;

public class OutputView implements OutputWriter {
    public void displayResult(Scheduler scheduler) {
        displayNewLine();
        for (int i = 1; i <= scheduler.getLastDay(); i++) {
            displayFormat("%s월 %s일 %s %s", scheduler.getMonth(), i,
                    scheduler.getDayOfWeek(i), scheduler.getAssignedEmployees(i));
        }
    }
}
