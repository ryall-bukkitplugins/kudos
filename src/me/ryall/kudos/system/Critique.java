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
    
    public String getName()
    {
        return name;
    }
    
    public double getChange()
    {
        return change;
    }
    
    public String getComment()
    {
        return comment;
    }
}
