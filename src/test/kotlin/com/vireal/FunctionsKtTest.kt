package com.vireal

import org.junit.Test

import org.junit.Assert.*

class FunctionsKtTest {

    @Test
    fun getVisaOrMirCommissionElseTest() {
        val priceToPayForElseBranch = 10_000
        val result = getVisaOrMirCommission(moneyToPay = priceToPayForElseBranch)
        assertEquals(3500, result)
    }

    @Test
    fun getVisaOrMirCommissionIfTest() {
        val priceToPayForIfBranch = 1_000_000
        val result = getVisaOrMirCommission(moneyToPay = priceToPayForIfBranch)
        assertEquals(7500, result)
    }

    @Test
    fun getMasterOrMaestroCommissionIfTest() {
        val priceToPayForIfBranch = 8_000_000

        val result = getMasterOrMaestroCommission(
            moneyToPay = priceToPayForIfBranch,
            sumOfPreviousTransactions = 0 )
        assertEquals(50000, result)
    }

    @Test
    fun getMasterOrMaestroCommissionZeroCommission() {
        val priceToPayForZeroCommission = 1_000_000
        val sumOfPreviousPays = 2_000_000

        val result = getMasterOrMaestroCommission(
            moneyToPay = priceToPayForZeroCommission,
            sumOfPreviousTransactions = sumOfPreviousPays )
        assertEquals(1, result)
    }

    @Test
    fun outputPrettierTest() {
        val result = outputPrettier(1111)
        assertEquals("сумма транзакции 11 руб. 11 коп.", result)
    }

    @Test
    fun getSumOfTransactionVkTest() {
        val priceToPay = 100_000_000
        val result = getSumOfTransaction(
            moneyToPay = priceToPay)
        assertEquals("сумма транзакции 1000000 руб. 0 коп.",result)
    }

    @Test
    fun getSumOfTransactionMaestroTest() {
        val priceToPay = 8_000_000
        val sumOfPreviousPays = 0
        val result = getSumOfTransaction(
            moneyToPay = priceToPay,
            sumOfPreviousTransactions = sumOfPreviousPays,
            cardHolder = "Maestro")
        assertEquals("сумма транзакции 80500 руб. 0 коп.",result)
    }

    @Test
    fun getSumOfTransactionMirTest() {
        val priceToPay = 1_000_000
        val sumOfPreviousPays = 0
        val result = getSumOfTransaction(
            moneyToPay = priceToPay,
            sumOfPreviousTransactions = sumOfPreviousPays,
            cardHolder = "Mir")
        assertEquals("сумма транзакции 10075 руб. 0 коп.",result)
    }
}