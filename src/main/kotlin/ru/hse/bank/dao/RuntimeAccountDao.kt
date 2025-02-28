package ru.hse.bank.dao

import ru.hse.bank.entity.AccountEntity

class RuntimeAccountDao : AccountDao {
    private val accountEntities = mutableListOf<AccountEntity>()

    override fun findAccountByName(name: String): AccountEntity =
        accountEntities.find { it.name == name } ?: throw RuntimeException("Account not found")

    override fun increaseAccountSumByName(name: String, sum: Long): AccountEntity =
        findAccountByName(name).also { it.sum += sum }

    override fun saveAccount(accountEntity: AccountEntity): Boolean = accountEntities.add(accountEntity)
}
