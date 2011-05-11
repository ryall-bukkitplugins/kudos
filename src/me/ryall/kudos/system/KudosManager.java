package me.ryall.kudos.system;

import org.bukkit.entity.Player;

public class KudosManager
{
    public static boolean command(Player _player, String _label, String[] _args)
    {
        if (_label.equalsIgnoreCase("kudos"))
        {
            return true;
        }
        else if (_label.equalsIgnoreCase("like"))
        {
            return true;
        }
        else if (_label.equalsIgnoreCase("dislike"))
        {
            return true;
        }
        
        return false;
    }
}
