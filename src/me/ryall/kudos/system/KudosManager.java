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
            String action = _args[0];
            
            // Turn shortcut commands into Kudos commands.
            /*if (!_label.equalsIgnoreCase("kudos"))
            {
                _args = new String[] { _label, _args };
            }*/
            
            if (action.equalsIgnoreCase("like"))
                likeAction(_player, null, null);
            else if (action.equalsIgnoreCase("dislike"))
                dislikeAction(_player, null, null);
            else if (action.equalsIgnoreCase("neutral"))
                neutralAction(_player, null);
        }
        else
            showHelp(_player);
    }

    private void likeAction(Player _reviewer, Player _reviewee, String _comment)
    {
        double min = Kudos.get().getConfigManager().getLikeMinimumReputation();
        double change = Kudos.get().getConfigManager().getLikeReputationIncrease();
        
        review(_reviewer, _reviewee, _comment, min, change);
    }
    
    private void dislikeAction(Player _reviewer, Player _reviewee, String _comment)
    {
        double min = Kudos.get().getConfigManager().getDislikeMinimumReputation();
        double change = -Kudos.get().getConfigManager().getDislikeReputationDecrease();
        
        review(_reviewer, _reviewee, _comment, min, change);
    }
    
    private void neutralAction(Player _reviewer, Player _reviewee)
    {
        Reputation reputation = Kudos.get().getDatabaseManager().getReputation(_reviewee);
        
        reputation.removeReview(_reviewer);
    }
    
    private void review(Player _reviewer, Player _reviewee, String _comment, double _min, double _change) 
    {
        Reputation reviewerReputation = Kudos.get().getDatabaseManager().getReputation(_reviewer);
        Reputation revieweeReputation = Kudos.get().getDatabaseManager().getReputation(_reviewee);
        
        if (reviewerReputation.getScore() > _min)
        {
            revieweeReputation.review(_reviewer, _change, _comment);
        }
        else
            Kudos.get().getCommunicationManager().error(_reviewer, "You don't have enough reputation to do that.");
    }

    private void showHelp(Player _player)
    {
        PermissionManager pm = Kudos.get().getPermissionManager();
        CommunicationManager cm = Kudos.get().getCommunicationManager();
        
        if (pm.hasSetPermission(_player))
            cm.command(_player, "/kudos set <player> <rep> [msg]", "Override a player's reputation.");
        
        if (pm.hasReputationPermission(_player))
            cm.command(_player, "/kudos rep [player]", "Get a player's reputation.");
        
        if (pm.hasRankPermission(_player))
            cm.command(_player, "/kudos rank [player]", "Get a player's reputation ranking.");
        
        if (pm.hasTopPermission(_player))
            cm.command(_player, "/kudos top [num]", "Get the top [num] player's by reputation.");
        
        if (pm.hasLikePermission(_player))
            cm.command(_player, "/like <player> [msg]", "Positively influence a player's reputation.");
        
        if (pm.hasDislikePermission(_player))
            cm.command(_player, "/dislike <player> [msg]", "Negatively influence a player's reputation.");
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
