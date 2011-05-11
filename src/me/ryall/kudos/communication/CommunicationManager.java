package me.ryall.kudos.communication;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;

import me.ryall.kudos.Kudos;

public class CommunicationManager
{
    public static String MESSAGE_HEADER = ChatColor.WHITE + "[" + ChatColor.GOLD + Kudos.PLUGIN_NAME + ChatColor.WHITE + "] " + ChatColor.WHITE;
    
    private Logger log;
    
    public CommunicationManager()
    {
        log = Logger.getLogger("Minecraft");
    }
    
    public void message(Player _player, String _message)
    {
        if (_player != null)
            _player.sendMessage(MESSAGE_HEADER + _message);
        else
            logInfo(_message);
    }

    public void error(Player _player, String _message)
    {
        if (_player != null)
            _player.sendMessage(MESSAGE_HEADER + ChatColor.RED + "Error: " + _message);
        else
            logError(_message);
    }

    public void command(Player _player, String _command, String _description)
    {
        if (_player != null)
            _player.sendMessage(MESSAGE_HEADER + ChatColor.GOLD + _command + ChatColor.WHITE + ": " + _description);
    }

    public void broadcast(Player _except, String _message)
    {
        for (World world : Kudos.get().getServer().getWorlds())
        {
            for (Player player : world.getPlayers())
            {
                if (_except == null || !_except.getName().equals(player.getName()))
                    message(player, _message);
            }
        }
    }
    
    public void logInfo(String _message)
    {
        log.info(Kudos.LOG_HEADER + _message);
    }

    public void logError(String _message)
    {
        log.severe(Kudos.LOG_HEADER + _message);
    }
}
