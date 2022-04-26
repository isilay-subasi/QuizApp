package com.isilsubasi.quizapp.util;

public enum Screens {

    WRONG(0),
    WİNNER(1);
    private final int value;

    Screens(final int newValue) {
        value = newValue;
    }

    public int getValue() { return value; }



}
