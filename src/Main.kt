fun main() {
    println("Привет! Эта программа - простейший калькулятор с двумя числами, вы можете ввести данные через одинарный пробел, в формате \"число число оператор\" (например: 5.5 3.2 +) и получить результат. Попробуйте ;)\n")
    while (true) {
        println("Введите два числа и операцию через пробел (введите 'exit' для выхода):")

        val input = readln().trim()

        if (input.equals("exit", ignoreCase = true)) {
            println("Программа завершена. До свидания!")
            break
        }

        val parts = input.split(" ")

        if (parts.size != 3) {
            println("Ошибка: Введите два числа и символ операции, разделенные пробелами. Пример: 5 3 +")
            continue
        }

        try {
            val number1 = parts[0].toDouble()
            val number2 = parts[1].toDouble()
            val operation = parts[2]

            val result = when (operation) {
                "+" -> number1 + number2
                "-" -> number1 - number2
                "*" -> number1 * number2
                "/" -> {
                    if (number2 == 0.0) {
                        throw ArithmeticException("Ошибка: Деление на ноль невозможно.")
                    }
                    number1 / number2
                }
                else -> {
                    println("Ошибка: Некорректный символ операции. Допустимые операции: +, -, *, /")
                    println()
                    continue
                }
            }

            println("Результат: $result")

        } catch (e: NumberFormatException) {
            println("Ошибка: Введены некорректные числа. Пожалуйста, попробуйте снова.")
        } catch (e: ArithmeticException) {
            println(e.message)
        }

        println()
    }
}
