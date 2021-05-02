package siviotti.clausuladeguarda;

import java.math.BigInteger;

/**
 * Classe com exemplos simples de cláusula de guarda
 *
 * @author Douglas Siviotti
 * @since TDC Connections 2021 - Trilha Design de Código e XP
 */
public class Matematica {

    /**
     * Método sem pré-condição para execução
     */
    public int soma(int a, int b) {
        return a + b;
    }

    // CLEAN CODE ALERT: os comentários são excessivos, porém didáticos

    /**
     * Exemplo 1: IF de pré-condição (b diferente de zero) para executar a divisão
     * Se atender a pré-condição o método executa seu comportamento
     */
    public int dividir(int a, int b) {
        if (b != 0) {       // pré-condição para executar o comportamento
            return a / b;   // comportamento de negócio (dividir)
        }                   // else aqui?
        throw new ArithmeticException("Impossível dividir por zero!");
    }

    /**
     * Exemplo 2: IF de checagem de pré-condição (se divisor igual a zero)
     * Se não atender a pré-condição o método é interrompido e o comportamento não chega a ser executado.
     */
    public int divide(int dividendo, int divisor) {
        if (divisor == 0) { // isso é uma cláusula de guarda
            throw new ArithmeticException("O divisor não pode ser zero!");
        }
        return dividendo / divisor; // comportamento de negócio (dividir)
    }

    /**
     * Exemplo 3: IFs para 3 pré-condições:
     * 1 - dividendo não pode ser nulo
     * 2 - divisor não pode ser nulo
     * 3 - divisor não pode ser zero
     * Se as três pré-condições forem atendidas o método executa seu comportamento principal.
     * Se uma delas não for atendida o método não funciona, mas retorna "null" gerando
     * bastante confusão para quem chamar ou testar este método.
     * O método não funcionou por que?
     * 1 - O dividendo era nulo?
     * 2 - O divisor era nulo?
     * 3 - O divisor era zero?
     */
    public BigInteger bigDividir(BigInteger dividendo, BigInteger divisor) {
        if (dividendo != null) { // pré-condição 1: dividendo não é nulo
            if (divisor != null) { // pré-condição 2: divisor não é nulo
                if (divisor.intValue() != 0) { // pré-condição 3: divisor não é zero
                    return dividendo.divide(divisor);
                }
            }
        }
        return null; // CLEAN CODE ALERT: Nunca passe ou retorne nulo
    }

    /**
     * Exemplo 4: IFs de checagem para 3 pré-condições:
     * 1 - dividendo não pode ser nulo
     * 2 - divisor não pode ser nulo
     * 3 - divisor não pode ser zero
     * Se uma das pré-condições não for atendida o método é interrompido com uma exceção
     * e seu comportamento principal não executa.
     * Cada violação de uma pré-condição gera um erro específico e inequívoco.
     */
    public BigInteger bigDivide(BigInteger dividendo, BigInteger divisor) {
        if (dividendo == null) {// pré-condição 1: dividendo não é nulo
            throw new NullPointerException("O dividendo não pode ser nulo!");
        }
        if (divisor == null) {// pré-condição 2: divisor não é nulo
            throw new NullPointerException("O divisor não pode ser nulo!");
        }
        if (divisor.intValue() == 0) {// pré-condição 3: divisor não é zero
            throw new ArithmeticException("O divisor não pode ser zero!");
        }
        return dividendo.divide(divisor);
    }

}
