package me.ryall.kudos.system;

import me.ryall.kudos.Kudos;

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
            critique(_player, _label, _args, 1.0D);
            return true;
        }
        else if (_label.equalsIgnoreCase("dislike"))
        {
            critique(_player, _label, _args, -1.0D);
            return true;
        }
        
        return false;
    }

    private static void critique(Player _player, String _label, String[] _args, double _change)
    {
        if (_player == null)
        {
            Kudos.get().getCommunicationManager().logError("This command cannot be used from the console.");
            return;
        }
        
        if (_args.length > 0)
        {
            Player subject = Kudos.get().findPlayer(_args[0]);
            
            if (subject != null)
            {
                //Critique critique = new Critique(_player.getName(), _change, null);
                
                //Reputation reputation = find(subject.getName());
                
                //reputation.add(critique);
            }
            else
                Kudos.get().getCommunicationManager().error(_player, "Could not find the player " + _args[0] + "."); 
        }
        else
            Kudos.get().getCommunicationManager().error(_player, "Usage: /" + _label.toLowerCase() + " <playername> [message]");
    }

    public static Reputation find(String _playerName)
    {
        return null;
    }
}
