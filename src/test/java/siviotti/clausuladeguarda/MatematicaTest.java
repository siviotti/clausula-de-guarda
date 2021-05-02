package siviotti.clausuladeguarda;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

public class MatematicaTest {

    @Test
    public void testSoma(){
        Matematica matematica = new Matematica();
        int resultado = matematica.soma(2,3);
        assertEquals(5, resultado);
    }

    @Test
    public void testDividir(){
        Matematica matematica = new Matematica();
        int resultado = matematica.dividir(6,2);
        assertEquals(3, resultado);
    }

    @Test
    public void deveGerarErroDividirPorZero(){
        Matematica matematica = new Matematica();
        assertThrows(ArithmeticException.class, ()->{
            matematica.dividir(6,0);
        });
    }

    @Test
    public void testDivide(){
        Matematica matematica = new Matematica();
        int resultado = matematica.divide(6,2);
        assertEquals(3, resultado);
    }

    @Test
    public void deveGerarErroDividePorZero(){
        Matematica matematica = new Matematica();
        assertThrows(ArithmeticException.class, ()->{
            matematica.divide(6,0);
        });
    }

    @Test
    public void testBigDividir(){
        Matematica m = new Matematica();
        BigInteger dividendo = BigInteger.valueOf(6);
        BigInteger divisor = BigInteger.valueOf(2);
        BigInteger resultado = m.bigDividir(dividendo, divisor);
        // fluxo feliz: divisão
        assertEquals(BigInteger.valueOf(3), resultado);
        // pré-condicao 1: dividendo nulo
        assertEquals(null, m.bigDividir(null, divisor));
        // pré-condicao 2: divisor nulo
        assertEquals(null, m.bigDividir(dividendo, null));
        // pré-condicao 3: divisor zero
        assertEquals(null, m.bigDividir(null, BigInteger.ZERO));
    }

    @Test
    public void testBigDivide(){
        Matematica m = new Matematica();
        BigInteger dividendo = BigInteger.valueOf(6);
        BigInteger divisor = BigInteger.valueOf(2);
        BigInteger resultado = m.bigDivide(dividendo, divisor);
        // fluxo feliz: divisão
        assertEquals(BigInteger.valueOf(3), resultado);
        // pré-condicao 1: dividendo nulo
        assertThrows(NullPointerException.class, ()->{
            m.bigDivide(null, divisor);
        });
        // pré-condicao 2: divisor nulo
        assertThrows(NullPointerException.class, ()->{
            m.bigDivide(dividendo, null);
        });
        // pré-condicao 3: divisor zero
        assertThrows(ArithmeticException.class, ()->{
            m.bigDivide(dividendo, BigInteger.ZERO);
        });
    }

}