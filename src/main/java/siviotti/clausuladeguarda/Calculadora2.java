package siviotti.clausuladeguarda;

public class Calculadora2 {

    public static void main(String[] args) {
        if (args.length < 3) {
            throw new IllegalArgumentException("Informe 3 argumentos: [Elemento1] [Operador] [Elemento2]. Exemplo 2 + 2");
        }
        String op = args[1];
        if (op != "+" && op != "/"){
            throw new IllegalArgumentException("Operação desconhecida:" + op);
        }
        int e1 = tryParseInt(args[0]);
        int e2 = tryParseInt(args[2]);
        executaOperacao(op, e1, e2);
    }

    private static int tryParseInt(String s){
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException nfe){
            throw new IllegalArgumentException("O elemento deve se inteiro." + s, nfe);
        }
    }

    private static void executaOperacao( String op, int e1, int e2){
        int resultado = 0;
        Matematica matematica = new Matematica();
        switch (op) {
            case "+":
                resultado = matematica.soma(e1, e2);
                break;
            case "/":
                resultado = matematica.divide(e1, e2);
                break;
        }
        System.out.println("Resultado = " + resultado);
    }
}
