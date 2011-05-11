package me.ryall.kudos.system;

import java.util.List;

public class Reputation
{
    private String name;
    private double score;
    private List<Critique> critiques;
    
    public Reputation(String _name, double _score, List<Critique> _critiques)
    {
        name = _name;
        score = _score;
        critiques = _critiques;
    }
    
    public String getName()
    {
        return name;
    }
    
    public double getScore()
    {
        return score;
    }
    
    public List<Critique> getCritiques()
    {
        return critiques;
    }
}
