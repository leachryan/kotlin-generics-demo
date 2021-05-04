import animals.Animal
import enums.Species

class Owner<in T: Animal> (private val pets: MutableList<T> = mutableListOf()) {
    fun adopt(pet: T) = pets.add(pet)
    fun getPetSpecies(): List<Species> = pets.map { it.species }
}