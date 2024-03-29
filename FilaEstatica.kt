class FilaEstatica(tamanho: Int = 10): Enfileiravel {
    private var ponteiroInicio: Int = 0
    private var ponteiroFim: Int = -1
    private var dados: Array<Any?> = arrayOfNulls(tamanho)

    //  métodos auxiliares
    override fun estaCheia(): Boolean {
        return (ponteiroFim == dados.size - 1)
    }

    override fun estaVazia(): Boolean {
        return (ponteiroInicio == ponteiroFim + 1)
    }

    override fun imprimir(): String {
        var impressao: String = "["

        for (i in ponteiroInicio .. ponteiroFim) {
            if (i == ponteiroFim) {
                impressao += "${dados[i]}"
            } else {
                impressao += "${dados[i]}, "
            }
        }

        return "$impressao]"
    }

    // métodos principais
    override fun atualizar(dado: Any?) {
        if (!estaVazia()) {
            dados[ponteiroInicio] = dado
        } else {
            println("Fila Vazia!")
        }
    }

    override fun enfileirar(dado: Any?) {
        if (!estaCheia()) {
            ponteiroFim++
            dados[ponteiroFim] = dado
        }  else {
            println("Fila Cheia!")
        }
    }

    override fun desenfileirar(): Any? {
        var retorno: Any? = null

        if (!estaVazia()) {
            retorno = dados[ponteiroInicio]
            ponteiroInicio--
        } else {
            println("Fila Vazia!")
        }

        return retorno
    }

    override fun frente(): Any? {
        var retorno: Any? = null

        if (!estaVazia()) {
            retorno = dados[ponteiroInicio]
        } else {
            println("Fila Vazia!")
        }

        return retorno
    }
}