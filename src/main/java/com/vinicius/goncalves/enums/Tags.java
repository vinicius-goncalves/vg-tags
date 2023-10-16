package com.vinicius.goncalves.enums;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.permissions.Permission;

public enum Tags {

    OWNER("owner", "OWNER", new Permission("tags.onwer"), ChatColor.DARK_RED, true, Material.POPPY),
    ADMIN("admin", "ADMIN", new Permission("tags.admin"), ChatColor.RED, true, Material.RED_TULIP),
    MEMBER("member", "Member", new Permission("tags.member"), ChatColor.GRAY, true, Material.WHITE_TULIP);

    final String id;
    final String name;
    final Permission permission;
    final ChatColor color;
    final boolean bold;
    final Material material;

    Tags(String id, String name, Permission permission, ChatColor color, boolean bold, Material material) {
        this.id = id;
        this.name = name;
        this.permission = permission;
        this.color = color;
        this.bold = bold;
        this.material = material;
    }

    public String toString() {
        return this.name;
    }

    public String getName() {
        return this.toString();
    }

    public Permission getPermission() {
        return this.permission;
    }

    public String getPermissionName() {
        return this.permission.getName();
    }

    public ChatColor getColor() {
        return this.color;
    }

    public String getDisplayTag() {
        return "" + this.getColor() + ChatColor.BOLD + this.getName() + this.getColor() + " ";
    }

    public Material getMaterial() {
        return this.material;
    }
}
