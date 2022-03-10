package uno.unicore.unicoreconnect.common

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import uno.unicore.unicoreconnect.common.config.UnicoreConfig
import uno.unicore.unicoreconnect.common.http.UnicoreRequester
import uno.unicore.unicoreconnect.common.services.*
import uno.unicore.unicoreconnect.common.services.donate.DonateGroupService
import uno.unicore.unicoreconnect.common.types.Server

class UnicoreCommon(pluginConfig: UnicoreConfig) {
    companion object {
        val gson: Gson = GsonBuilder().create()
        var server: Server? = null

        lateinit var config: UnicoreConfig
        lateinit var requester: UnicoreRequester

        // Services
        lateinit var serversService: ServerService
        lateinit var banService: BanService
        lateinit var moneyService: MoneyService
        lateinit var playtimeService: PlaytimeService
        lateinit var donateGroupService: DonateGroupService
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
        showcaseService = ShowcaseService()
    }
}
