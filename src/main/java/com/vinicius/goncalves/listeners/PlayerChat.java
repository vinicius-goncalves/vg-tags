package com.vinicius.goncalves.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChat implements Listener {


    @EventHandler
    private void onChat(AsyncPlayerChatEvent event) {

        event.setCancelled(true);

        final Player player = event.getPlayer();
        Bukkit.broadcastMessage(player.getDisplayName() + ": §r" + event.getMessage());
    }
}
