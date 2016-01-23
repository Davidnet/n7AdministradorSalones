package uniandes.cupi2.administradorSalones.interfaz;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import uniandes.cupi2.administradorSalones.mundo.Edificio;

/**
 * Panel para presentar los edificios
 * @author alvar-go
 *
 */
public class PanelEdificios extends JPanel implements ListSelectionListener
{

    /**
     * Lista de edificios
     */
    private JList listaEdificios;

    /**
     * Clase principal de la aplicación
     */
    private InterfazAdminsitradorSalones principal;

    /**
     * Crea un nuevo panel de edificios
     * @param interfaz clase principal de la aplicación. interfaz != null
     */
    public PanelEdificios(InterfazAdminsitradorSalones interfaz)
    {
        principal = interfaz;
        setLayout( new GridLayout( 1, 1 ) );
        setBorder( BorderFactory.createTitledBorder( "Edificios" ) );

        listaEdificios = new JList( );
        listaEdificios.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        listaEdificios.addListSelectionListener( this );

        JScrollPane scroll = new JScrollPane( listaEdificios );
        scroll.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );
        scroll.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
        add(scroll);
    }

    /**
     * Actualiza la lista de edificios con los edificios que llegan por parámetro
     * @param edificios lista de edificios que se desea mostrar
     */
    public void actualizar(ArrayList<Edificio> edificios)
    {
        listaEdificios.setListData( edificios.toArray(  ) );
    }

    /**
     * Devuelve el edificio seleccionado en la lista
     * @return el edificio seleccionado o null si no se ha seleccionado ninguno
     */
    public Edificio darEdificioSeleccionado()
    {
        //completar según documentación
        Edificio e = (Edificio)listaEdificios.getSelectedValue( );
        if(e != null)
        {
            return e;
        }
        return null;
    }

    /**
     * Se ejecuta cuando se selecciona un elemento de la lista de edificios
     */
    public void valueChanged( ListSelectionEvent ev )
    {
        Edificio e = (Edificio)listaEdificios.getSelectedValue( );
        if(e != null)
        {
            principal.actualizarSalones(e);
        }

    }
}
