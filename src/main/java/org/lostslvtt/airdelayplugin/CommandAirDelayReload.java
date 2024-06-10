package org.lostslvtt.airdelayplugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandAirDelayReload implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
            AirDelayPlugin.getInstance().reloadPluginConfig();
            sender.sendMessage(ChatColor.GREEN + "Конфигурация была перезагружена!");
            return true;
        }
        sender.sendMessage(ChatColor.RED + "Неверное использование! Правильно: /airdelay reload");
        return true;
    }
}
