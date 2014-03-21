package cl.experti.harkonnen.portal.utils;

import java.io.Serializable;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author Sebastián Salazar Molina <sebasalazar@gmail.com>
 */
public abstract class SecurityUtils implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(SecurityUtils.class);

    public static Integer getRemoteUser() {
        Integer remoteUser = null;
        try {
            remoteUser = Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getName());
        } catch (Exception e) {
            remoteUser = null;
            logger.error(e.toString());
        }
        return remoteUser;
    }

    public static boolean isUserInRole(String role) {
        boolean resultado = false;
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            resultado = authentication.getAuthorities().contains(new SimpleGrantedAuthority(role));
        } catch (Exception e) {
            resultado = false;
            logger.error(e.toString());
        }
        return resultado;
    }

    public static String sha256(String texto) {
        String resultado = "";
        try {
            if (!StringUtils.isEmpty(texto)) {
                resultado = DigestUtils.sha256Hex(texto);
            }
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return resultado;
    }

    public static String sha1(String texto) {
        String resultado = "";
        try {
            if (!StringUtils.isEmpty(texto)) {
                resultado = DigestUtils.sha1Hex(texto);
            }
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return resultado;
    }

    public static String md5(String texto) {
        String resultado = "";
        try {
            if (!StringUtils.isEmpty(texto)) {
                resultado = DigestUtils.md5Hex(texto);
            }
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return resultado;
    }
}
