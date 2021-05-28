package siviotti.clausuladeguarda;

public class Calculadora1 {

    public static void main(String[] args) {
        int e1 = Integer.parseInt(args[0]);
        String op = args[1];
        int e2 = Integer.parseInt(args[2]);
        int resultado = 0;
        Matematica matematica = new Matematica();
        switch (op) {
            case "+":
                resultado = matematica.soma(e1, e2);
                break;
            case "/":
                resultado = matematica.dividir(e1, e2);
                break;
            default: throw new IllegalStateException("Operação desconhecida: " + op);
        }
        System.out.println("Resultado = " + resultado);
    }
}
