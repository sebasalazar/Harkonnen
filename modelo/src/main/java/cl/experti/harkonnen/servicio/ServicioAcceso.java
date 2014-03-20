package cl.experti.harkonnen.servicio;

import cl.experti.harkonnen.modelo.Acceso;
import java.util.List;

/**
 *
 * @author Sebastián Salazar Molina <ssalazar@experti.cl>
 */
public interface ServicioAcceso {

    public Acceso getAcceso(Long id);

    public List<Acceso> getAccesos(String usuario);

    public List<Acceso> getAccesos();

    public Acceso guardar(Acceso acceso);

    public boolean eliminar(Acceso acceso);
    
    public boolean autenticar(String usuario, String password);
}
