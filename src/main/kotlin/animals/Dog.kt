package animals

import enums.DogBreeds
import enums.Species

class Dog(val name: String, val breed: DogBreeds, override val age: Int): Animal(Species.CANINE, age)