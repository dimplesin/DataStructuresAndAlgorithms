package DesignPatterns.CreationalDesignPatterns.PrototypeDesignPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by v-dsindhi on 1/30/16.
 */

interface Prototype{
    public Prototype getClone();
}

class EmployeeRecord implements Prototype{
    private int id;
    private String name, designation;
    private double salary;
    private String address;

    public EmployeeRecord(){
        System.out.println(" Employee Records of Oracle Corporation ");
        System.out.println(" -------------------------------------- ");
        System.out.println("Eid:"+"\t"+"Ename"+"\t"+"Edesignation"+"\t"+"ESalary"+"\t"+"EAddress");
    }

    public EmployeeRecord(int id, String name, String designation, double salary, String address) {
        this();
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
        this.address = address;
    }

    public void showRecord() {
        System.out.println(
                "id=" + id +
                ", name='" + name + '\'' +
                ", designation='" + designation + '\'' +
                ", salary=" + salary +
                ", address='" + address + '\'');
    }

    @Override
    public Prototype getClone(){
        return new EmployeeRecord(id,name,designation,salary,address);
    }
}

public class PrototypeDemo {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter Employee Id:");
        int id = Integer.parseInt(br.readLine());
        System.out.println();

        System.out.print("Enter Employee Name:");
        String employeeName = br.readLine();
        System.out.println();

        System.out.print("Enter Employee Designation:");
        String designation = br.readLine();
        System.out.println();

        System.out.print("Enter Employee Address:");
        String address = br.readLine();
        System.out.println();

        System.out.print("Enter Employee Salary:");
        double salary = Double.parseDouble(br.readLine());
        System.out.println();

        EmployeeRecord e1 = new EmployeeRecord(id,employeeName, designation, salary, address);

        e1.showRecord();
        System.out.println();
        EmployeeRecord e2 = (EmployeeRecord)e1.getClone();
        e2.showRecord();
    }
}
