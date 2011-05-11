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
}
