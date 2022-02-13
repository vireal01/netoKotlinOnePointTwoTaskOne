package com.vireal

fun getVisaOrMirCommission(moneyToPay: Int):Int {
    val tax = if(moneyToPay * 0.0075 > 3500) (moneyToPay * 0.0075).toFloat() else 3500F
    return tax.toInt()
}

fun getMasterOrMaestroCommission(moneyToPay: Int, sumOfPreviousTransactions: Int ):Int {
    val tax = if(moneyToPay + sumOfPreviousTransactions > 7_500_000 ) (moneyToPay * 0.006 + 2_000) else 0
    return tax.toInt()
}

fun outputPrettier(amount: Int): String{
    return "сумма транзакции ${amount / 100} руб. ${amount % 100} коп."
}

fun getSumOfTransaction(moneyToPay: Int, sumOfPreviousTransactions: Int = 0, cardHolder: String = "VK"):String {
    val commissionAmount = when(cardHolder){
        "Maestro", "Mastercard" -> getMasterOrMaestroCommission(moneyToPay, sumOfPreviousTransactions )
        "Visa", "Mir" -> getVisaOrMirCommission(moneyToPay )
        else -> 0
    }
    return outputPrettier(commissionAmount + moneyToPay)
}