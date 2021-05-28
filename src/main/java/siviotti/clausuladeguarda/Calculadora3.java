package siviotti.clausuladeguarda;

public class Calculadora3 {

    public static void main(String[] args) {
        if (args.length < 3) {
            throw new IllegalArgumentException("Informe 3 argumentos: [Elemento1] [Operador] [Elemento2]. Exemplo 2 + 2");
        }
        int e1 = tryParseInt(args[0]);
        TipoOperacao tipoOperacao = TipoOperacao.of(args[1]);
        int e2 = tryParseInt(args[2]);
        Operacao operacao = new Operacao (e1, tipoOperacao, e2);
        System.out.println("Resultado = " + operacao.executar());
    }

    private static int tryParseInt(String s){
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException nfe){
            throw new IllegalArgumentException("O elemento deve se inteiro." + s, nfe);
        }
    }

}
