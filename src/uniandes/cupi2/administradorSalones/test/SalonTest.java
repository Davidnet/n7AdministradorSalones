package uniandes.cupi2.administradorSalones.test;

import static org.junit.Assert.*;
import junit.framework.TestCase;
import uniandes.cupi2.administradorSalones.mundo.CategoriaSalon;
import uniandes.cupi2.administradorSalones.mundo.Salon;

/**
 * Created by David on 22/01/2016.
 */
public class SalonTest extends TestCase {

    private Salon salon;

    @org.junit.Before
    public void setUp() throws Exception {
        salon = new Salon( "id", 10, CategoriaSalon.AUDITORIO, CategoriaSalon.MOVIL_EXPRESS );
    }

    @org.junit.Test
    public void testDarCapacidad() throws Exception {
        assertEquals( "La capacidad es erronea", 10, salon.darCapacidad( ) );
    }

    @org.junit.Test
    public void testCambiarCapacidad() throws Exception {
        salon.cambiarCapacidad( 200 );
        assertEquals( "La capacidad es erronea", 200, salon.darCapacidad( ) );
    }


}