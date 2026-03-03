package enums;

public enum Priority {
    LOW(1),
    MEDIUM(2),
    HIGH(3);

    private int code;

    Priority(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static Priority fromCode(int code) {
        for (Priority p : values()) {
            if (p.code == code) {
                return p;
            }
        }
        throw new IllegalArgumentException("Código inválido: " + code);
    }
}
