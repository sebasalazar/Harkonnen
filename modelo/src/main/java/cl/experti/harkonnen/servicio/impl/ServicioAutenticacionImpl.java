package cl.experti.harkonnen.servicio.impl;

import cl.experti.harkonnen.ldap.UsuarioRepository;
import cl.experti.harkonnen.modelo.Usuario;
import cl.experti.harkonnen.servicio.ServicioAutenticacion;
import java.io.Serializable;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sebastián Salazar Molina <ssalazar@experti.cl>
 */
@Service("servicioAutenticacion")
public class ServicioAutenticacionImpl implements ServicioAutenticacion, Serializable {

    @Resource(name = "usuarioRepository")
    private UsuarioRepository usuarioRepository;
    private static final Logger logger = LoggerFactory.getLogger(ServicioAutenticacionImpl.class);

    @Override
    public boolean autenticar(String usuario, String password) {
        boolean resultado = false;
        try {
            if (StringUtils.isNotBlank(usuario)) {
                Usuario empleado = usuarioRepository.findByUsuario(usuario);
                if (empleado != null) {
                    resultado = StringUtils.equals(password, empleado.getPassword());
                }
            }
        } catch (Exception e) {
            resultado = false;
            logger.error("Error de autenticacion: {}", e.toString());
            logger.debug("Error de autenticacion: ", e);
        }
        return resultado;
    }
}
