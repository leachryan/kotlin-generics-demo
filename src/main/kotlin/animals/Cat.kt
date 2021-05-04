package animals

import enums.CatBreeds
import enums.Species

class Cat(val name: String, val breed: CatBreeds, override val age: Int): Animal(Species.FELINE, age)