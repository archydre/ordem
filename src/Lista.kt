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

    fun add(elemento: T) {
        val novoNo = Node(data = elemento)

        if (head == null) {
            head = novoNo
            tail = novoNo
        } else {
            tail?.next = novoNo
            novoNo.previous = tail
            tail = novoNo
        }
        tamanho++
    }

    fun addFirst(elemento: T) {
        val novoNo = Node(data = elemento)

        if (head == null) {
            head = novoNo
            tail = novoNo
        } else {
            novoNo.next = head
            head?.previous = novoNo
            head = novoNo
        }
        tamanho++
    }

    fun removeFirst(): T {
        if (head == null) {
            throw NoSuchElementException("A lista está vazia.")
        }

        val elementoRemovido = head!!.data
        head = head!!.next

        if (head == null) {
            tail = null
        } else {
            head?.previous = null
        }
        tamanho--
        return elementoRemovido
    }

    fun removeLast(): T {
        if (tail == null) {
            throw NoSuchElementException("A lista está vazia.")
        }

        val elementoRemovido = tail!!.data
        tail = tail!!.previous

        if (tail == null) {
            head = null
        } else {
            tail?.next = null
        }
        tamanho--
        return elementoRemovido
    }

    fun get(indice: Int): T {
        if (indice < 0 || indice >= tamanho) {
            throw IndexOutOfBoundsException("Índice $indice fora dos limites.")
        }

        var noAtual = head
        for (i in 0 until indice) {
            noAtual = noAtual?.next
        }

        return noAtual!!.data
    }

    fun clear() {
        head = null
        tail = null
        tamanho = 0
    }

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