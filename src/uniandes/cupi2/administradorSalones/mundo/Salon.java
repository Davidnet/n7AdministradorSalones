package uniandes.cupi2.administradorSalones.mundo;

/**
 * Representa un salón
 * Created by David on 22/01/2016.
 */

public class Salon
{

    /**
     * Identificador del salón
     */
    private String identificador;

    /**
     * Capacidad del salón
     */
    private int capacidad;

    /**
     * Categoria primaria del salón.
     */
    private CategoriaSalon categoriaPrimaria;

    /**
     * Cateogoria secundaria del salón.
     */
    private CategoriaSalon categoriaSecundaria;

    /**
     * Crea un nuevo salón.
     * * @param nIdentificador el id del salón.. nIdentificador != null
     * @param nCapacidad la capacidad del salón.. nCapacidad > 0
     * @param nCategoriaPrimaria la categoria primaria. nCategoriaPrimaria != null
     * @param nCategoriaSecundaria la categoria secundaria. nCategoriaSecundaria != null
     */
    public Salon( String nIdentificador, int nCapacidad, CategoriaSalon nCategoriaPrimaria, CategoriaSalon nCategoriaSecundaria )
    {
        identificador = nIdentificador;
        capacidad =nCapacidad;
        categoriaPrimaria = nCategoriaPrimaria;
        categoriaSecundaria = nCategoriaSecundaria;
    }

    /**
     * Devuelve el identificador del salón.
     * @return identificador
     */
    public String darIdentificador( )
    {
        return identificador;
    }

    /**
     * Devuelve la cpacidad del salón.
     * @return capacidad
     */
    public int darCapacidad( )
    {
        return capacidad;
    }

    /**
     * Devuelve la categoria primaria del salón.
     * @return categoriaPrimaria
     */
    public CategoriaSalon darCategoriaPrimaria( )
    {
        return categoriaPrimaria;
    }

    /**
     * Devuelve la categoria secundaria del salón.
     * @return categoriaSecundaria
     */
    public CategoriaSalon darCategoriaSecundaria( )
    {
        return categoriaSecundaria;
    }


    /**
     * Cambia la capacidad del salón.
     * @param nCapacidad la nueva capacidad del salón.
     */
    public void cambiarCapacidad( int nCapacidad )
    {
        capacidad = nCapacidad;

    }

    /**
     * Cambia la categoria primaria del salón.
     * @param primaria la nueva categoría del salón. primaria != null
     */
    public void cambiarCategoriaPrimaria( CategoriaSalon primaria )
    {
        categoriaPrimaria = primaria;

    }

    /**
     * Cambia la categoria secundaria del salón.
     * @param secundaria la nueva categoría del salón. secundaria != null
     */
    public void cambiarCategoriaSecundaria( CategoriaSalon secundaria )
    {
        categoriaSecundaria = secundaria;

    }

    public String toString()
    {
        return identificador;
    }
}

