package com.vinicius.goncalves.utils;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandExecutor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.Objects;

public class Utils {

    final static HoverEvent.Action hoverAction = HoverEvent.Action.SHOW_TEXT;
    final static ClickEvent.Action clickAction = ClickEvent.Action.RUN_COMMAND;

    public static void registerCommand(String command, CommandExecutor executor) {
        Objects.requireNonNull(Bukkit.getPluginCommand(command)).setExecutor(executor);
    }

    public static String color(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public static TextComponent sendJSONAndRun(String text, String hoverText, String command) {

        HoverEvent hoverEvent = new HoverEvent(hoverAction, new Text(hoverText));
        ClickEvent clickEvent = new ClickEvent(clickAction, command);

        TextComponent textComponent = new TextComponent(text);
        textComponent.setHoverEvent(hoverEvent);
        textComponent.setClickEvent(clickEvent);
        return textComponent;

    }

    public static TextComponent sendJSONAndCopy(String text, String hoverText, String toClipboard) {

        TextComponent textComponent = new TextComponent(text);
        textComponent.setHoverEvent(new HoverEvent(hoverAction, new Text(hoverText)));
        textComponent.setClickEvent(new ClickEvent(clickAction, toClipboard));
        return textComponent;

    }

    public static ItemStack createItem(Material material, String name, String[] lore) {
        ItemStack itemStack = new ItemStack(material);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(color(name));
        itemMeta.setLore(Arrays.asList(lore));
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static ItemStack createItem(Material material, String name) {
        ItemStack itemStack = new ItemStack(material);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(color(name));
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
