package enums;

public enum States {
    PENDING(1),
    IN_PROGRESS(2),
    COMPLETED(3);

    private int code;

    States(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static States fromCode(int code) {
        for (States p : values()) {
            if (p.code == code) {
                return p;
            }
        }
        throw new IllegalArgumentException("Código inválido: " + code);
    }
}
