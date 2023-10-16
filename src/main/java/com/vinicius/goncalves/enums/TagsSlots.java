package com.vinicius.goncalves.enums;

import com.vinicius.goncalves.utils.Utils;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public enum TagsSlots {

    OWNER(Tags.OWNER, 10),
    ADMIN(Tags.ADMIN, 11),
    MEMBER(Tags.MEMBER, 12);

    final Tags tag;
    final int slot;

    TagsSlots(Tags tag, int slot) {
        this.tag = tag;
        this.slot = slot;
    }

    public Tags getTag() {
        return this.tag;
    }

    public int getSlot() {
        return this.slot;
    }
}
