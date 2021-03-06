package cl.experti.harkonnen.portal.security;

import cl.experti.harkonnen.portal.servicio.ServicioAutenticacion;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

@Service("harkonnenAuthenticationProvider")
public class HarkonnenAuthenticationProvider implements AuthenticationProvider {

    @Resource(name = "servicioAutenticacion")
    private ServicioAutenticacion servicioAutenticacion;
    private final static Logger logger = LoggerFactory.getLogger(HarkonnenAuthenticationProvider.class);

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Authentication usuario = null;

        String username = StringUtils.lowerCase((String) authentication.getPrincipal());
        String password = StringUtils.trimToEmpty((String) authentication.getCredentials());

        boolean autenticacion = servicioAutenticacion.autenticar(username, password);
        logger.info("Autenticación de '{}' con contraseña '{}' resultado '{}'", username, password, autenticacion);
        // @Hack Temporal
        autenticacion = true;
        if (!autenticacion) {
            String mensajeError = "Usuario o contraseña inválidos";
            throw new BadCredentialsException(mensajeError);
        } else {
            List<GrantedAuthority> roles = servicioAutenticacion.getRoles(username);
            if (!roles.isEmpty()) {
                logger.debug(roles.toString());
                usuario = new UsernamePasswordAuthenticationToken(username, password, roles);
                if (!usuario.isAuthenticated()) {
                    String mensajeError = "Usuario o contraseña inválidos";
                    throw new BadCredentialsException(mensajeError);
                } else {
                    servicioAutenticacion.registrarAcceso(username);
                }
            } else {
                String mensajeSinRoles = "No tiene privilegio para acceder al sistema";
                throw new BadCredentialsException(mensajeSinRoles);
            }
        }

        return usuario;
    }

    @Override
    public boolean supports(Class<?> type) {
        return UsernamePasswordAuthenticationToken.class.equals(type);
    }
}
