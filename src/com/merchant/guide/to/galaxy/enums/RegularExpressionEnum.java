package com.merchant.guide.to.galaxy.enums;

/**
 * Created by v-dsindhi on 5/10/15.
 */
public enum RegularExpressionEnum {

    REGEXASSIGNMENT("^([a-z]+) is ([I|V|X|L|C|D|M])$", 1),
    REGEXCREDITS("((?:[a-z]+ )+)([A-Z]\\w+) is (\\d+) ([A-Z]\\w+)$", 2),
    REGEXHOWMANY("^how many ([a-zA-Z]\\w+) is ((?:\\w+ )+)([A-Z]\\w+) \\?$", 3),
    REGEXHOWMUCH("^how much is ((?:\\w+[^0-9] )+)\\?$", 4);

    private final int index;
    private final String regularExpType;

    RegularExpressionEnum(String regularExpType, int index)
    {
        this.regularExpType = regularExpType;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public String getRegularExpType() {
        return regularExpType;
    }
}
