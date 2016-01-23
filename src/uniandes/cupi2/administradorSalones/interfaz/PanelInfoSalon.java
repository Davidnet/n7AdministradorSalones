package uniandes.cupi2.administradorSalones.interfaz;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import uniandes.cupi2.administradorSalones.mundo.CategoriaSalon;

/**
 * Panel para mostrar la información de un salón
 * @author alvar-go
 *
 */
public class PanelInfoSalon extends JPanel implements ActionListener
{
    /**
     * Constante para el botón guardar
     */
    public final static String GUARDAR = "Guardar";

    /**
     * Caja de texto para mostrar el id del salón
     */
    private JTextField txtId;

    /**
     * Caja de texto para mostrar la capacidad del salón
     */
    private JTextField txtCapacidad;

    /**
     * Lista desplegable para mostrar la categoria primaría del salón
     */
    private JComboBox cbCatPrimaria;

    /**
     * Lista desplegable para mostrar la categoria secundaria del salón
     */
    // Declare un combo box para mostrar la categoría secundaría del salón
    private JComboBox cbCatSecundaria;
    /**
     * Botón guardar
     */
    private JButton btGuardar;

    /**
     * Clase principal de la aplicación
     */
    private InterfazAdminsitradorSalones principal;

    /**
     * Crea un nuevo panel de información
     * @param interfaz clase principal de la aplicación
     */
    public PanelInfoSalon(InterfazAdminsitradorSalones interfaz)
    {
        principal = interfaz;
        setLayout( new GridLayout( 5, 2, 0, 40 ) );
        setBorder( BorderFactory.createTitledBorder( "Información Salon" ) );


        txtId = new JTextField( "" );
        txtId.setEditable( false );
        txtCapacidad = new JTextField( "" );
        cbCatPrimaria = new JComboBox(  );
        // Inicialice la lista desplegable para la categoría secundaría
        cbCatSecundaria = new JComboBox( );
        for(CategoriaSalon c: CategoriaSalon.values( ))
        {
            cbCatPrimaria.addItem( c );
        }
        // Agregue todas las posibles categorías a la lista desplegable para la categoría secundaria
        for(CategoriaSalon c: CategoriaSalon.values()){
            if (CategoriaSalon.puedeSerSecundaria(c)) {
                cbCatSecundaria.addItem(c);
            }
        }
        add(new JLabel( "  Identificador:"));
        add(txtId);
        add(new JLabel( "  Capacidad:"));
        add(txtCapacidad);
        add( new JLabel( " Primaria:"));
        add(cbCatPrimaria);
        add( new JLabel( " Secundaria:"));
        // agregue al panel la lista desplegable para la categoría secundaria
        add(cbCatSecundaria);
        btGuardar = new JButton(GUARDAR );
        btGuardar.setActionCommand( GUARDAR  );
        btGuardar.addActionListener( this );
        add(btGuardar);

        txtCapacidad.setEnabled( false );
        cbCatPrimaria.setEnabled( false );
        // Deshabilite la lista desplegable para la categoría secundaria
        cbCatSecundaria.setEnabled(false);
    }

    public void actualizar(String id, int capacidad, CategoriaSalon primaria, CategoriaSalon secundaria)
    {

        txtCapacidad.setEnabled( true );
        cbCatPrimaria.setEnabled( true );
        // Habilite la lista dessplegable para la categoría secundaria
        cbCatSecundaria.setEnabled( true );
        txtId.setText( id );
        txtCapacidad.setText( "" + capacidad );
        cbCatPrimaria.setSelectedItem( primaria );
        // indique que el elemento seleccionado en la lista desplegable para la categoría secundaria es el parámetro secundaria
        cbCatSecundaria.setSelectedItem( secundaria );

    }

    public void actionPerformed( ActionEvent ev )
    {
        String c = ev.getActionCommand( );
        if(c.equals( GUARDAR ))
        {
            String id = txtId.getText( );
            String cap = txtCapacidad.getText( );
            CategoriaSalon cat = (CategoriaSalon)cbCatPrimaria.getSelectedItem();
            // Recupere la categoria seleccionada en la lista desplegable para la segunda categoria. Guardela en una variable llamada cat2
            CategoriaSalon cat2 = (CategoriaSalon)cbCatSecundaria.getSelectedItem();
            principal.cambiarSalon(id, cap, cat, cat2);
        }

    }
}
