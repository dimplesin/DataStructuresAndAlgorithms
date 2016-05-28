package com.merchant.guide.to.galaxy.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import com.merchant.guide.to.galaxy.exception.InvalidQueryExceptionHandler;
import com.merchant.guide.to.galaxy.model.MerchantCurrency;
import com.merchant.guide.to.galaxy.service.MerchantGuideToGalaxyMethods;
import com.merchant.guide.to.galaxy.service.MerchantGuideToGalaxyMethodsImpl;
import org.apache.commons.lang.StringUtils;
import org.slf4j.LoggerFactory;

/**
 * Created by v-dsindhi on 5/10/15.
 */
public class MerchantGuideToGalaxy {

    private final static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(MerchantGuideToGalaxy.class);
    private static HashMap<String, String> transactionMap = new HashMap<String, String>();
    private static HashMap<String, Double> currencyMap = new HashMap<String, Double>();
    MerchantCurrency merchantCurrency = new MerchantCurrency();

    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        MerchantGuideToGalaxy merchantGuideToGalaxy = new MerchantGuideToGalaxy();
        MerchantGuideToGalaxyMethods merchantGuideToGalaxyMethods = new MerchantGuideToGalaxyMethodsImpl();
        try {
            //Reading file through BufferedReader.
            bufferedReader = new BufferedReader(new FileReader("inputForMerchantGuideToGalaxy.txt"));
            String fileInputLine = bufferedReader.readLine();
            while (fileInputLine != null) {
                //Check for the desired output by getting values for each line in File.
                String outputForFile = merchantGuideToGalaxy.getValuesForEachLineInFile(fileInputLine,
                                       merchantGuideToGalaxyMethods,
                                       merchantGuideToGalaxyMethods.checkPatternMatch(fileInputLine));
                //Checking if output is not empty then print it to the console.
                if(!StringUtils.isEmpty(outputForFile)) {
                    System.out.println(outputForFile);
                }
                //Reading next line from the file.
                fileInputLine = bufferedReader.readLine();
            }
        } catch (FileNotFoundException ex) {
            LOGGER.error("File was not Found in the classpath.", ex);
        }catch (IOException ex) {
            LOGGER.error("Unable to handle input and output for file", ex);
        }
        finally {
            try {
                bufferedReader.close();
            } catch (IOException ex) {
                LOGGER.error("Unable to handle input and output for file when closing bufferreader", ex);
            }
        }
    }

    public String getValuesForEachLineInFile(String fileInputLine,
                                           MerchantGuideToGalaxyMethods merchantGuideToGalaxyMethods,
                                           String patternMatchCheck) {
        String resultantOutput = null;
        switch(patternMatchCheck){
            case "assignment": {
                //Assigning Values giving the file.
                merchantGuideToGalaxyMethods.assigmentOfValues(fileInputLine, transactionMap);
                break;
            }
            case "credits": {
                //Assigning Credits given in the file.
                merchantGuideToGalaxyMethods.evaluationOfCredits(fileInputLine, merchantCurrency, transactionMap, currencyMap);
                break;
            }
            case "howmany": {
                //Calculation for how many.
                resultantOutput = merchantGuideToGalaxyMethods.evaluationOfHowMany(fileInputLine, merchantCurrency, transactionMap, currencyMap);
                break;
            }
            case "howmuch": {
                //Calculating for how much.
                resultantOutput =  merchantGuideToGalaxyMethods.evaluationOfHowMuch(fileInputLine, merchantCurrency, transactionMap, currencyMap);
                break;
            }default: {
                //If none of the case matches then error message is returned.
                return new InvalidQueryExceptionHandler().getErrMsg();
            }
        }
        return resultantOutput;
    }
}
