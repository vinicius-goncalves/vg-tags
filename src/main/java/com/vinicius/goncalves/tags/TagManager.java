package com.vinicius.goncalves.tags;

import com.vinicius.goncalves.enums.Tags;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;

public class TagManager {

    public static HashMap<Player, Tags> hashTags = new HashMap<>();

    public static void setNewTag(Player player, Tags newTag) {

        player.setPlayerListName(newTag.getDisplayTag() + player.getName());
        player.setDisplayName(newTag.getDisplayTag() + player.getName());

        if(newTag == Tags.MEMBER) {
            player.setPlayerListName(newTag.getColor() + player.getName());
            player.setDisplayName(newTag.getColor() + player.getName());
        }

        hashTags.put(player, newTag);

        ArrayList<String> list = new ArrayList<>();

        list.add(" ");
        list.add("§aA new tag was defined on you!");
        list.add("§aYour new tag is: " + newTag.getColor() + newTag.getName());
        list.add(" ");

        for(String str : list) {
            player.sendMessage(str);
        }
    }

    public static void setLatestTag(Player player) {
        for(Tags tag : Tags.values()) {
            if(player.hasPermission(tag.getPermission())) {
                hashTags.put(player, tag);
                break;
            }
        }
    }

    public static Tags getPlayerTag(Player target) {

        for(Player player : hashTags.keySet()) {
            if(player.getName().equalsIgnoreCase(target.getName())) {
                return hashTags.get(player);
            }
        }

        return Tags.MEMBER;
    }
}
