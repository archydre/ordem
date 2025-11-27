class Ordem {
    private var listaInterna: MutableList<Int> = mutableListOf()

    private var tam: Int = 0

    fun add(number: Int) {
        listaInterna.add(number)
        tam = listaInterna.size
    }

    fun Saida() {
        println("Lista atual (Tamanho $tam): ${listaInterna.joinToString()}")
    }

    fun Bubble() {
        if (tam <= 1) return

        for (i in 0 until tam - 1) {
            for (j in 0 until tam - 1 - i) {

                if (listaInterna[j] > listaInterna[j + 1]) {
                    // Troca (swap)
                    val temp = listaInterna[j]
                    listaInterna[j] = listaInterna[j + 1]
                    listaInterna[j + 1] = temp
                }
            }
        }
    }

    fun Insertion() {
        if (tam <= 1) return

        for (i in 1 until tam) {
            val chave = listaInterna[i]
            var j = i - 1

            while (j >= 0 && listaInterna[j] > chave) {
                listaInterna[j + 1] = listaInterna[j]
                j--
            }

            listaInterna[j + 1] = chave
        }
    }

    fun Selection() {
        if (tam <= 1) return

        for (i in 0 until tam - 1) {
            var indiceMinimo = i

            for (j in i + 1 until tam) {
                if (listaInterna[j] < listaInterna[indiceMinimo]) {
                    indiceMinimo = j
                }
            }

            val temp = listaInterna[indiceMinimo]
            listaInterna[indiceMinimo] = listaInterna[i]
            listaInterna[i] = temp
        }
    }

    fun MergeSort() {
        Merge(0, tam - 1)
    }

    private fun Merge(p: Int, r: Int) {
        if (p < r) {
            val q = (p + r) / 2

            Merge(p, q)
            Merge(q + 1, r)

            Intercala(p, q, r)
        }
    }

    private fun Intercala(p: Int, q: Int, r: Int) {
        val n1 = q - p + 1
        val n2 = r - q

        val L = mutableListOf<Int>()
        val R = mutableListOf<Int>()

        for (i in 0 until n1) L.add(listaInterna[p + i])
        for (j in 0 until n2) R.add(listaInterna[q + 1 + j])

        var i = 0
        var j = 0
        var k = p

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                listaInterna[k] = L[i]
                i++
            } else {
                listaInterna[k] = R[j]
                j++
            }
            k++
        }

        while (i < n1) {
            listaInterna[k] = L[i]
            i++
            k++
        }

        while (j < n2) {
            listaInterna[k] = R[j]
            j++
            k++
        }
    }

    fun QuickSort() {
        Quick(0, tam - 1)
    }

    private fun Quick(p: Int, r: Int) {
        if (p < r) {
            val pi = Separa(p, r)

            Quick(p, pi - 1)
            Quick(pi + 1, r)
        }
    }

    private fun Separa(p: Int, r: Int): Int {
        val pivo = listaInterna[r]
        var i = (p - 1)

        for (j in p until r) {
            if (listaInterna[j] <= pivo) {
                i++
                val temp = listaInterna[i]
                listaInterna[i] = listaInterna[j]
                listaInterna[j] = temp
            }
        }

        val temp = listaInterna[i + 1]
        listaInterna[i + 1] = listaInterna[r]
        listaInterna[r] = temp

        return i + 1
    }
}