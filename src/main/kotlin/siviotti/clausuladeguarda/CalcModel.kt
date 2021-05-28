package siviotti.clausuladeguarda

data class Operacao(val e1: Int, val op: TipoOperacao, val e2: Int) {
    fun executar() = op.algoritmo.invoke(e1, e2)
}

val divFunction = fun (e1: Int, e2: Int): Int{
    require(e2 != 0) {"O divisor não pode ser zero!"}
    return e1 / e2
}

enum class TipoOperacao (val simbolo: String, val algoritmo: (e1: Int, e2: Int)-> Int ){
    SOMA("+", {e1, e2-> e1 + e2}),
    DIVISAO ("/", divFunction);

    companion object {
        @JvmStatic
        fun of(simbolo: String): TipoOperacao {
            val list = values().filter { it.simbolo == simbolo }
            require(!list.isEmpty()) { "Nenhuma operação corresponde ao simbolo $simbolo" }
            return list[0]
        }
    }
}
