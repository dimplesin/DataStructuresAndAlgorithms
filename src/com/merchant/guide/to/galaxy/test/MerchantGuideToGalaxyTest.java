package com.merchant.guide.to.galaxy.test;

import com.merchant.guide.to.galaxy.service.MerchantGuideToGalaxyMethods;
import com.merchant.guide.to.galaxy.main.MerchantGuideToGalaxy;
import com.merchant.guide.to.galaxy.service.MerchantGuideToGalaxyMethodsImpl;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static junit.framework.Assert.assertEquals;

/**
 * Created by v-dsindhi on 5/10/15.
 */
public class MerchantGuideToGalaxyTest {

    MerchantGuideToGalaxy merchantGuideToGalaxy = new MerchantGuideToGalaxy();
    MerchantGuideToGalaxyMethods merchantGuideToGalaxyMethods = new MerchantGuideToGalaxyMethodsImpl();
    BufferedReader bufferedReader = null;
    private final static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(MerchantGuideToGalaxy.class);

    //When smaller values precede larger values, the smaller values are subtracted from the larger values, and the result is added to the total. For example MCMXLIV = 1000 + (1000 − 100) + (50 − 10) + (5 − 1) = 1944.
    @Test
    public void substractionTestForSmallAndLargeValues(){
        try {
            bufferedReader = new BufferedReader(new FileReader("inputForTestSubstract.txt"));
            String fileInputLine = bufferedReader.readLine();
            while (fileInputLine != null) {
                String patternMatchCheck = merchantGuideToGalaxyMethods.checkPatternMatch(fileInputLine);
                String outputFromFile = merchantGuideToGalaxy.getValuesForEachLineInFile(fileInputLine, merchantGuideToGalaxyMethods, patternMatchCheck);
                if(!StringUtils.isEmpty(outputFromFile)){
                    String[] totalAmountToCheck = outputFromFile.split(" ");
                    assertEquals("44", totalAmountToCheck[totalAmountToCheck.length - 1]);
                }
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

    //The symbols "I", "X", "C", and "M" can be repeated three times in succession, but no more.
    @Test
    public void successionTestCaseForSymbols(){
        try {
            bufferedReader = new BufferedReader(new FileReader("inputTestForSuccessionOfSymbols.txt"));
            String fileInputLine = bufferedReader.readLine();
            while (fileInputLine != null) {
                String patternMatchCheck = merchantGuideToGalaxyMethods.checkPatternMatch(fileInputLine);
                String outputFromFile = merchantGuideToGalaxy.getValuesForEachLineInFile(fileInputLine, merchantGuideToGalaxyMethods, patternMatchCheck);
                if(!StringUtils.isEmpty(outputFromFile)){
                    if(outputFromFile.contains("39")) {
                        String[] totalAmountToCheck = outputFromFile.split(" ");
                        assertEquals("39", totalAmountToCheck[totalAmountToCheck.length - 1]);
                    }
                    //For first how much question the output is on console as I have no idea what you are talking about.
                }
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

    //Check if merchant currency is printed at the last
    @Test
    public void merchantCurrencyCheckForTest() {
        try {
            bufferedReader = new BufferedReader(new FileReader("inputForTestForMerchantCurrency.txt"));
            String fileInputLine = bufferedReader.readLine();
            while (fileInputLine != null) {
                String patternMatchCheck = merchantGuideToGalaxyMethods.checkPatternMatch(fileInputLine);
                String outputFromFile = merchantGuideToGalaxy.getValuesForEachLineInFile(fileInputLine, merchantGuideToGalaxyMethods, patternMatchCheck);
                if (!StringUtils.isEmpty(outputFromFile)) {
                    String[] totalAmountToCheck = outputFromFile.split(" ");
                    assertEquals("Credits", totalAmountToCheck[totalAmountToCheck.length - 1]);
                }
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
}
