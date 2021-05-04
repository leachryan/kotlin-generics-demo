class Adoption<out T> (private val forAdoption: T) {
    fun getAdoption(): T = forAdoption
}