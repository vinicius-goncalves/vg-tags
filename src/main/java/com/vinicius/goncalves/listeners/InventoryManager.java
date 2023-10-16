package com.vinicius.goncalves.listeners;

import com.vinicius.goncalves.tags.TagManager;
import com.vinicius.goncalves.enums.ToggleSlots;
import com.vinicius.goncalves.utils.Utils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

public class InventoryManager implements Listener {

    @EventHandler
    private void onClick(InventoryClickEvent event) {

        if (!(event.getView().getTitle().equalsIgnoreCase(Utils.color("&8Tag Manager")))) {
            return;
        }

        event.setCancelled(true);

        final Player player = (Player) event.getWhoClicked();
        int slotClicked = event.getSlot();

        for (ToggleSlots slot : ToggleSlots.values()) {
            if (slot.getSlot() == slotClicked) {

                for (ToggleSlots slots2 : ToggleSlots.values()) {
                    event.getInventory().setItem(slots2.getSlot(), Utils.createItem(Material.GRAY_DYE, "&7Click to use this tag."));
                }

                event.getInventory().setItem(slotClicked, Utils.createItem(Material.LIME_DYE, "&aYou're using this tag right now!"));
                TagManager.setNewTag(player, slot.getTag());
            }
        }

        player.closeInventory();
    }
}