package me.ryall.kudos.api;

import me.ryall.kudos.system.KudosManager;
import me.ryall.kudos.system.Reputation;

public class KudosInterface
{
    public double getReputation(String _playerName)
    {
        Reputation reputation = KudosManager.find(_playerName);
        
        return reputation == null ? 0 : reputation.getScore();
    }
    
    public boolean hasEnoughReputation(String _playerName, int _requiredReputation)
    {
        return getReputation(_playerName) >= _requiredReputation;
    }
}
