package Lab11;
/**
 *
 * @author Atahan Ekici
 */
public class Student
{
    private int examScore;
    private String name;
    
    public Student(int score, String name)
    {
        this.name = name;
        this.examScore = score;
    }
    
    public Student()
    {
        this.name = "Unknown";
        this.examScore = 0;
    }
    
    public void setScore(int score)
    {
        this.examScore = score;
    }
    public int getScore()
    {
        return this.examScore;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return this.name;
    }
    
    @Override
    public String toString() 
{ 
    return this.display();
} 
    
    public String display()
    {
        return String.format("Name: "+this.name+"\nExam Score: "+this.examScore+"");
    }
}