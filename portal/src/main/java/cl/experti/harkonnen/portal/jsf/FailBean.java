package cl.experti.harkonnen.portal.jsf;

import cl.experti.harkonnen.portal.utils.FechaUtils;
import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Sebastián Salazar Molina <ssalazar@experti.cl>
 */
@Component
@Scope("request")
@Qualifier("failBean")
public class FailBean implements Serializable {

    private String generado = null;
    private static final Logger logger = LoggerFactory.getLogger(FailBean.class);

    @PostConstruct
    public void iniciar() {
        try {
            Date now = new Date();
            this.generado = FechaUtils.getFechaHoraStr(now);
        } catch (Exception e) {
            logger.error("Error al construir el FailBean: {}", e.toString());
            logger.debug("Error al construir el FailBean", e);
        }
    }

    public String getGenerado() {
        return generado;
    }
}
