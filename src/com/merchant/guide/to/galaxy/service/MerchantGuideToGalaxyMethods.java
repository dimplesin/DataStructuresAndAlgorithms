package com.merchant.guide.to.galaxy.service;

import com.merchant.guide.to.galaxy.model.MerchantCurrency;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;

/**
 * Created by v-dsindhi on 5/10/15.
 */
public interface MerchantGuideToGalaxyMethods {

    public final static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(MerchantGuideToGalaxyMethods.class);

    //Method to return Matching pattern received from file in a line.
    public String checkPatternMatch(String matchPattern);

    //Method to return the value of Roman Symbol.
    public int getValueByRomanSymbol(String romanSymbol);

    //Calculates the expression as per the input given.
    public int getTransactionValue(String[] transactionsList, HashMap<String, String> transactionMap);

    //Checks if roman value is less than its successive one. If yes then return it with - sign
    public List<Integer> substractSmallerValueFromLargerValue(List<Integer> numberValues);

    //Assigns values in the transaction map.
    public void assigmentOfValues(String fileInputLine, HashMap<String, String> transactionMap);

    //Evaluates credits and put them in a map.
    public void evaluationOfCredits(String fileInputLine,
                             MerchantCurrency merchantCurrency,
                             HashMap<String, String> transactionMap,
                             HashMap<String, Double> currencyMap);

    //Calculates credits for How Many Question.
    public String evaluationOfHowMany(String fileInputLine,
                               MerchantCurrency merchantCurrency,
                               HashMap<String, String> transactionMap,
                               HashMap<String, Double> currencyMap);

    //Calculates value for How much Questions.
    public String evaluationOfHowMuch(String fileInputLine,
                               MerchantCurrency merchantCurrency,
                               HashMap<String, String> transactionMap,
                               HashMap<String, Double> currencyMap);

}
