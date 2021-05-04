import animals.Animal
import java.util.*

class Group<T: Identifiable> {
    val items: MutableList<T> = mutableListOf()

    fun insert(item: T) = items.add(item)
    fun fetch(id: UUID): T? = items.firstOrNull { it.id == id }

    fun getGroupSize(): Int = items.size

    fun t() {
        items.firstOrNull { it.id == UUID.randomUUID() }
    }
}

fun <T: Animal> Group<T>.getLastAnimal(): T = items.last()

inline fun <T: Animal> Group<T>.getFirstAnimal(matcher: (T) -> Boolean): T? = items.firstOrNull(matcher)