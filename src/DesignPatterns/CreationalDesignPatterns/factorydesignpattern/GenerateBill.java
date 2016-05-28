package DesignPatterns.CreationalDesignPatterns.factorydesignpattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by v-dsindhi on 1/30/16.
 */
abstract class Plan {
    protected double rate;
    abstract void getRate();
    public void calculateBill(int units){
        System.out.println(units*rate);
    }
}

class DomesticPlan extends Plan{
    @Override
    public void getRate(){
        rate = 3.50;
    }
}

class CommercialPlan extends Plan{
    public void getRate(){
        rate=7.50;
    }
}

class InstitutionPlan extends Plan{
    public void getRate(){
        rate=5.50;
    }
}

class GetPlanFactory{
    public Plan getPlan(String planType){
        if(planType == null){
            return null;
        }
        if(planType.equalsIgnoreCase("DOMESTICPLAN")){
            return new DomesticPlan();
        }
        else if(planType.equalsIgnoreCase("COMMERCIALPLAN")){
            return new CommercialPlan();
        }
        else if (planType.equalsIgnoreCase("INSTITUTIONALPLAN")){
            return new InstitutionPlan();
        }
        return null;
    }
}

public class GenerateBill{
    public static void main(String args[]) throws IOException{
        GetPlanFactory getPlanFactory = new GetPlanFactory();
        System.out.println("Enter the name of the plan for which the bill will be generated.");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String planName = br.readLine();

        System.out.println("Enter the number of units for bill will be calculated.");
        int units = Integer.parseInt(br.readLine());

        Plan p = getPlanFactory.getPlan(planName);
        p.getRate();
        p.calculateBill(units);
    }

}