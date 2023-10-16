package com.vinicius.goncalves;

import com.vinicius.goncalves.commands.TagsManager;
import com.vinicius.goncalves.listeners.InventoryManager;
import com.vinicius.goncalves.listeners.PlayerChat;
import com.vinicius.goncalves.listeners.PlayerJoin;
import com.vinicius.goncalves.tags.TagManager;
import com.vinicius.goncalves.enums.Tags;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import static com.vinicius.goncalves.utils.Utils.*;

public final class Main extends JavaPlugin {

    TagManager tagManager = new TagManager();

    @Override
    public void onEnable() {
        registerCommand("tags", new TagsManager());

        for(Tags tag : Tags.values()) {
            Bukkit.getPluginManager().addPermission(tag.getPermission());
        }

        Bukkit.getOnlinePlayers().forEach(player -> {
            tagManager.setLatestTag(player);
        });

        Bukkit.getPluginManager().registerEvents(new PlayerJoin(), this);
        Bukkit.getPluginManager().registerEvents(new InventoryManager(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerChat(), this);
    }

    @Override
    public void onDisable() {
    }
}
