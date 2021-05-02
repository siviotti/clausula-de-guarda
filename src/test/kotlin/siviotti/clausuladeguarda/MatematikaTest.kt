package siviotti.clausuladeguarda

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.math.BigInteger

internal class MatematikaTest{

    @Test
    fun testDivide(){
        val m = Matematika()
        val resultado = m.divide(BigInteger.valueOf(6), BigInteger.valueOf(2))
        print(resultado)
    }
}