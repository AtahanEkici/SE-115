package Lab7;

import java.util.Scanner;

/**
 *
 * @author Atahan Ekici
 */
public class Lab7
{
    private int ID;
    private String name;
    private double salary;
    
    public Employee(int ID , String name , double salary)
    {
        this.ID = ID;
        this.name = name;
        this.salary = salary;
    }
    
    public Employee()
    {
        this.ID = 1;
        this.name = "Unknown";
        this.salary = 0.0;
    }
     
    public int getID()
    {
        return this.ID;
    }
    public void setID(int ID)
    {
        this.ID = ID;
    }
    
    public String getName()
    {
        return this.name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    
    public double getSalary()
    {
        return this.salary;
    }
    public void setSalary(double salary)
    {
        this.salary = salary;
    }
    
    public void display()
    {
        System.out.println(String.format("\n------------\nID: %s\nName: %s\nSalary: %s\n------------\n", this.ID,this.name,this.salary));
    }
    
    
     public static void main(String[] args)
    {
        Employee E1 = new Employee();
        Scanner scanned;
        
        System.out.println("Please specify the ID of the Employee");
        scanned = new Scanner(System.in);
        E1.setID(scanned.nextInt());
        
        System.out.println("Please specify the Name of the Employee");
        scanned = new Scanner(System.in);
        E1.setName(scanned.nextLine());
        
        System.out.println("Please specify the Salary of the Employee");
        scanned = new Scanner(System.in);
        E1.setSalary(scanned.nextDouble());
        
        E1.display();
    }
}
