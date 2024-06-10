package org.lostslvtt.airdelayplugin;

import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.entity.Player;

public class AirDelayListener implements Listener {

    @EventHandler
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission("darateria.airbypass")) {
            return;
        }

        long airTimeThreshold = AirDelayPlugin.getInstance().getPluginConfig().getLong("air-time-threshold", 250);
        long airTime = System.currentTimeMillis() - player.getLastPlayed();

        if (airTime < airTimeThreshold) {
            event.setCancelled(true);
            player.sendMessage("You cannot use commands while in the air!");
        }
    }
}
