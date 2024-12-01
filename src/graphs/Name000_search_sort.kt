package graphs

object Name000_search_sort {
    // Create insertion sort
    // Name time complexity
    // O(n^2), becaise of the fact we use two loops once for and while

    private val listToSort = mutableListOf(0, 4, 2, 1, 5, -4)

    fun insertionSort(list: MutableList<Int> = listToSort): List<Int> {

        for (i in 1 until list.size) {
            val key = list[i] // liczba 4 poczatkowa
            var j = i - 1 // liczba 0

            while (j >= 0 && list[j] > key) {
                list[j+1] = list[j]
                j--
            }
            list[j+1] = key
        }

        return list.toList()
    }

    fun mergeSort(arr: MutableList<Int>) {
        if (arr.size <= 1) return // Warunek zakończenia rekurencji (gdy tablica ma 1 element, jest już posortowana)

        val middle = arr.size / 2
        val left = arr.slice(0 until middle).toMutableList() // Tworzymy kopię lewej części
        val right = arr.slice(middle until arr.size).toMutableList() // Tworzymy kopię prawej części

        mergeSort(left)  // Rekursywne sortowanie lewej części
        mergeSort(right) // Rekursywne sortowanie prawej części

        merge(arr, left, right)  // Scalanie posortowanych części
    }

    fun merge(arr: MutableList<Int>, left: List<Int>, right: List<Int>) {
        var i = 0 // Indeks dla lewej części
        var j = 0 // Indeks dla prawej części
        var k = 0 // Indeks dla głównej tablicy

        // Scalanie dwóch posortowanych tablic
        while (i < left.size && j < right.size) {
            if (left[i] <= right[j]) {
                arr[k] = left[i]
                i++
            } else {
                arr[k] = right[j]
                j++
            }
            k++
        }

        // Kopiowanie pozostałych elementów z lewej tablicy, jeśli są
        while (i < left.size) {
            arr[k] = left[i]
            i++
            k++
        }

        // Kopiowanie pozostałych elementów z prawej tablicy, jeśli są
        while (j < right.size) {
            arr[k] = right[j]
            j++
            k++
        }
    }

    fun binarySearch(array: IntArray = intArrayOf(1, 3, 5, 7, 9, 11, 13, 15), target: Int = 7): Int {

        var left = 0
        var right = array.size - 1

        while (left <= right) {
            val middle = left + (right - left) / 2  // mozna tez (left + right) /2 ale int ma
            // ograniczenia a dzieki temu dodajemy polowe rozicy

            when {
                array[middle] == target -> return middle.also {
                    println("Element $target znaleziony na indeksie $it.")
                } // Znaleziono element, zwróć indeks
                array[middle] < target -> left = middle + 1 // Szukaj w prawej części
                else -> right = middle - 1 // Szukaj w lewej części
            }
        }

        println("Element $target nie został znaleziony.")

        return -1 // Element nie został znaleziony
    }
}

