package animals

import Identifiable
import enums.Species
import java.util.*

open class Animal(val species: Species, open val age: Int): Identifiable(UUID.randomUUID())

fun <T: Animal> getAnimalSpecies(animal: T): Species = animal.species