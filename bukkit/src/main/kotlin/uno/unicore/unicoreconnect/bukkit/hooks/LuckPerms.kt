package uno.unicore.unicoreconnect.bukkit.hooks

import org.bukkit.Bukkit
import uno.unicore.unicoreconnect.bukkit.PluginInstance
import uno.unicore.unicoreconnect.bukkit.listeners.LPJoinListener
import uno.unicore.unicoreconnect.common.UnicoreCommon
import uno.unicore.unicoreconnect.common.services.donate.DonateGroupService

class LuckPerms {
    var enabled: Boolean = false
    private val plugin = PluginInstance.plugin
    private val lpPlugin = Bukkit.getPluginManager().getPlugin("LuckPerms")

    fun hook() {
        if (lpPlugin != null && !enabled) {
            try {
                plugin.logger.info("Syncing UnicoreCMS donate-groups...")
                UnicoreCommon.donateGroupService.load()
                plugin.logger.info("Loaded ${DonateGroupService.groups.size} donate-groups from API")

                plugin.server.pluginManager.registerEvents(LPJoinListener(), plugin)

                plugin.logger.info("Successfully hook LuckPerms")
                enabled = true
            } catch (e: Exception) {
                plugin.logger.warning("Error getting group list! $e")
            }
        }
    }
}