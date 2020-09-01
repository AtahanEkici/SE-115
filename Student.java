/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Atahan Ekici
 */
public class Student 
{
    private int Student_number;
    private String Student_name;
    private double avg_grade;
    
    
    public Student(int number,String name,double avg)
    {
        this.Student_number = number;
        this.Student_name = name;
        this.avg_grade = avg;
    }
    
    public void setName(String name)
    {
        this.Student_name = name;
    }
    
    public String getName()
    {
        return this.Student_name;
    }
    
    public void setNumber(int number)
    {
        this.Student_number = number;
    }
    
    public int getNumber()
    {
        return this.Student_number;
    }
    
    public void setGrade(double avg)
    {
        this.avg_grade = avg;
    }
    
    public double getGrade()
    {
        return this.avg_grade;
    }
    
    public void display()
    {
        System.out.println(Student_number);
        System.out.println(Student_name);
        System.out.println(avg_grade);
    }
}
