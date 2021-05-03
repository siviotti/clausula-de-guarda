package siviotti.clausuladeguarda

import java.lang.IllegalArgumentException
import java.math.BigInteger

/**
 * Classe com exemplos simples de cláusula de guarda.
 * Versão em Kotlin da classe Matematica (Java)
 *
 * @author Douglas Siviotti
 * @since TDC Connections 2021 - Trilha Design de Código e XP
 * @see Matematica
 */
class Matematika {

    /** Exemplo 1: Cláusula de guarda usando "IllegalArgumentException"
     * na cláusula de guarda feita com um "IF". */
    fun dividir(dividendo: BigInteger, divisor: BigInteger): BigInteger {
        if (divisor.intValueExact() == 0) {
            throw IllegalArgumentException("Divisor não pode ser zero!")
        }
        return dividendo.divide(divisor);
    }

    /** Exemplo 2: Cláusula de guarda com função "require" do Kotlin.
     * As funções require, check etc estão no módulo "Precondition.kt"
     * e são tipicamente funções de cláusula de guarda.
     * OBS: Não é necessário testar nulos, pois os tipos dos parâmetros
     * não aceitam "null" como parâmetro por padrão.*/
    fun divide(dividendo: BigInteger, divisor: BigInteger): BigInteger {
        require(divisor.intValueExact() != 0) { "Divisor não pode ser zero!" }
        return dividendo.divide(divisor);
    }

    /** Exemplo 3: Função que aceita nulos e por isso usa 3 cláusulas de guarda.
     * A função requireNotNull é tipicamente uma cláusula de guarda para
     * testar se objetos estão nulos quando não poderiam.
     * */
    fun nullDivide(dividendo: BigInteger?, divisor: BigInteger?): BigInteger {
        requireNotNull(divisor) // dispara uma IllegalArgumentException
        requireNotNull(dividendo) // dispara uma IllegalArgumentException
        require(divisor.intValueExact() != 0) { "Divisor não pode ser zero!" }
        return dividendo.divide(divisor);
    }

}