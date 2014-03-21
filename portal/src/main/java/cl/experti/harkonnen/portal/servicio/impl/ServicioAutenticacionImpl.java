package cl.experti.harkonnen.portal.servicio.impl;

import cl.experti.harkonnen.modelo.Acceso;
import cl.experti.harkonnen.portal.servicio.ServicioAutenticacion;
import cl.experti.harkonnen.portal.utils.PortalUtils;
import cl.experti.harkonnen.portal.utils.SecurityUtils;
import cl.experti.harkonnen.servicio.ServicioAcceso;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sebastián Salazar Molina <ssalazar@orangepeople.cl>
 */
@Service("servicioAutenticacion")
public class ServicioAutenticacionImpl implements ServicioAutenticacion, Serializable {

    @Resource(name = "servicioAcceso")
    private ServicioAcceso servicioAcceso;
    private static final Logger logger = LoggerFactory.getLogger(ServicioAutenticacionImpl.class);

    @Override
    public boolean autenticar(String usuario, String password) {
        String contrasena = SecurityUtils.md5(password);
        return servicioAcceso.autenticar(usuario, contrasena);
    }

    @Override
    public List<GrantedAuthority> getRoles(String usuario) {
        List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
        roles.add(new SimpleGrantedAuthority("ROLE_USER"));
        return roles;
    }

    @Override
    public void registrarAcceso(String usuario) {
        try {
            if (StringUtils.isNotBlank(usuario)) {
                Acceso acceso = new Acceso();
                acceso.setFecha(new Date());
                acceso.setIp(PortalUtils.getIp());
                acceso.setTipo("WEB");
                acceso.setUsuario(StringUtils.lowerCase(usuario));
                servicioAcceso.guardar(acceso);
            }
        } catch (Exception e) {
            logger.error("Error al registrar acceso: {}", e.toString());
            logger.debug("Error al registrar acceso: ", e);
        }
    }
}
