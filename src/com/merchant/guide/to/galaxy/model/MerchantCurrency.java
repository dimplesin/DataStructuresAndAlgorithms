package com.merchant.guide.to.galaxy.model;

import java.io.Serializable;

/**
 * Created by v-dsindhi on 5/10/15.
 */
public class MerchantCurrency implements Cloneable, Serializable {

    //mechant currency to be printed on the console.
    private String merchantCurrency;

    //getting merchant's currency.
    public String getMerchantCurrency() {
        return merchantCurrency;
    }

    //setting merchant currency.
    public void setMerchantCurrency(String merchantCurrency) {
        this.merchantCurrency = merchantCurrency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MerchantCurrency that = (MerchantCurrency) o;

        return !(merchantCurrency != null ? !merchantCurrency.equals(that.merchantCurrency) : that.merchantCurrency != null);

    }

    @Override
    public int hashCode() {
        return merchantCurrency != null ? merchantCurrency.hashCode() : 0;
    }

    //Will return the currency found in input file.
    @Override
    public String toString() {
        return merchantCurrency;
    }
}
