package uno.unicore.unicoreconnect.bukkit.commands

import co.aikar.commands.BaseCommand
import co.aikar.commands.MessageType
import co.aikar.commands.annotation.CommandAlias
import co.aikar.commands.annotation.CommandPermission
import co.aikar.commands.annotation.Default
import co.aikar.commands.annotation.Optional
import co.aikar.commands.bukkit.contexts.OnlinePlayer
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import uno.unicore.unicoreconnect.bukkit.CommandManager
import uno.unicore.unicoreconnect.bukkit.hooks.vault.Vault
import uno.unicore.unicoreconnect.common.UnicoreCommon

@CommandPermission("unicoreconnect.command.money")
@CommandAlias("money|bal|balance")
class MoneyCommand : BaseCommand() {
    @Default
    fun main(@Optional player: Player?, @Optional target: OnlinePlayer?) {
        if (player == null) {
            if (target == null)
                Bukkit.getConsoleSender()
                    .sendMessage(CommandManager.msg("acf-core.not_allowed_on_console", type = MessageType.ERROR))
            else {
                val resp = UnicoreCommon.moneyService.findOne(target.player.uniqueId)
                Bukkit.getConsoleSender().sendMessage(
                    CommandManager.msg(
                        "unicoreconnect.command_money_other",
                        replacements = arrayOf("{player}", resp.user.username, "{server}", UnicoreCommon.server!!.name, "{money}", Vault.provider!!.format(resp.money))
                    )
                )
            }
        } else {
            if (target == null) {
                val resp = UnicoreCommon.moneyService.findOne(player.uniqueId)
                player.sendMessage(
                    CommandManager.msg(
                        "unicoreconnect.command_money",
                        replacements = arrayOf( "{server}", UnicoreCommon.server!!.name, "{money}", Vault.provider!!.format(resp.money))
                    )
                )
            } else {
                if (player.hasPermission("unicoreconnect.command.money.other")) {
                    val resp = UnicoreCommon.moneyService.findOne(target.player.uniqueId)
                    player.sendMessage(
                        CommandManager.msg(
                            "unicoreconnect.command_money_other",
                            replacements = arrayOf("{player}", resp.user.username, "{server}", UnicoreCommon.server!!.name, "{money}", Vault.provider!!.format(resp.money))
                        )
                    )
                } else {
                    player.sendMessage(CommandManager.msg("acf-core.permission_denied", type = MessageType.ERROR))
                }
            }
        }
    }
}