package me.ryall.kudos.system;

public class Critique
{
    private String name;
    private double change;
    private String comment;
    
    public Critique(String _name, double _change, String _comment)
    {
        name = _name;
        change = _change;
        comment = _comment;
    }
    
    public void setName(String _name)
    {
        name = _name;
    }

    public String getName()
    {
        return name;
    }
    
    public void setChange(double _change)
    {
        change = _change;
    }
    
    public double getChange()
    {
        return change;
    }
    
    public String getComment()
    {
        return comment;
    }
    
    public void setComment(String _comment)
    {
        comment = _comment;
    }
}
