package uniandes.cupi2.administradorSalones.mundo;

/**
 * Enumeriación con las posibles categorias de un salón
 * @author alvar-go
 *
 */
public enum CategoriaSalon
{
    REGULAR ("Regular", "Salón con sillas y posibilidad de video bean"),
    SILLAS_MOVIBLES ("Sillas Movibles", "Permite mover las sillas del salón"),
    SILLAS_MESAS_MOVIBLES("Sillas y Mesas movibles", "Permite mover las mesas y las sillas del salon"),
    MOVIL_EXPRESS("Con Móvil express", "Tiene la posibilidad de solicitar móvil express"),
    AUDITORIO("Tipo Auditorio", "Diseñado para clases magistrales"),
    SIN_CATEGORIA("", "Sin categoria");

    /**
     * Nombre de la categoria
     */
    private String nombre;

    /**
     * Descripción de la categoria
     */
    private String descripcion;

    /**
     * Crea una categoria
     * @param nNombre el nombre de la categoria. nNombre != null
     * @param nDescripcion la descripción de la categoria. descripcion != null
     */
    private CategoriaSalon(String nNombre, String nDescripcion)
    {
        nombre = nNombre;
        descripcion = nDescripcion;
    }

    /**
     * Da el nombre de la categoria
     * @return nombre
     */
    public String darNombre()
    {
        return nombre;
    }

    /**
     * Da la descripción de la categoria
     * @return descripcion
     */
    public String darDescripcion()
    {
        return descripcion;
    }

    /**
     * Indica si la categoria puede ser secundaria o no
     * @param c la categoria de la que se desea indagar. c !=null
     * @return true si la categoria puede ser secundaria o false en caso contrario
     */
    public static boolean puedeSerSecundaria(CategoriaSalon c)
    {
        return !c.equals( REGULAR );
    }

    /**
     * Indica si la categoria puede ser primaria o no
     * @param c la categoria de la que se desea indagar. c !=null
     * @return true si la categoria puede ser primaria o false en caso contrario
     */
    public static boolean puedeSerPrimaria(CategoriaSalon c)
    {
        return !c.equals( SIN_CATEGORIA );
    }
    public String toString()
    {
        return nombre;
    }
}
