package me.ryall.kudos.system;

import java.util.List;

import org.bukkit.entity.Player;

public class Reputation
{
    private String name;
    private double score;
    private List<Review> reviews;
    
    public Reputation(String _name, double _score, List<Review> _critiques)
    {
        name = _name;
        score = _score;
        reviews = _critiques;
    }
    
    public void setName(String _name)
    {
        name = _name;
    }

    
    public String getName()
    {
        return name;
    }
    
    public void setScore(double _score)
    {
        score = _score;
    }
    
    public double getScore()
    {
        return score;
    }
    
    public void setReviews(List<Review> _reviews)
    {
        reviews = _reviews;
    }
    
    public List<Review> getReviews()
    {
        return reviews;
    }

    public void review(Player _reviewer, double _change, String _comment)
    {
        removeReview(_reviewer);
        
        score += _change;
        reviews.add(new Review(_reviewer.getName(), _change, _comment));
    }

    public void removeReview(Player _reviewer)
    {
        for (Review review : reviews)
        {
            if (review.getName().equals(_reviewer.getName()))
            {
                score -= review.getChange();
                reviews.remove(review);
                
                return;
            }
        }
    }
}
