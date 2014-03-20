package cl.experti.harkonnen.servicio;

/**
 *
 * @author Sebastián Salazar Molina <ssalazar@experti.cl>
 */
public interface ServicioAutenticacion {
    public boolean autenticar(String usuario, String password);
}
