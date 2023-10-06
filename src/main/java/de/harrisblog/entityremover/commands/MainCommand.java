package de.harrisblog.entityremover.commands;

import de.harrisblog.entityremover.EntityRemover;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class MainCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(!(commandSender instanceof Player)) return false;
        Player p = (Player) commandSender;
        if(command.getName().toLowerCase().equals("entityremover") && strings[0].toLowerCase().equals("reload")){
            EntityRemover.getPlugin().reloadConfig();
            EntityRemover.getEntityListController().loadEntities();
            EntityRemover.removeAllEntities();
            p.sendMessage(ChatColor.GREEN + "EntityRemover Successfully Reloaded!");
            return true;
        }else{
            p.sendMessage(ChatColor.GRAY.toString() + ChatColor.BOLD + "EntityRemover Commands");
            p.sendMessage(ChatColor.GRAY + "/entityremover reload");
            return true;
        }
    }
}
