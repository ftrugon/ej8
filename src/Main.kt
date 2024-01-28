import kotlin.math.min
/**
 * Clase que representa un libro con título, autor, número de páginas y calificación.
 *
 * @property titulo Título del libro.
 * @property autor Autor del libro.
 * @property numpag Número de páginas del libro.
 * @property calificacion Calificación del libro (valor entre 0.0 y 10.0).
 */
class Libro(val titulo:String, val autor:String, val numpag:Int, val calificacion:Double){
    /**
     * Devuelve una representación en cadena del libro.
     *
     * @return Cadena que representa el libro.
     */
    override fun toString(): String {
        return "$titulo - $autor (Páginas: $numpag, Calificación: $calificacion)"
    }

}

/**
 * Clase que representa un conjunto de libros con funcionalidades como agregar, eliminar y mostrar libros.
 *
 * @property capacidad Capacidad máxima del conjunto de libros.
 */
class ConjuntoLibros(val capacidad:Int ){
    // Conjunto que almacena los libros
    val libros = mutableSetOf<Libro>()

    /**
     * Añade un libro al conjunto de libros.
     *
     * @param libro Libro a añadir.
     */
    fun anadirlibro(libro: Libro){
        if (libros.size < capacidad){
            libros.add(libro)
        }else println("La capacidad maxima del conjunto de libros se ha alcanzado")
    }

    /**
     * Elimina libros del conjunto por autor.
     *
     * @param autor Autor de los libros a eliminar.
     */
    fun eliminarporautor(autor: String){
        for (libro in libros){
            if (libro.autor == autor){
                libros.remove(libro)
            }
        }
    }

    /**
     * Elimina libros del conjunto por título.
     *
     * @param titulo Título de los libros a eliminar.
     */
    fun eliminarportitulo(titulo: String){
        for (libro in libros){
            if (libro.titulo == titulo){
                libros.remove(libro)
            }
        }
    }

    /**
     * Muestra el libro con la mayor calificación en el conjunto.
     */
    fun mostrarmayor(){
        val libromaxcal = libros.maxBy { it.calificacion }
        println("El libro con mayor calificacion es $libromaxcal")
    }

    /**
     * Muestra el libro con la menor calificación en el conjunto.
     */
    fun mostrarmenor(){
        val libromenorcal = libros.minBy { it.calificacion }
        println("El libro con menor calificacion es $libromenorcal")
    }

    /**
     * Muestra todos los libros en el conjunto.
     */
    fun mostrartodo(){
        println("Se mostrara todo")
        for (libro in libros){
            println(libro)
        }
    }

}
/**
 * Función principal
 */
fun main() {
    val libro1 = Libro("Librogenerico1", "ribery", 500, 9.3)
    val libro2 = Libro("Leyenda del fuchboll", "El rey pele", 300, 8.3)

    val conjuntoLibros = ConjuntoLibros(5)

    conjuntoLibros.anadirlibro(libro1)
    conjuntoLibros.anadirlibro(libro2)

    //conjuntoLibros.eliminarportitulo("Leyenda del fuchboll")
    //conjuntoLibros.eliminarporautor("ribery")

    val libro3 = Libro("Awana bum", "bam bam", 400, 10.0)
    conjuntoLibros.anadirlibro(libro3)

    conjuntoLibros.mostrarmenor()
    conjuntoLibros.mostrarmayor()
    conjuntoLibros.mostrartodo()
}