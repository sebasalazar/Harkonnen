package cl.experti.harkonnen.portal.servicio.impl;

import cl.experti.harkonnen.portal.servicio.ServicioShell;
import cl.experti.harkonnen.servicio.ServicioAcceso;
import java.io.Serializable;
import javax.annotation.Resource;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sebastián Salazar Molina <sebasalazar@gmail.com>
 */
@Service("servicioShell")
public class ServicioShellImpl implements ServicioShell, Serializable {

    @Resource(name = "servicioAcceso")
    private ServicioAcceso servicioAcceso;
    private static final Logger logger = LoggerFactory.getLogger(ServicioShellImpl.class);

    @Override
    public void prueba() {
        try {

            String comando = String.format("ps aux | grep $USER");
            Process proceso = Runtime.getRuntime().exec(comando);
            proceso.waitFor();

            String salida = StringUtils.trimToEmpty(IOUtils.toString(proceso.getInputStream()));
            logger.debug(salida);

        } catch (Exception e) {
            logger.error(e.toString());
            logger.debug("Error al actualizar Accesos", e);
        }
    }
}
