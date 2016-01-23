package uniandes.cupi2.administradorSalones.interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import uniandes.cupi2.administradorSalones.mundo.Edificio;
import uniandes.cupi2.administradorSalones.mundo.Salon;

/**
 * Panel para presentar los salones de un edificio
 * @author alvar-go
 *
 */
public class PanelSalones extends JPanel implements ListSelectionListener
{

    /**
     * Lista de salones
     */
    // declare un JList para mostrar los salones del edificio.
    private JList listaSalones;
    /**
     * Label apa presentar la imagen del edificio
     */
    private JLabel lbImagen;

    /**
     * clase principal de la aplicación
     */
    private InterfazAdminsitradorSalones principal;

    /**
     * Crea un nuevo panel de salones
     * @param interfaz clase principal de la aplicación
     */
    public PanelSalones(InterfazAdminsitradorSalones interfaz)
    {
        principal = interfaz;
        setLayout( new BorderLayout( ) );
        setBorder( BorderFactory.createTitledBorder( "Salones" ) );

        // inicialice el JList
        listaSalones = new JList();
        // indique que en el JList solo se puede seleccionar un elemento
        listaSalones.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        // indique que el panel responsable de actuar cuando se selecciona un elemento del Jlist es este
        listaSalones.addListSelectionListener(this);
        // Cree barra de desplazamiento (JScrollPane) para la lista de salones
        JScrollPane scroll = new JScrollPane( listaSalones );
        // Indique que siempre se debe mostrar la barra de desplazamiento horizontal
        scroll.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );
        //Indique que siempre se debe mostrar la barra de desplazamiento vertical
        scroll.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
        /* Check Agregue las barras de desplazamiento con la lista de salones en el centro del panel */
        add(scroll, BorderLayout.CENTER);

        lbImagen = new JLabel( );
        lbImagen.setHorizontalAlignment( JLabel.CENTER );
        add(lbImagen, BorderLayout.NORTH);
    }

    /**
     * Acutaliza el panel con la información por parámetro
     * @param imagen la imagen del edificio que se desea mostrar
     * @param salones los salones que se desea mostrar en la lista
     */
    public void actualizar(String imagen, ArrayList<Salon> salones)
    {
        lbImagen.setIcon( new ImageIcon( imagen ) );
        //indique que en la lista se deben mostrar los salones del Array que llega por parámetro
        listaSalones.setListData( salones.toArray());
        // deje seleccionado el primer elemento de la lista
        listaSalones.setSelectedIndex(0);
    }

    /**
     * Método que se ejecuta cuando se selecciona un elemento de la lsita
     */
    public void valueChanged( ListSelectionEvent ev )
    {
        //Check Recupere el salón seleccionado
        Salon s = (Salon)listaSalones.getSelectedValue();
        //Check Si se seleccioná un salón (no es nulo) llame al método actualizarInfoSalon de la clase principal
        if (s != null) {
            principal.actualizarInfoSalon(s);
        }
    }
}
