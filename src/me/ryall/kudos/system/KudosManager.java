package me.ryall.kudos.system;

import me.ryall.kudos.Kudos;
import me.ryall.kudos.communication.CommunicationManager;
import me.ryall.kudos.settings.PermissionManager;

import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class KudosManager
{
    public void onCommand(Player _player, Command _command, String _label, String[] _args)
    {
        // All commands require arguments so show the help if we have none.
        if (_args.length < 0)
        {
            // Turn shortcut commands into Kudos commands.
            /*if (!_label.equalsIgnoreCase("kudos"))
            {
                _args = new String[] { _label, _args };
            }*/
            
            
        }
        else
            showHelp(_player);
    }

    private void showHelp(Player _player)
    {
        PermissionManager pm = Kudos.get().getPermissionManager();
        CommunicationManager cm = Kudos.get().getCommunicationManager();
        
        if (pm.hasSetPermission(_player))
            cm.command(_player, "/kudos set <player> <rep>", "Override a player's reputation.");
        
        if (pm.hasReputationPermission(_player))
            cm.command(_player, "/kudos rep [player]", "Get a player's reputation.");
        
        if (pm.hasRankPermission(_player))
            cm.command(_player, "/kudos rank [player]", "Get a player's reputation ranking.");
        
        if (pm.hasTopPermission(_player))
            cm.command(_player, "/kudos top [num]", "Get the top [num] player's by reputation.");
        
        if (pm.hasLikePermission(_player))
            cm.command(_player, "/like <player>", "Positively influence a player's reputation.");
        
        if (pm.hasDislikePermission(_player))
            cm.command(_player, "/dislike <player>", "Negatively influence a player's reputation.");
    }

    /*private void critique(Player _player, String _label, String[] _args, double _change)
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
    }*/
}
