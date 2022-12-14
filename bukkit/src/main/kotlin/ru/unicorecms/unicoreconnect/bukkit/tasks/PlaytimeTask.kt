package ru.unicorecms.unicoreconnect.bukkit.tasks

import com.Zrips.CMI.CMI
import com.earth2me.essentials.Essentials
import org.bukkit.Bukkit
import ru.unicorecms.unicoreconnect.bukkit.PluginInstance
import ru.unicorecms.unicoreconnect.common.UnicoreCommon

class PlaytimeTask {
    private val plugin = PluginInstance.plugin
    private val essPlugin = Bukkit.getPluginManager().getPlugin("Essentials") as Essentials?
    private val cmiPlugin = Bukkit.getPluginManager().getPlugin("CMI")
    private var cmiInstance: CMI? = null

    fun load() {
        if (essPlugin != null) {
            plugin.logger.info("Successfully hook Essentials/EssentialsX")
        } else if (cmiPlugin != null) {
            cmiInstance = CMI.getInstance()
            plugin.logger.info("Successfully hook CMI")
        }
    }

    fun handler() {
        val players = plugin.server.onlinePlayers

        if (players.isNotEmpty()) {
            if (essPlugin != null) {
                UnicoreCommon.playtimeService.update(players
                        .filter { !essPlugin.getUser(it).isAfk }
                        .map { it.uniqueId }
                )
            } else if (cmiInstance != null) {
                UnicoreCommon.playtimeService.update(players
                        .filter { !cmiInstance!!.playerManager.getUser(it).isAfk }
                        .map { it.uniqueId }
                )
            } else {
                UnicoreCommon.playtimeService.update(players.map { it.uniqueId })
            }
        }
    }
}