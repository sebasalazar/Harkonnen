package cl.experti.harkonnen.portal.jsf;

import cl.experti.harkonnen.modelo.TipoKcc;
import cl.experti.harkonnen.portal.utils.FacesUtils;
import cl.experti.harkonnen.servicio.ServicioKCC;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
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
@Scope("view")
@Qualifier("tipoKccBean")
public class TipoKccBean extends MaintainerBean<TipoKcc> {

    @Resource(name = "servicioKCC")
    private ServicioKCC servicioKCC;
    private static final Logger logger = LoggerFactory.getLogger(TipoKccBean.class);

    @PostConstruct
    public void iniciar() {
        refrescar();
    }

    @Override
    public void refrescar() {
        this.setSeleccionado(new TipoKcc());
        this.setEdicion(false);
        this.setDatos(servicioKCC.getTiposKCCs());
    }

    @Override
    public String guardar() {
        String resultado = "";
        try {
            TipoKcc tipoKcc = getSeleccionado();
            TipoKcc salida = servicioKCC.guardar(tipoKcc);
            if (salida != null) {
                FacesUtils.infoMessage("guardadoExitoso");
                refrescar();
            } else {
                FacesUtils.errorMessage("guardadoFallido");
            }
        } catch (Exception e) {
            String errorMsg = FacesUtils.getFormattedMessage("errorFatal", e.toString());
            FacesUtils.fatal(errorMsg);

            logger.error("Error al guardar tipo kcc: {}", e.toString());
            logger.error("Error al guardar tipo kcc ", e);
        }
        return resultado;
    }

    @Override
    public String eliminar() {
        String resultado = "";
        try {
            TipoKcc tipoKcc = getSeleccionado();
            boolean ok = servicioKCC.eliminar(tipoKcc);
            if (ok) {
                FacesUtils.infoMessage("eliminacionExitosa");
                refrescar();
            } else {
                FacesUtils.errorMessage("eliminacionFallida");
            }
        } catch (Exception e) {
            String errorMsg = FacesUtils.getFormattedMessage("errorFatal", e.toString());
            FacesUtils.fatal(errorMsg);

            logger.error("Error al eliminar tipo kcc: {}", e.toString());
            logger.debug("Error al eliminar tipo kcc", e);
        }
        return resultado;
    }
}
