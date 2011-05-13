package me.ryall.kudos.settings;

import org.bukkit.util.config.Configuration;

import me.ryall.kudos.Kudos;

public class ConfigManager
{
    private Configuration config;

    public ConfigManager()
    {
        config = Kudos.get().getConfiguration();
        config.load();
    }

    public double getLikeMinimumReputation()
    {
        return config.getDouble("Like.MinimumRequiredReputation", 0);
    }

    public double getLikeReputationIncrease()
    {
        return config.getDouble("Like.ReputationIncrease", 1);
    }

    public double getDislikeMinimumReputation()
    {
        return config.getDouble("Dislike.MinimumRequiredReputation", 0);
    }

    public double getDislikeReputationDecrease()
    {
        return config.getDouble("Dislike.ReputationDecrease", 1);
    }
}
