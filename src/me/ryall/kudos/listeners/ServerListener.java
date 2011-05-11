package me.ryall.kudos.listeners;

import me.ryall.kudos.Kudos;

import org.bukkit.event.server.PluginEnableEvent;

public class ServerListener extends org.bukkit.event.server.ServerListener
{
    public void onPluginEnable(PluginEnableEvent _event)
    {
        Kudos.get().getPermissionManager().load();
    }
}
