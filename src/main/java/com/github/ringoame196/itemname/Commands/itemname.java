package com.github.ringoame196.itemname.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class itemname implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        String plugin_name = ChatColor.YELLOW+"[itemname] ";
        //プレイヤー以外からの実行を禁止する
        if(!(commandSender instanceof Player))
        {
            commandSender.sendMessage(plugin_name+ ChatColor.RED+"コマンドはプレイヤーのみ実行することが可能です");
            return true;
        }
        Player player =(Player) commandSender;
        //opを持っているプレイヤーのみ実行
        if(!player.isOp())
        {
            player.sendMessage(plugin_name+ChatColor.RED+"あなたはこのコマンドを使う権限を持っていません");
            return true;
        }
        ItemStack mainitem = player.getInventory().getItemInMainHand();
        //アイテムを持っていないときのエラー対策
        if(mainitem.getType()== Material.AIR)
        {
            player.sendMessage(plugin_name+ChatColor.RED+"アイテムを持ってください");
            return true;
        }
        ItemMeta meta = mainitem.getItemMeta();
        String item_name;
        //リセット処理
        if (strings.length == 0 || strings[0] == null || strings[0].isEmpty())
        {
            meta.setDisplayName(null);
            item_name = ChatColor.GOLD+"リセット";
        }
        //名前をつける処理
        else {
            item_name = strings[0];
            for(int i=1;i<strings.length;i++)
            {
                item_name += " " + strings[i];
            }
            //文字に色を付ける
            {
                item_name=item_name.replace("&","§");
            }
            meta.setDisplayName(item_name);
            item_name +=ChatColor.AQUA+ "に";
        }
        mainitem.setItemMeta(meta);

        player.sendMessage(plugin_name+ChatColor.AQUA+"アイテム名を"+item_name+ChatColor.AQUA+"しました");
        player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_USE,1,1);
        return true;
    }
}
