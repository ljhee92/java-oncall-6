package oncall.util;

public enum ErrorMessage {
    INVALID_INPUT_EXCEPTION("유효하지 않은 입력 값입니다. 다시 입력해 주세요.")
    ;

    private static final String prefix = "[ERROR] ";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return prefix + message;
    }
}
