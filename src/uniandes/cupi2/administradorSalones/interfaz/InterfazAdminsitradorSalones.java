package uniandes.cupi2.administradorSalones.interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.*;

import uniandes.cupi2.administradorSalones.mundo.CategoriaSalon;
import uniandes.cupi2.administradorSalones.mundo.Edificio;
import uniandes.cupi2.administradorSalones.mundo.Salon;
import uniandes.cupi2.administradorSalones.mundo.Universidad;

/**
 * Clase principal de la aplicación
 * @author alvar-go
 *
 */
public class InterfazAdminsitradorSalones extends JFrame
{
    /**
     * Panel con la lista de edificios
     */
    private PanelEdificios panelEdificios;

    /**
     * Panel con la lista de salones
     */
    private PanelSalones panelSalones;

    /**
     * Panel con la información del salón
     */
    private PanelInfoSalon panelInfoSalon;

    /**
     * Panel de extensión
     */
    private PanelExtension panelExtension;

    /**
     * Clase principal del mundo
     */
    private Universidad universidad;

    /**
     * Crea la ventana del programa
     */
    public InterfazAdminsitradorSalones()
    {
        setTitle( "Administrador salones" );
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable( false );
        setSize( 700, 400 );

        setLayout( new BorderLayout( ) );

        panelEdificios = new PanelEdificios( this );
        panelSalones = new PanelSalones( this );
        panelInfoSalon = new PanelInfoSalon( this);
        panelExtension = new PanelExtension( this );

        JPanel panelCentral = new JPanel( new GridLayout( 1, 3,5,5 ));
        panelCentral.add( panelEdificios );
        panelCentral.add( panelSalones );
        panelCentral.add(panelInfoSalon);
        add(panelCentral, BorderLayout.CENTER);

        add(panelExtension, BorderLayout.SOUTH);

        universidad = new Universidad( );
        cargar( );
        panelEdificios.actualizar( universidad.darEdificios() );
        setLocationRelativeTo( null );
    }

    /**
     * Actuliza el panel con la lista de salones
     * @param e el edificio del que se desea mostrar los salones. e != null
     */
    public void actualizarSalones( Edificio e )
    {

        panelSalones.actualizar( "data/imagenes/" + e.darIdentificador( ) + ".jpg", e.darSalones( ) );

    }

    /**
     * Actualiza la información del panel de salones
     * @param s el salón del que se desea mostrar la información. s!=null
     */
    public void actualizarInfoSalon( Salon s )
    {
        panelInfoSalon.actualizar( s.darIdentificador( ), s.darCapacidad( ), s.darCategoriaPrimaria( ), s.darCategoriaSecundaria( ) );

    }

    /**
     * Cambia la información de un salón.
     * @param id el identificador del salón. id != null
     * @param cap la nueva capacidad del salón.
     * @param cat la nueva categoría primaria del salón. cat !=null
     * @param cat2 la nueva categoría secundaria del salón. cat !=null
     */
    public void cambiarSalon( String id, String cap, CategoriaSalon cat, CategoriaSalon cat2 )
    {
        if(cap != null && !cap.trim( ).equals( "" ))
        {
            try
            {
                int c = Integer.parseInt( cap );
                if(CategoriaSalon.puedeSerPrimaria( cat ))
                {
                    if(CategoriaSalon.puedeSerSecundaria( cat2 ))
                    {
                        universidad.cambiarSalon(id, c, cat, cat2);
                        JOptionPane.showMessageDialog( this, "Se han realizado los cambios", "Cambios", JOptionPane.INFORMATION_MESSAGE );
                    }
                    else
                    {
                        JOptionPane.showMessageDialog( this, "La categoria seleccionada no puede ser secundaria", "Error", JOptionPane.ERROR_MESSAGE );
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog( this, "Debe existir categoria primaria", "Error", JOptionPane.ERROR_MESSAGE );
                }
            }
            catch( Exception e )
            {
                JOptionPane.showMessageDialog( this, "Ingrese una capacidad numérica", "Error", JOptionPane.ERROR_MESSAGE );
            }
        }
        else
        {
            JOptionPane.showMessageDialog( this, "Ingrese una capacidad", "Error", JOptionPane.ERROR_MESSAGE );
        }

    }

    /**
     * Método de extensión 1
     */
    public void reqFuncOpcion1( )
    {
        Edificio edificiossel = panelEdificios.darEdificioSeleccionado();
        Salon salonmaxcapacidad = edificiossel.salonMayorCapacidad();
        String message =  salonmaxcapacidad + " con " + salonmaxcapacidad.darCapacidad();
        JOptionPane.showMessageDialog(this, "El salon mas grande encontrado es " + message + " salones");

    }

    /**
     * Método de extensión 2
     */
    public void reqFuncOpcion2( )
    {


    }

    public static void main( String[] args )
    {
        InterfazAdminsitradorSalones i = new InterfazAdminsitradorSalones( );
        i.setVisible( true );
    }


    private void cargar()
    {
        try
        {
            File f = new File("data/salones.csv");
            BufferedReader in = new BufferedReader( new FileReader( f ) );
            String l = in.readLine( );
            l = in.readLine( );
            while(l!=null)
            {
                String[] d = l.split( ";" );
                if( d.length == 2 && d[0].trim( ).length( ) > 0 && d[0].contains( "_" ) && d[1].trim( ).length( ) > 1 )
                {
                    universidad.agregarSalon(d);

                }

                l = in.readLine( );
            }
            in.close( );

        }
        catch( Exception e )
        {
            //Se ignora
        }
    }

}
