package com.merchant.guide.to.galaxy.enums;

/**
 * Created by v-dsindhi on 5/10/15.
 */
public enum RomanSymbolValueEnum {

    I(1),
    V(5),
    X(10),
    L(50),
    C(100),
    D(500),
    M(1000);

    private final int valueOfSymbol;

    RomanSymbolValueEnum(int valueOfSymbol)
    {
        this.valueOfSymbol = valueOfSymbol;
    }

    public int getValueOfSymbol() {
        return valueOfSymbol;
    }
}
