package cl.experti.harkonnen.portal.servicio;

import java.util.List;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author Sebastián Salazar Molina <ssalazar@orangepeople.cl>
 */
public interface ServicioAutenticacion {

    public boolean autenticar(String usuario, String password);

    List<GrantedAuthority> getRoles(String usuario);
    
    public void registrarAcceso(String usuario);
}
