package siviotti.clausuladeguarda

import java.math.BigInteger

class Matematika {

    fun divide(dividendo: BigInteger,  divisor: BigInteger): BigInteger{
        check (divisor.intValueExact() != 0) {"Divisor não pode ser zero!"}
        return dividendo.divide(divisor);
    }
}