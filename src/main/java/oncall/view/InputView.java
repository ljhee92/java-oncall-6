package oncall.view;

import oncall.util.ErrorMessage;
import oncall.util.InputReader;
import oncall.util.OutputWriter;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class InputView implements InputReader, OutputWriter {
    private static final Pattern MONTH_AND_START_DAY_PATTERN = Pattern.compile("^([0-9])+,([가-힣])+$");

    public List<String> requestMonthAndStartDay() {
        displayMessage("비상 근무를 배정할 월과 시작 요일을 입력하세요> ");
        String input = inputMessage();
        validateMonthAndStartDay(input);
        return parseInput(input);
    }

    private void validateMonthAndStartDay(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_EXCEPTION.getMessage());
        }

        if (!MONTH_AND_START_DAY_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_EXCEPTION.getMessage());
        }
    }

    private List<String> parseInput(String input) {
        return Arrays.stream(input.split(",")).toList();
    }
}
