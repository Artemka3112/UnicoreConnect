package ru.zirconiamc.zirconiaconnect.bukkit.vault

import net.milkbowl.vault.economy.EconomyResponse
import org.bukkit.OfflinePlayer

class VaultEconomyHook : EconomyWrapper() {
    companion object {}

    override fun isEnabled(): Boolean {
        return true
    }

    override fun getName(): String {
        return "ZirconiaConnect"
    }


    override fun fractionalDigits(): Int {
        return 0
    }

    override fun format(amount: Double): String {
        return amount.toString()
    }

    override fun currencyNamePlural(): String {
        return ""
    }

    override fun currencyNameSingular(): String {
        return ""
    }

    override fun hasAccount(player: OfflinePlayer?): Boolean {
        return false
    }

    override fun getBalance(player: OfflinePlayer?): Double {
        return 0.0
    }

    override fun has(player: OfflinePlayer, amount: Double): Boolean {
       return false
    }

    override fun withdrawPlayer(player: OfflinePlayer, initialAmount: Double): EconomyResponse {
        return EconomyResponse(0.0, 0.0, EconomyResponse.ResponseType.NOT_IMPLEMENTED, null)
    }

    override fun depositPlayer(player: OfflinePlayer, initialAmount: Double): EconomyResponse {
        return EconomyResponse(0.0, 0.0, EconomyResponse.ResponseType.NOT_IMPLEMENTED, null)
    }

    override fun createPlayerAccount(player: OfflinePlayer?): Boolean {
        return true
    }
}