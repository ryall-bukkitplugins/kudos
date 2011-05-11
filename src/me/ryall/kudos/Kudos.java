package me.ryall.kudos;

import me.ryall.kudos.api.KudosInterface;
import me.ryall.kudos.communication.CommunicationManager;
import me.ryall.kudos.listeners.ServerListener;
import me.ryall.kudos.settings.ConfigManager;
import me.ryall.kudos.settings.PermissionManager;
import me.ryall.kudos.system.KudosManager;

import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Kudos extends JavaPlugin
{
    public static String PLUGIN_NAME = "Kudos";
    public static String LOG_HEADER = "[" + PLUGIN_NAME + "] ";
    private static Kudos instance = null;

    private ConfigManager configManager;
    private PermissionManager permissionManager;
    private CommunicationManager communicationManager;
    private ServerListener serverListener;

    public static Kudos get()
    {
        return instance;
    }

    public static KudosInterface getInterface()
    {
        return new KudosInterface();
    }
    
    public void onEnable()
    {
        instance = this;
        
        communicationManager = new CommunicationManager();
        configManager = new ConfigManager();
        permissionManager = new PermissionManager();
        
        serverListener = new ServerListener();

        registerEvents();

        communicationManager.logInfo("Started");
    }

    public void onDisable()
    {
        communicationManager.logInfo("Stopped");
    }

    public void registerEvents()
    {
        PluginManager pm = getServer().getPluginManager();

        pm.registerEvent(Event.Type.PLUGIN_ENABLE, serverListener, Event.Priority.Monitor, this);
    }

    public boolean onCommand(CommandSender _sender, Command _command, String _label, String[] _args)
    {
        Player player = (_sender instanceof Player) ? (Player) _sender : null;
        
        return KudosManager.command(player, _label, _args);
    }
    
    public Player findPlayer(String _name)
    {
        for (World world : getServer().getWorlds())
        {
            for (Player player : world.getPlayers())
            {
                if (player.getName().equalsIgnoreCase(_name))
                    return player;
            }
        }

        return null;
    }
    
    public ConfigManager getConfigManager()
    {
        return configManager;
    }
    
    public PermissionManager getPermissionManager()
    {
        return permissionManager;
    }

    public CommunicationManager getCommunicationManager()
    {
        return communicationManager;
    }
}