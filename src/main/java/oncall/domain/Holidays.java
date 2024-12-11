package oncall.domain;

public enum Holidays {
    NEW_YEAR(1, 1),
    INDEPENDENCE_DAY(3, 1),
    CHILDREN_DAY(5, 5),
    MEMORIAL_DAY(6, 6),
    LIBERATION_DAY(8, 15),
    NATIONAL_FOUNDATION_DAY(10, 3),
    HANGEUL_DAY(10, 9),
    CHRISTMAS(12, 25)
    ;

    private final int month;
    private final int day;

    Holidays(int month, int day) {
        this.month = month;
        this.day = day;
    }
}
