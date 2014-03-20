package cl.experti.harkonnen.portal.jsf;

import cl.experti.harkonnen.servicio.ServicioAutenticacion;
import java.io.IOException;
import java.io.Serializable;
import javax.annotation.Resource;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
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
@Qualifier("loginBean")
public class LoginBean implements Serializable {

    private String username = null;
    private String password = null;
    @Resource(name = "servicioAutenticacion")
    private ServicioAutenticacion servicioAutenticacion;
    private static final Logger logger = LoggerFactory.getLogger(LoginBean.class);

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String doLogin() throws IOException, ServletException {
        String resultado = null;

        try {
            boolean ok = servicioAutenticacion.autenticar(username, password);
            if (ok) {
                ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();

                RequestDispatcher dispatcher = null;
                dispatcher = ((ServletRequest) context.getRequest()).getRequestDispatcher("/j_spring_security_check");
                dispatcher.forward((ServletRequest) context.getRequest(),
                        (ServletResponse) context.getResponse());

                FacesContext.getCurrentInstance().responseComplete();
            }
        } catch (Exception e) {
            logger.error("Problema al hacer login: {}", e.toString());
            logger.debug("Problema al hacer login: ", e);
        }
        return resultado;
    }
}
