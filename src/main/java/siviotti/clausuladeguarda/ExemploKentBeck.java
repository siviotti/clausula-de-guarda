package siviotti.clausuladeguarda;

public class ExemploKentBeck {

    void initialize1(){
        if (!isInitialazed()){
            // faz a inicialização
        }
    }

    void initialize2(){
        if (isInitialazed()){
            return;
        }
        // faz a inicialização
    }

    boolean isInitialazed() {
        return false;
    }
}
