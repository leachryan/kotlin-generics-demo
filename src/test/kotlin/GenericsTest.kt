
import animals.Animal
import animals.Cat
import animals.Dog
import animals.getAnimalSpecies
import enums.CatBreeds
import enums.DogBreeds
import enums.Species
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class GenericsTest {

    fun `test generic class`() {
        val group: Group<Animal> = Group()
        val wolf = Animal(Species.CANINE, 2)
        val bobcat = Animal(Species.FELINE, 3)

        group.insert(wolf)
        group.insert(bobcat)

        assertEquals(2, group.getGroupSize())
    }

    @Test
    fun `test generic function`() {
        val expected = Species.FELINE

        val puma = Animal(Species.FELINE, 6)

        assertEquals(expected, getAnimalSpecies(puma))
    }

    @Test
    fun `test generic member function`() {
        val group: Group<Animal> = Group()
        val corgi = Dog("Charlie", DogBreeds.CORGI, 1)
        val torti = Cat("Kit", CatBreeds.TORTI, 5)

        // insert is a generic member function
        group.insert(corgi)
        group.insert(torti)

        assertEquals(corgi, group.fetch(corgi.id))
        assertEquals(torti, group.fetch(torti.id))
    }

    @Test
    fun `test generic extension function`() {
        val group: Group<Animal> = Group()
        val sif = Animal(Species.CANINE, 100)
        val fenrir = Animal(Species.CANINE, 1000)
        val cat = Cat("Jazzy", CatBreeds.TORTI, 5)

        group.insert(sif)
        group.insert(fenrir)
        group.insert(cat)

        val last = group.getLastAnimal()

        assertEquals(cat, last)
    }

    @Test
    fun `test covariance`() {

    }

    @Test
    fun `test contrvariance`() {

    }

    @Test
    fun `test inline function`() {
        val group: Group<Dog> = Group()
        val corgi = Dog("Charlie", DogBreeds.CORGI, 1)
        val collie = Dog("Bessie", DogBreeds.BORDER_COLLIE, 2)
        group.insert(corgi)
        group.insert(collie)

        val matcher: (Animal) -> Boolean = { it.id == corgi.id }

        val first = group.getFirstAnimal(matcher)

        assertEquals(corgi, first)
    }

    @Test
    fun `test reified inline function`() {

    }

}