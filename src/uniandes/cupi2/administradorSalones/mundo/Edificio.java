package uniandes.cupi2.administradorSalones.mundo;

import java.util.ArrayList;

/**
 * Created by David on 22/01/2016.
 */
public class Edificio
{

    /**
     * Identificador del edificio
     */
    private String identificador;

    /**
     * Salones del edificio
     */
    private ArrayList<Salon> salones;

    /**
     * Crea un nuevo edificio
     * post: se ha inicializado la lista de salones vacia
     * @param id el identificador del edificio. id!= null
     */
    public Edificio( String id )
    {
        identificador = id;
        salones = new ArrayList<Salon>( );
    }

    /**
     * Indica la cantidad de salones del edificio
     * @return cantidad salones
     */
    public int darCantidadSalones()
    {
        return salones.size( );
    }

    /**
     * Devuelve los salones del edificio
     * @return salones
     */
    public ArrayList<Salon> darSalones()
    {
        return salones;
    }

    /**
     * Agrega un salón al edificio
     * pre: la lista de salones está inicializada
     * @param d los datos del salón en formato [EDIFICIO_NUMERO;CAPACIDAD]
     */
    public void agregarSalon( String[] d )
    {
        String nom = d[0].trim( );
        int c = Integer.parseInt( d[1].trim( ) );
        Salon s = buscarSalon(nom);
        if(s == null)
        {
            s = new Salon( nom, c, CategoriaSalon.REGULAR, CategoriaSalon.SIN_CATEGORIA );
            salones.add( s );
        }

    }

    /**
     * Busca un salón dado su identificador
     * pre: la lsita de salones está inicializada
     * @param nom identificador del salón buscado. nom != null
     * @return el salón buscado o null en caso que no exista
     */
    private Salon buscarSalon( String nom )
    {
        Salon s = null;
        for( int i = 0; i < salones.size( ) && s == null; i++ )
        {
            Salon ac = salones.get( i );
            if(ac.darIdentificador().equals(nom))
            {
                s = ac;
            }
        }

        return s;
    }

    /**
     * Devuelve el identificador del salón
     * @return identificador
     */
    public String darIdentificador( )
    {
        return identificador;
    }


    /**
     * Cambia la información de un salón del edificio
     * Pre: la lista de salones está inicializada, el salón existe en el edificio
     * @param id el identificador del salón. id != null
     * @param c la nueva capacidad del salón
     * @param cat la nueva categoría primaria del salón. cat != null
     * @param cat2 la nueva categoría secundaria del salón. cat2 != null
     */
    public void cambiarSalon( String id, int c, CategoriaSalon cat, CategoriaSalon cat2 )
    {
        Salon s = buscarSalon( id );
        s.cambiarCapacidad(c);
        s.cambiarCategoriaPrimaria(cat);
        s.cambiarCategoriaSecundaria(cat2);

    }

    public String toString()
    {
        return identificador;
    }

    /**
     * Da el salón con mayor capacidad del edificio selecionado
     * @param edi El edificio
     */

    public Salon salonMayorCapacidad( ) {
        Salon s = null;
        int max = 0;
        for( int i = 0; i < salones.size(); i++ )
        {
            Salon ac = salones.get( i );
            if(ac.darCapacidad() > max)
            {
                s = ac;
                max  = ac.darCapacidad();
            }
        }

        return s;
    }



}