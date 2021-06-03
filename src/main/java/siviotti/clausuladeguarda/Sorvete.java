package siviotti.clausuladeguarda;

/**
 * Classe com o algoritmo exemplo do preço do sorvete que exemplifica que a adoção de
 * "IFs de saída antecipada" podem fazer um efeito similar ao da cláusula de guarda.
 * <p>
 * Veja o teste de unidade para ver este código em ação. Classe <code>SorveteTest</code>
 *
 * @author Douglas Siviotti
 * @since TDC Connections 2021 - Trilha Design de Código e XP
 */
public class Sorvete {

    /**
     * Método de cálculo de preço do sorvete onde qualquer combinação é possível.
     * É possível adicionar coberturas em sabores comuns etc.
     *
     * @param premium    Determina se o sorvete é de um sabor premium (mais caro)
     * @param casquinha  Determina se o sorvete é entregue na casquinha ao invés do copinho.
     * @param coberturas Indica quantas coberturas deve ter no sorvete.
     * @return O preço final do sorvete em função das opções
     */
    public int precoSorvete(boolean premium, boolean casquinha, int coberturas) {
        int preco = 0;
        if (premium) {
            preco = 20;
        } else {
            preco = 15;
        }
        if (casquinha) {
            preco = preco + 2;
        } else {
            preco = preco + 1;
        }
        if (coberturas > 1) {
            preco = preco + 2;
        } else {
            preco = preco + 1;
        }
        return preco;
    }

    // Código acima otimizado sem alterar o requisito:
    /*
    int preco = 15;
	if (premium) {
		preco = preco + 5;
	}
	preco = preco + 1;
	if (casquinha) {
		preco = preco + 1;
	}
	preco = preco + 1;
	if (coberturas > 1){
		preco = preco + 1;
	}
	return preco;
     */

    /**
     * Método que calcula o preço do sorvete no algoritmo restritivo.
     * Este algoritmo implementa o requisito onde somente sorvete premium tem casquinha
     * e somente casquinha pode ter coberturas. Neste caso, há duas possíveis
     * saídas antecipadas para uma possível refatoração.
     *
     * @param premium    Determina se o sorvete é de um sabor premium (mais caro)
     * @param casquinha  Determina se o sorvete é entregue na casquinha aom invés do copinho.
     *                   Apenas sabores premium podem ser vendidos em casquinha.
     * @param coberturas Indica quantas coberturas deve ter no sorvete.
     *                   Apenas Casquinhas premium podem ter coberturas.
     * @return O preço final do sorvete
     */
    public int precoSorvete1(boolean premium, boolean casquinha, int coberturas) {
        int preco = 0;
        if (premium) {
            preco = 20;
            if (casquinha) {
                preco = preco + 2;
                if (coberturas > 1) {
                    preco = preco + 2;
                } else {
                    preco = preco + 1;
                }
            } else {
                preco = preco + 2;
            }
        } else {
            preco = 15 + 1 + 1;
        }
        return preco;
    }

    /**
     * Este versão usa IFs de saída antecipada. <b>Não é exatamente uma cláusula de
     * guarda</b> já que não são pré-condições, mas sua adoção gera iguais vantagens.
     * O código fica menor e mais simples de ser lido.
     * A complexidade cognitiva passa de 9 para 3!
     */
    public int precoSorvete2(boolean premium, boolean casquinha, int coberturas) {
        int preco = 15 + 1 + 1;  // copo + 1 cob
        if (!premium) return preco;
        preco = 20 + 1 + 1;      // copo + 1 cob
        if (!casquinha) return preco;
        return (coberturas > 1) ? preco + 2 : preco + 1;
    }

    /**
     * Este versão utiliza algumas cláusulas de guarda e já dá pra perceber que uma
     * parte do é checagem de pré-condições enquanto a segunda é o cálculo de fato.
     */
    public int precoSorvete3(boolean premium, boolean casquinha, int coberturas) {
        if (! premium && casquinha)
            throw new IllegalArgumentException("Somente premium tem casquinha");
        if (! casquinha && coberturas > 1)
            throw new IllegalArgumentException("Somente premium + casquinha pode ter mais de uma cobertura");
        if (coberturas > 3)
            throw new IllegalArgumentException("O máximo de coberturas permitido é 3");
        int preco = 15 + 1 + 1;  // copo + 1 cob
        if (!premium) return preco;
        preco = 20 + 1 + 1;      // copo + 1 cob
        if (!casquinha) return preco;
        return (coberturas > 1) ? preco + 2 : preco + 1;
    }

    /**
     * Este versão utiliza desloca a checagem de pré-condições para outro método.
     */
    public int precoSorvete4(boolean premium, boolean casquinha, int coberturas) {
        checkParametros(premium, casquinha, coberturas);
        int preco = 15 + 1 + 1;  // copo + 1 cob
        if (!premium) return preco;
        preco = 20 + 1 + 1;      // copo + 1 cob
        if (!casquinha) return preco;
        return (coberturas > 1) ? preco + 2 : preco + 1;
    }

    void checkParametros(boolean premium, boolean casquinha, int coberturas) {
        if (! premium && casquinha)
            throw new IllegalArgumentException("Somente premium tem casquinha");
        if (! casquinha && coberturas > 1)
            throw new IllegalArgumentException("Somente premium + casquinha pode ter mais de uma cobertura");
        if (coberturas > 3)
            throw new IllegalArgumentException("O máximo de coberturas permitido é 3");
    }

}
