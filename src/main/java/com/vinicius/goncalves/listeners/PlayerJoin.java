package com.vinicius.goncalves.listeners;

import com.vinicius.goncalves.tags.TagManager;
import com.vinicius.goncalves.enums.Tags;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    TagManager tagManager = new TagManager();

    @EventHandler
    private void onJoin(PlayerJoinEvent event) {

        final Player player = event.getPlayer();

        for(Tags tag : Tags.values()) {
            if(player.hasPermission(tag.getPermission())) {
                tagManager.setNewTag(player, tag);
                break;
            }
        }
    }
}
