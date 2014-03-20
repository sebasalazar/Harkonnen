package cl.experti.harkonnen.portal.utils;

import java.io.Serializable;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Sebastián Salazar Molina <ssalazar@orangepeople.cl>
 */
public abstract class PortalUtils implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(PortalUtils.class);

    public static String getIp() {
        String ip = "127.0.0.1";
        try {
            HttpServletRequest request = (HttpServletRequest) FacesUtils.getRequest();
            if (request != null) {
                ip = StringUtils.trimToEmpty(request.getHeader("X-Forwarded-For"));
                if (StringUtils.isEmpty(ip)) {
                    ip = request.getRemoteAddr();
                }
            } else {
                logger.error("Request NULO");
            }
        } catch (Exception e) {
            ip = "127.0.0.1";
            logger.error(e.toString());
            logger.debug("Error al obtener Ip", e);
        }

        return ip;
    }
}
