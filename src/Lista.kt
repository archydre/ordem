private data class Node<T>(
    val data: T,
    var previous: Node<T>? = null,
    var next: Node<T>? = null
)

class Lista<T> {

    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    private var tamanho: Int = 0

    val size: Int
        get() = tamanho

    val isEmpty: Boolean
        get() = tamanho == 0

    // --- Métodos de Manipulação ---

    /**
     * Adiciona um elemento ao final (cauda) da lista.
     * Esta é a operação mais eficiente (O(1)).
     */
    fun add(elemento: T) {
        val novoNo = Node(data = elemento)

        if (head == null) {
            // Se a lista estiver vazia, a cabeça e a cauda são o novo nó
            head = novoNo
            tail = novoNo
        } else {
            // Liga o novo nó (cauda) ao nó atual da cauda
            tail?.next = novoNo
            novoNo.previous = tail
            // Atualiza a cauda para ser o novo nó
            tail = novoNo
        }
        tamanho++
    }

    //

    /**
     * Adiciona um elemento no início (cabeça) da lista.
     */
    fun addFirst(elemento: T) {
        val novoNo = Node(data = elemento)

        if (head == null) {
            head = novoNo
            tail = novoNo
        } else {
            // Liga o novo nó à cabeça atual
            novoNo.next = head
            head?.previous = novoNo
            // Atualiza a cabeça
            head = novoNo
        }
        tamanho++
    }

    /**
     * Remove o nó no início (cabeça) da lista.
     *
     * @return O elemento que foi removido.
     * @throws NoSuchElementException se a lista estiver vazia.
     */
    fun removeFirst(): T {
        if (head == null) {
            throw NoSuchElementException("A lista está vazia.")
        }

        val elementoRemovido = head!!.data
        head = head!!.next

        if (head == null) {
            // A lista ficou vazia
            tail = null
        } else {
            // O novo head não tem um anterior
            head?.previous = null
        }
        tamanho--
        return elementoRemovido
    }

    /**
     * Remove o nó no final (cauda) da lista.
     *
     * @return O elemento que foi removido.
     * @throws NoSuchElementException se a lista estiver vazia.
     */
    fun removeLast(): T {
        if (tail == null) {
            throw NoSuchElementException("A lista está vazia.")
        }

        val elementoRemovido = tail!!.data
        tail = tail!!.previous

        if (tail == null) {
            // A lista ficou vazia
            head = null
        } else {
            // O novo tail não tem um próximo
            tail?.next = null
        }
        tamanho--
        return elementoRemovido
    }

    /**
     * Encontra e retorna o elemento em um índice específico.
     * Requer percorrer a lista (O(n)).
     */
    fun get(indice: Int): T {
        if (indice < 0 || indice >= tamanho) {
            throw IndexOutOfBoundsException("Índice $indice fora dos limites.")
        }

        var noAtual = head
        // Percorre a lista até o índice
        for (i in 0 until indice) {
            noAtual = noAtual?.next
        }

        return noAtual!!.data
    }

    /**
     * Limpa a lista.
     */
    fun clear() {
        head = null
        tail = null
        tamanho = 0
    }

    /**
     * Sobrescreve toString para exibir o conteúdo da lista.
     */
    override fun toString(): String {
        if (head == null) return "[]"

        val sb = StringBuilder("[")
        var noAtual = head

        while (noAtual != null) {
            sb.append(noAtual.data)
            noAtual = noAtual.next
            if (noAtual != null) {
                sb.append(", ")
            }
        }
        sb.append("]")
        return sb.toString()
    }
}