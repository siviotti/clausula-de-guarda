package siviotti.clausuladeguarda;

import java.math.BigInteger;

public class Impacto {
    public static void main(String[] args) {

        BigInteger dividendo = BigInteger.valueOf(6);
        BigInteger divisor = BigInteger.valueOf(0);
        Matematica matematica = new Matematica();
        BigInteger resultado = matematica.bigDividir(dividendo, divisor);
        System.out.println("Resultado = " + resultado.toString());

    }


}
