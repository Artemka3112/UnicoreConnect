package ru.unicorecms.unicoreconnect.common.types

import ru.unicorecms.unicoreconnect.common.UnicoreCommon

class PlaytimeRequest (
    var user_uuid: String
) {
    val server = UnicoreCommon.config.server
}