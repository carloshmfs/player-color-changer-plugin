package dev.carloshmfs.playercolorchanger;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class SetPlayerColorCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }

        Player player = (Player) sender;

        if (args.length == 0){
            this.printHelp(player);

            return true;
        }

        String argColor = args[0];
        player.sendMessage(argColor);
        for (ChatColor color : ChatColor.values()) {
            player.sendMessage(argColor + " " + color);
            if (argColor == color.name()) {
                player.setDisplayName(color + sender.getName());
                player.setPlayerListName(color + sender.getName());

                return true;
            }
        }

        return false;
    }

    private boolean printHelp(Player commandSender) {
        commandSender.sendMessage(ChatColor.YELLOW + "[" + ChatColor.DARK_GREEN + "PlayerColorChanger" + ChatColor.YELLOW + "] " + ChatColor.AQUA + "Mensagem de ajuda para: " + ChatColor.GREEN + "/setcolor");
        return true;
    }
}
