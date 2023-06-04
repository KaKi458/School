package com.school.model;

public enum MarkValue {
    CEL(6),
    BDB(5),
    DB(4),
    DST(3),
    DOP(2),
    NDST(1);

    private final int value;

    MarkValue(int value) {
        this.value = value;
    }

    public static MarkValue fromValue(int value) {
        for (MarkValue mv : MarkValue.values()) {
            if (value == mv.getValue()) {
                return mv;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public int getValue() {
        return value;
    }

}
