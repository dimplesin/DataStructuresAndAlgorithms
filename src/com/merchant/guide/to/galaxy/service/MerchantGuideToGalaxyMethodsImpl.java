package com.merchant.guide.to.galaxy.service;

import com.merchant.guide.to.galaxy.enums.RegularExpressionEnum;
import com.merchant.guide.to.galaxy.enums.RomanSymbolValueEnum;
import com.merchant.guide.to.galaxy.exception.InvalidQueryExceptionHandler;
import com.merchant.guide.to.galaxy.model.MerchantCurrency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by v-dsindhi on 5/10/15.
 */
public class MerchantGuideToGalaxyMethodsImpl implements MerchantGuideToGalaxyMethods {

    @Override
    public String checkPatternMatch(String matchPattern){
        //Setting the default value error in case none of the Regular expression matches.
        String patternMatchForLine = new InvalidQueryExceptionHandler().getErrMsg();

        //Creating array of string for pattern matching
        String[] regularExpressionList = new String[]{RegularExpressionEnum.REGEXASSIGNMENT.getRegularExpType(),
                                        RegularExpressionEnum.REGEXCREDITS.getRegularExpType(),
                                        RegularExpressionEnum.REGEXHOWMANY.getRegularExpType(),
                                        RegularExpressionEnum.REGEXHOWMUCH.getRegularExpType()};
        for(int i = 0;i<regularExpressionList.length;i++){
            Pattern patternToCompile = Pattern.compile(regularExpressionList[i]);

            //Matching the pattern received from file in a line.
            Matcher patternMatcher = patternToCompile.matcher(matchPattern);
            if(patternMatcher.matches()){
                switch(i){
                    case 0:
                        patternMatchForLine = "assignment";
                        break;
                    case 1:
                        patternMatchForLine = "credits";
                        break;
                    case 2:
                        patternMatchForLine = "howmany";
                        break;
                    case 3:
                        patternMatchForLine = "howmuch";
                        break;
                    default:
                        break;
                }
            }
        }
        return patternMatchForLine;
    }

    @Override
    public int getValueByRomanSymbol(String romanSymbol) {
        //Method to return the value of Roman Symbol.
        switch(romanSymbol){
            case "I":
                return RomanSymbolValueEnum.I.getValueOfSymbol();
            case "V":
                return RomanSymbolValueEnum.V.getValueOfSymbol();
            case "X":
                return RomanSymbolValueEnum.X.getValueOfSymbol();
            case "L":
                return RomanSymbolValueEnum.L.getValueOfSymbol();
            case "C":
                return RomanSymbolValueEnum.C.getValueOfSymbol();
            case "D":
                return RomanSymbolValueEnum.D.getValueOfSymbol();
            case "M":
                return RomanSymbolValueEnum.M.getValueOfSymbol();
            default:
                return 0;
        }
    }

    @Override
    public int getTransactionValue(String[] transactionsList, HashMap<String, String> transactionMap){
        int romanSymbolValues = 0;
        List<String> romanSymbols = new ArrayList<String>();
        StringBuffer stringBuffer = new StringBuffer();
        for(int i=0;i<transactionsList.length;i++){
            //Checking if the transaction map contains the key like glob, etc.
            if(!transactionMap.keySet().contains(transactionsList[i])){
                System.out.println(new InvalidQueryExceptionHandler().getErrMsg());
                return 0;
            }
            //Adding the words that corresponds to question in order to check succession.
            stringBuffer.append(transactionsList[i]+" ");
            //Adding the roman symbols based on the assignments given in file.
            romanSymbols.add(transactionMap.get(transactionsList[i]));
        }

        //Matching pattern to check succession of the words.
        Matcher m = Pattern.compile("(.+)\\1+").matcher(stringBuffer.toString());
        while (m.find()) {
           String[] splitToSpace = m.group().split(" ");
            if(splitToSpace.length >3){
                //If succession of the words is more than 3 times then returning an error.
                System.out.println(new InvalidQueryExceptionHandler().getErrMsg());
                return 0;
            }
        }

        List<Integer> sourceList = new ArrayList<Integer>();
        for(String romanSymbol : romanSymbols){
            //Adding values of roman symbols in sourcelist.
            sourceList.add(getValueByRomanSymbol(romanSymbol));
        }

        //Calculating the expression as per the input given.
        List<Integer> newSoruceList = substractSmallerValueFromLargerValue(sourceList);
        for(int i : newSoruceList){
            romanSymbolValues+=i;
        }

        LOGGER.info("roman symbol value for transaction is : "+romanSymbolValues);
        return romanSymbolValues;
    }

    @Override
    public List<Integer> substractSmallerValueFromLargerValue(List<Integer> numberValues) {
        int currentRomanValue;
        for(int i = 0 ; i < numberValues.size() -1; i++)
        {
            currentRomanValue = numberValues.get(i);
            //checking if roman value is less than its successive one.
            if( currentRomanValue < numberValues.get(i+1))
            {
                //if yes the returning negative value so that it can be substracted.
                numberValues.set(i, -currentRomanValue);
            }
        }
        LOGGER.info("Value to be added or subtracted are : " + numberValues);
        return numberValues;
    }

    @Override
    public void assigmentOfValues(String fileInputLine, HashMap<String, String> transactionMap) {
        //Assigning values in the transaction map.
        Pattern patternToCompile = Pattern.compile(RegularExpressionEnum.REGEXASSIGNMENT.getRegularExpType());
        Matcher patternMatcher = patternToCompile.matcher(fileInputLine);
        patternMatcher.matches();
        String romanName = patternMatcher.group(1).trim();
        String romanSymbol = patternMatcher.group(2).trim();
        if (!transactionMap.containsKey(romanName)) {
            transactionMap.put(romanName, romanSymbol);
        }
        LOGGER.info("Assigned Values for roman name and symbol are : "+transactionMap);
    }

    @Override
    public void evaluationOfCredits(String fileInputLine,
                                    MerchantCurrency merchantCurrency,
                                    HashMap<String, String> transactionMap,
                                    HashMap<String, Double> currencyMap) {

        //Evaluating credits and putting them in a map.
        Pattern patternToCompile = Pattern.compile(RegularExpressionEnum.REGEXCREDITS.getRegularExpType());
        Matcher patternMatcher = patternToCompile.matcher(fileInputLine);
        patternMatcher.matches();

        merchantCurrency.setMerchantCurrency(patternMatcher.group(4).trim());

        String[] transactionList = patternMatcher.group(1).split(" ");
        int transactionValue = getTransactionValue(transactionList, transactionMap);
        String currency = patternMatcher.group(2);
        int credits = Integer.parseInt(patternMatcher.group(3).trim());
        double value = credits / transactionValue;
        currencyMap.put(currency, value);
        LOGGER.info("Credites evaluated are : "+currencyMap);
    }

    @Override
    public String evaluationOfHowMany(String fileInputLine,
                                      MerchantCurrency merchantCurrency,
                                      HashMap<String, String> transactionMap,
                                      HashMap<String, Double> currencyMap) {
        //Calculating credits for How Many Question asked
        String resultantOutput = null;
        Pattern patternToCompile = Pattern.compile(RegularExpressionEnum.REGEXHOWMANY.getRegularExpType());
        Matcher patternMatcher = patternToCompile.matcher(fileInputLine);
        patternMatcher.matches();

        if (!merchantCurrency.getMerchantCurrency().equals(patternMatcher.group(1))) {
            LOGGER.error("Error Found as Mechant currency is not equal to actual currency.");
            System.out.println(new InvalidQueryExceptionHandler().getErrMsg());
        }

        String[] transactionList = patternMatcher.group(2).split(" ");
        int transactionValue = getTransactionValue(transactionList, transactionMap);

        String currency = patternMatcher.group(3).trim();
        double value = 0;
        for (String k : currencyMap.keySet()) {
            if (k.equals(currency)) {
                value = currencyMap.get(k);
            }
        }

        double total = transactionValue * value;
        if (total != 0) {
            //Result that will be displayed on console for How Many Question with merchant currency
            resultantOutput = patternMatcher.group(2) + patternMatcher.group(3) + " is " + (long) total + " " + merchantCurrency;
        }
        LOGGER.info("Result for How Many Question :"+resultantOutput);
        return resultantOutput;
    }

    @Override
    public String evaluationOfHowMuch(String fileInputLine,
                                      MerchantCurrency merchantCurrency,
                                      HashMap<String, String> transactionMap,
                                      HashMap<String, Double> currencyMap) {
        //Calculating value for How much Questions.
        String resultantOutput = null;
        Pattern patternToCompile = Pattern.compile(RegularExpressionEnum.REGEXHOWMUCH.getRegularExpType());
        Matcher patternMatcher = patternToCompile.matcher(fileInputLine);
        patternMatcher.matches();

        String[] transactionList = patternMatcher.group(1).split(" ");
        int transactionValue = getTransactionValue(transactionList, transactionMap);
        if (transactionValue != 0) {
            //Result that will be displayed on console for How Much Question
            resultantOutput = patternMatcher.group(1) + "is " + transactionValue;
        }
        LOGGER.info("Result for How Much Questions : "+resultantOutput);
        return resultantOutput;
    }
}
