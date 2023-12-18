package com.example.xyzplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class XYZPlugin extends JavaPlugin implements CommandExecutor {

    @Override
    public void onEnable() {
        getLogger().info("XYZPlugin has been enabled!");

        // Register the command
        getCommand("xyz").setExecutor(this);
    }

    @Override
    public void onDisable() {
        getLogger().info("XYZPlugin has been disabled!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Seuls les joueurs peuvent utiliser cette commande !");
            return true;
        }

        Player player = (Player) sender;
        double x = player.getLocation().getX();
        double y = player.getLocation().getY();
        double z = player.getLocation().getZ();

        // Format coordinates with two decimal places
        String formattedCoordinates = String.format("X: %.2f, Y: %.2f, Z: %.2f", x, y, z);

        player.sendMessage("Vos coordonnées : " + formattedCoordinates);
        return true;
    }
}
