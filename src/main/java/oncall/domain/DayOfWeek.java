package oncall.domain;

import oncall.util.ErrorMessage;

public enum DayOfWeek {
    MON("월", false),
    TUE("화", false),
    WED("수", false),
    THD("목", false),
    FRI("금", false),
    SAT("토", true),
    SUN("일", true)
    ;

    private final String name;
    private final boolean isWeekend;

    DayOfWeek(String name, boolean isWeekend) {
        this.name = name;
        this.isWeekend = isWeekend;
    }

    public static DayOfWeek of(String name) {
        for (DayOfWeek day : DayOfWeek.values()) {
            if (day.name.equals(name)) {
                return day;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_EXCEPTION.getMessage());
    }

    public String getName() {
        return name;
    }

    public boolean isWeekend() {
        return isWeekend;
    }
}
