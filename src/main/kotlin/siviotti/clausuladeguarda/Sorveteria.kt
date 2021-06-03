package siviotti.clausuladeguarda

/**
 * Classe para trazer o código Java e ver o IntelliJ
 * converter de Java para Kotlin usando a funçõe
 * de cláusula de guarda "require".
 */
class Sorveteria {
    fun precoSorvete(premium: Boolean, casquinha: Boolean, coberturas: Int): Int {
        require(!(!premium && casquinha)) { "Somente premium tem casquinha" }
        require(!(!casquinha && coberturas > 1)) { "Somente premium + casquinha pode ter mais de uma cobertura" }
        require(coberturas <= 3) { "O máximo de coberturas permitido é 3" }
        var preco = 15 + 1 + 1 // copo + 1 cob
        if (!premium) return preco
        preco = 20 + 1 + 1 // copo + 1 cob
        if (!casquinha) return preco
        return if (coberturas > 1) preco + 2 else preco + 1
    }

    // Cole o método Sorvete.precoSorvete3 aqui
    // o código convertido deve ser similar ao de cima
    open fun precoSorvete3(premium: Boolean, casquinha: Boolean, coberturas: Int): Int {
        require(!(!premium && casquinha)) { "Somente premium tem casquinha" }
        require(!(!casquinha && coberturas > 1)) { "Somente premium + casquinha pode ter mais de uma cobertura" }
        require(coberturas <= 3) { "O máximo de coberturas permitido é 3" }
        var preco = 15 + 1 + 1 // copo + 1 cob
        if (!premium) return preco
        preco = 20 + 1 + 1 // copo + 1 cob
        if (!casquinha) return preco
        return if (coberturas > 1) preco + 2 else preco + 1
    }

}