import animals.Animal
import java.util.*

open class Group<T: Identifiable> {
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

inline fun <reified T: Animal> getAnimalSummary(animal: T): String {
    return "Summary - id: ${animal.id}, species: ${animal.species}, age: ${animal.age}, type: ${T::class}"
}