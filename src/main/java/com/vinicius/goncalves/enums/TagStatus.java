package com.vinicius.goncalves.enums;

import org.bukkit.Material;

public enum TagStatus {

    ACTIVE_TAG(Material.LIME_DYE, "&aYou're using this tag right now!"),
    INACTIVE_TAG(Material.GRAY_DYE, "&7Click to use this tag.");

    final Material material;
    final String text;

    TagStatus(Material material, String text) {
        this.material = material;
        this.text = text;
    }

    public String toString() {
        return this.text;
    }

    public Material getMaterial() {
        return this.material;
    }

    public String getText() {
        return this.toString();
    }
}
