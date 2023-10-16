package com.vinicius.goncalves.commands;

import com.vinicius.goncalves.inventories.TagsInventory;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TagsManager implements CommandExecutor {

    TagsInventory tagsInventory = new TagsInventory();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(!(sender instanceof Player)) {
            sender.sendMessage("§cThis command must be used only for players in-game.");
            return true;
        }

        final Player player = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("tags")) {
            tagsInventory.openTags(player);
            return true;
        }

        return false;
    }
}
