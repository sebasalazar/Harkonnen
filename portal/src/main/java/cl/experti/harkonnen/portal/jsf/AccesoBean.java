package cl.experti.harkonnen.portal.jsf;

import cl.experti.harkonnen.modelo.Acceso;
import cl.experti.harkonnen.portal.utils.FechaUtils;
import cl.experti.harkonnen.portal.utils.SecurityUtils;
import cl.experti.harkonnen.servicio.ServicioAcceso;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Sebastián Salazar Molina <ssalazar@orangepeople.cl>
 */
@Component
@Scope("view")
@Qualifier("accesoBean")
public class AccesoBean implements Serializable {

    @Resource(name = "servicioAcceso")
    private ServicioAcceso servicioAcceso;
    private Date inicio = null;
    private Date fin = null;
    private String usuario = null;
    private Acceso acceso = null;
    private List<Acceso> accesos = null;
    private static final Logger logger = LoggerFactory.getLogger(AccesoBean.class);

    @PostConstruct
    public void iniciar() {
        this.usuario = SecurityUtils.getRemoteUser();
        Date ahora = new Date();
        this.inicio = FechaUtils.inicioDia(ahora);
        this.fin = FechaUtils.finDia(ahora);
        this.accesos = servicioAcceso.getAccesos(usuario, inicio, fin);
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = FechaUtils.inicioDia(inicio);
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = FechaUtils.finDia(fin);
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Acceso getAcceso() {
        return acceso;
    }

    public void setAcceso(Acceso acceso) {
        this.acceso = acceso;
    }

    public List<Acceso> getAccesos() {
        return accesos;
    }

    public void setAccesos(List<Acceso> accesos) {
        this.accesos = accesos;
    }

    public String buscar() {
        String accion = "";
        try {
            this.accesos = servicioAcceso.getAccesos(usuario, inicio, fin);
        } catch (Exception e) {
            logger.error(e.toString());
            logger.debug("Error al buscar", e);
        }
        return accion;
    }
}
