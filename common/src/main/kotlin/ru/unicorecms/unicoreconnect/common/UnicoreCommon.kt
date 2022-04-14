package ru.unicorecms.unicoreconnect.common

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import ru.unicorecms.unicoreconnect.common.config.UnicoreConfig
import ru.unicorecms.unicoreconnect.common.http.UnicoreRequester
import ru.unicorecms.unicoreconnect.common.services.*
import ru.unicorecms.unicoreconnect.common.services.donate.DonateGroupService
import ru.unicorecms.unicoreconnect.common.services.donate.DonatePermissionService
import ru.unicorecms.unicoreconnect.common.types.Server

class UnicoreCommon(pluginConfig: UnicoreConfig) {
    companion object {
        val gson: Gson = GsonBuilder().create()
        var server: Server? = null
        var itemsMap = mutableMapOf<String, String>()
        var itemsMapDefault =  mapOf(
            "minecraft_spawn_egg" to "MONSTER_EGG",
            "minecraft_dye" to "INK_SACK",
            "minecraft_mycelium" to "MYCEL"
        )

        lateinit var config: UnicoreConfig
        lateinit var requester: UnicoreRequester

        // Services
        lateinit var serversService: ServerService
        lateinit var banService: BanService
        lateinit var moneyService: MoneyService
        lateinit var playtimeService: PlaytimeService
        lateinit var donateGroupService: DonateGroupService
        lateinit var donatePermissionService: DonatePermissionService
        lateinit var showcaseService: ShowcaseService
    }

    init {
        config = pluginConfig
        requester = UnicoreRequester()

        serversService = ServerService()
        banService = BanService()
        moneyService = MoneyService()
        playtimeService = PlaytimeService()
        donateGroupService = DonateGroupService()
        donatePermissionService = DonatePermissionService()
        showcaseService = ShowcaseService()
    }
}
