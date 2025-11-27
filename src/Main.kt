fun main() {
    val ordenar = Ordem()
    var opcao: Int

    do {
        opcao = MenuOrdenar()

        when (opcao) {
            1 -> {
                print("Digite um número para adicionar à lista: ")
                val numero = readLine()?.toIntOrNull()
                if (numero != null) {
                    ordenar.add(numero)
                    ordenar.Saida()
                } else {
                    println("Entrada inválida. Tente novamente.")
                }
            }
            2 -> {
                println("\n--- ORDENAÇÃO BUBBLESORT ---")
                ordenar.Bubble()
                ordenar.Saida()
            }
            3 -> {
                println("\n--- ORDENAÇÃO INSERTIONSORT ---")
                ordenar.Insertion()
                ordenar.Saida()
            }
            4 -> {
                println("\n--- ORDENAÇÃO SELECTIONSORT ---")
                ordenar.Selection()
                ordenar.Saida()
            }
            5 -> {
                println("\n--- ORDENAÇÃO MERGESORT ---")
                ordenar.MergeSort()
                ordenar.Saida()
            }
            6 -> {
                println("\n--- ORDENAÇÃO QUICKSORT ---")
                ordenar.QuickSort()
                ordenar.Saida()
            }
            7 -> {
                println("Saindo do programa. BOM TRABALHO!")
            }
            else -> {
                println("Opção inválida. Escolha uma opção de 1 a 7.")
            }
        }

        if (opcao != 7) {
            println("\nPressione Enter para continuar...")
            readLine()
        }

    } while (opcao != 7)
}

fun MenuOrdenar(): Int {
    println("\n==================================")
    println("ESCOLHA UMA OPCAO NO MENU LISTA")
    println("==================================")
    println("[1] INSERIR DADO NA LISTA")
    println("[2] ORDENAÇÃO BUBBLESORT")
    println("[3] ORDENAÇÃO INSERTIONSORT")
    println("[4] ORDENAÇÃO SELECTIONSORT")
    println("[5] ORDENAÇÃO MERGESORT")
    println("[6] ORDENAÇÃO QUICKSORT")
    println("[7] SAIR DO PROGRAMA")
    println("----------------------------------")
    print("OPCAO ESCOLHIDA: ")

    return readLine()?.toIntOrNull() ?: 0
}