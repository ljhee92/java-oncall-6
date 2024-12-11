package oncall.view;

import oncall.util.ErrorMessage;
import oncall.util.InputReader;
import oncall.util.OutputWriter;
import oncall.util.Parser;

import java.util.List;
import java.util.regex.Pattern;

public class InputView implements InputReader, OutputWriter {
    private static final Pattern MONTH_AND_START_DAY_PATTERN = Pattern.compile("^([0-9])+,([가-힣])+$");
    private static final Pattern EMPLOYEES_PATTERN = Pattern.compile("^([가-힣])+(,([가-힣])+)+$");

    public List<String> requestMonthAndStartDay() {
        displayMessage("비상 근무를 배정할 월과 시작 요일을 입력하세요> ");
        String input = inputMessage();
        validateMonthAndStartDay(input);
        return Parser.parseToList(input);
    }

    private void validateMonthAndStartDay(String input) {
        validateBlank(input);

        if (!MONTH_AND_START_DAY_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_EXCEPTION.getMessage());
        }
    }

    private void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_EXCEPTION.getMessage());
        }
    }

    public List<String> requestWeekDayEmployees() {
        displayMessage("평일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
        String input = inputMessage();
        validateEmployee(input);
        return Parser.parseToList(input);
    }

    public List<String> requestHolidayEmployees() {
        displayMessage("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
        String input = inputMessage();
        validateEmployee(input);
        return Parser.parseToList(input);
    }

    private void validateEmployee(String input) {
        validateBlank(input);

        if (!EMPLOYEES_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_EXCEPTION.getMessage());
        }
    }
}
