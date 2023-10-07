package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Fraction {
    private int numerator;
    private int denominator;

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}
