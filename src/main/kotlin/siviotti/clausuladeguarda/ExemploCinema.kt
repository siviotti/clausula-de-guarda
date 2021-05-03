package siviotti.clausuladeguarda

import java.lang.IllegalArgumentException
import java.sql.Time

class CinemaComClausulaDeGuarda (val salas: List<Sala>){


    fun entrar(espectador: Espectador){
        if (espectador.tiquete == null){
            return
        }
        val sala = salas[espectador.tiquete.sala]
        sala.assistir(espectador)
    }


}

class CinemaSemClausulaDeGuarda (val salas: List<Sala>){


    fun entrar(espectador: Espectador){
        if (espectador.tiquete != null){
            val sala = salas[espectador.tiquete.sala]
            sala.assistir(espectador)
        }
    }


}

fun dif(espectador: Espectador){

    // "Estilo" 1: Se atende a pré-condição, faz
    if (espectador.tiquete != null){
        // faz o que tem que fazer
    }

    // "Estilo" 2: Se não atende a pré-condição, sai
    if (espectador.tiquete == null){
        // Dispara uma exceção ou dá "return"
    }
    // faz o que tem que fazer

}

class Sala (val filme: Filme, val horarios: List<Time>){
    fun assistir (espectador: Espectador){

    }
}

data class Assento (val fileira: Int, val letra: Char)

data class Filme (val nome: String)

data class Espectador (val tiquete: Tiquete?)

data class Tiquete (val sala: Int, val assento: Assento, val horario: Time)
