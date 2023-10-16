package com.vinicius.goncalves.inventories;

import com.vinicius.goncalves.enums.TagStatus;
import com.vinicius.goncalves.enums.TagsSlots;
import com.vinicius.goncalves.enums.ToggleSlots;
import com.vinicius.goncalves.tags.TagManager;
import com.vinicius.goncalves.enums.Tags;
import com.vinicius.goncalves.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import static com.vinicius.goncalves.utils.Utils.*;

public class TagsInventory {

    final int invSize = 4 * 9;
    final String invName = color("&8Tag Manager");
    Inventory inv = Bukkit.createInventory(null, invSize, invName);

    public void setItems(Player player, Inventory inv) {

        for(TagsSlots tagSlot : TagsSlots.values()) {

            Tags tag = tagSlot.getTag();
            String name = tag.getColor() + tag.getName();
            int slot = tagSlot.getSlot();
            Material material = tag.getMaterial();

            ItemStack tagItem = Utils.createItem(material, name);
            inv.setItem(slot, tagItem);
        }

        for(ToggleSlots toggleSlot : ToggleSlots.values()) {

            boolean playerHasCurrTag = TagManager.getPlayerTag(player).equals(toggleSlot.getTag());

            Material material = playerHasCurrTag
                        ? TagStatus.ACTIVE_TAG.getMaterial()
                        : TagStatus.INACTIVE_TAG.getMaterial();

            String text = playerHasCurrTag
                        ? TagStatus.ACTIVE_TAG.getText()
                        : TagStatus.INACTIVE_TAG.getText();


            ItemStack toggleItem = Utils.createItem(material, text);
            inv.setItem(toggleSlot.getSlot(), toggleItem);

        }
    }

    public void openTags(Player player) {
        setItems(player, inv);
        player.openInventory(inv);
    }
}
