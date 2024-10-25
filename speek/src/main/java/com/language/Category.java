package com.language;

public enum Category {
    NUMBERS("Numbers"),
    COLORS("Colors"),
    PEOPLE("People"),
    WEATHER("Weather"),
    PLACES("Places");

    public final String label;

    private Category(String label) {
        this.label = label;
    }

    
}
