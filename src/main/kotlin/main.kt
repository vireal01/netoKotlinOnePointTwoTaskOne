fun main() {
    val moneyToPay = 5420000
    val tax = if(moneyToPay * 0.0075 > 3500) (moneyToPay * 0.0075).toFloat() else 3500F
    val amount = moneyToPay + tax
    println("сумма перевода: ${(amount / 100).toInt()} рублей ${(amount % 100).toInt()} копеек")
}