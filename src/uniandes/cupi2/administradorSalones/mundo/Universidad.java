package uniandes.cupi2.administradorSalones.mundo;

/**
 * Created by David on 22/01/2016.
 */

import java.util.ArrayList;

public class Universidad {

    /**
     * Los edificios de la universidad
     */
    private ArrayList<Edificio> edificios;

    /**
     * Crea una nueva universidad
     * post: se ha inicializado la lista de edificios como vacia
     */
    public Universidad() {
        edificios = new ArrayList<Edificio>();
    }

    /**
     * agrega un salón a la universidad
     * pre: la lista de salones se encuentra inicializada
     * post: Si no existia eledificio del salón se ha agregado a la universidad
     *
     * @param d datos del salón en el formato [EDIFICIO_NUMERO;CAPACIDAD]]
     */
    public void agregarSalon(String[] d) {
        Edificio e = buscarEdificio(d[0].trim().split("_")[0]);
        if (e == null) {
            e = new Edificio(d[0].trim().split("_")[0]);
            edificios.add(e);
        }
        e.agregarSalon(d);

    }

    /**
     * Busca un edificio a partir de su identificador
     * pre: la lista de edificios está inicializada
     *
     * @param nomEdificio identificador del edificio. nomEdificio != null
     * @return el edificio buscado o null en caso que no exista
     */
    private Edificio buscarEdificio(String nomEdificio) {
        Edificio e = null;
        for (int i = 0; i < edificios.size() && e == null; i++) {
            Edificio ac = edificios.get(i);
            if (ac.darIdentificador().equals(nomEdificio)) {
                e = ac;
            }
        }

        return e;
    }

    /**
     * Devuelve la lista de edificios de la universidad
     *
     * @return edificios
     */
    public ArrayList<Edificio> darEdificios() {
        return edificios;
    }

    /**
     * Cambia la información de un salón de la universidad
     * pre: la lista de edificios se encuentra inicializado. El saloón existe en la universidad
     *
     * @param id   el identificador del salón. id != null
     * @param c    la nueva capacidad del salón
     * @param cat  la nueva categoría primaria del salón. cat != null
     * @param cat2 la nueva categoría secundaria del salón. cat2 != null
     */
    public void cambiarSalon(String id, int c, CategoriaSalon cat, CategoriaSalon cat2) {
        String nEd = id.split("_")[0];
        Edificio e = buscarEdificio(nEd);
        e.cambiarSalon(id, c, cat, cat2);

    }
}



