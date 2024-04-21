package dev.carloshmfs.playercolorchanger;

import java.util.HashMap;
import java.util.Map;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class SetPlayerColorCommand implements CommandExecutor {
    private Map<String, ChatColor> avalailableColors = new HashMap<String, ChatColor>();

    public SetPlayerColorCommand() {
        avalailableColors.put("preto", ChatColor.BLACK);
        avalailableColors.put("branco", ChatColor.WHITE);
        avalailableColors.put("amarelo", ChatColor.YELLOW);
        avalailableColors.put("verde", ChatColor.GREEN);
        avalailableColors.put("verde_escuro", ChatColor.DARK_GREEN);
        avalailableColors.put("vermelho", ChatColor.RED);
        avalailableColors.put("vermelho_escuro", ChatColor.DARK_RED);
        avalailableColors.put("azul", ChatColor.BLUE);
        avalailableColors.put("azul_escuro", ChatColor.DARK_BLUE);
    }

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
        
        if (avalailableColors.containsKey(argColor)) {
            ChatColor choosedColor = avalailableColors.get(argColor);

            player.setDisplayName(choosedColor + player.getName());
            player.setPlayerListName(choosedColor + player.getName());

            player.sendMessage(ChatColor.GREEN + "Cor mudada!");

            return true;
        }

        player.sendMessage(ChatColor.DARK_RED + "Essa cor não existe irmão");
        printHelp(player);
        return true;
    }

    private boolean printHelp(Player commandSender) {
        commandSender.sendMessage(ChatColor.YELLOW + "[" + ChatColor.DARK_GREEN + "ColorChanger" + ChatColor.YELLOW + "] " + ChatColor.AQUA + "Mensagem de ajuda para: " + ChatColor.GREEN + "/setcolor <cor>");
        commandSender.sendMessage(ChatColor.AQUA + "Cores disponiveis:");
        for (String color : avalailableColors.keySet()) {
            commandSender.sendMessage(ChatColor.YELLOW + color);
        }
        return true;
    }
}
