package cl.experti.harkonnen.servicio.impl;

import cl.experti.harkonnen.modelo.Acceso;
import cl.experti.harkonnen.repository.AccesoRepository;
import cl.experti.harkonnen.servicio.ServicioAcceso;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sebastián Salazar Molina <ssalazar@experti.cl>
 */
@Service("servicioAcceso")
public class ServicioAccesoImpl implements ServicioAcceso, Serializable {

    @Resource(name = "accesoRepository")
    private AccesoRepository accesoRepository;
    private static final Logger logger = LoggerFactory.getLogger(ServicioAccesoImpl.class);

    @Override
    public Acceso getAcceso(Long id) {
        Acceso acceso = null;
        try {
            if (id != null) {
                acceso = accesoRepository.findOne(id);
            }
        } catch (Exception e) {
            logger.error("Error al obtener acceso: {}", e.toString());
            logger.debug("Error al obtener acceso: {}", e.toString());
        }
        return acceso;
    }

    @Override
    public List<Acceso> getAccesos(String usuario) {
        List<Acceso> accesos = new ArrayList<Acceso>();
        try {
            if (StringUtils.isNotBlank(usuario)) {
                accesos = accesoRepository.findByUsuario(usuario);
            }
        } catch (Exception e) {
            accesos = new ArrayList<Acceso>();
            logger.error("Error al obtener acceso: {}", e.toString());
            logger.debug("Error al obtener acceso: {}", e.toString());
        }
        return accesos;
    }

    @Override
    public List<Acceso> getAccesos() {
        List<Acceso> accesos = new ArrayList<Acceso>();
        try {
            accesos = accesoRepository.findAll();
        } catch (Exception e) {
            accesos = new ArrayList<Acceso>();
            logger.error("Error al obtener acceso: {}", e.toString());
            logger.debug("Error al obtener acceso: {}", e.toString());
        }
        return accesos;
    }

    @Override
    @Transactional
    public Acceso guardar(Acceso acceso) {
        Acceso salida = null;
        try {
            if (acceso != null) {
                salida = accesoRepository.save(acceso);
                if (salida != null) {
                    logger.info("Acceso persistido con id {}", salida.getId());
                }
            }
        } catch (Exception e) {
            salida = null;
            logger.error("Error al guardar: {}", e.toString());
            logger.error("Error al guardar: ", e);
        }
        return salida;
    }

    @Override
    @Transactional
    public boolean eliminar(Acceso acceso) {
        boolean resultado = false;
        try {
            if (acceso != null) {
                accesoRepository.delete(acceso);
                resultado = true;
            }
        } catch (Exception e) {
            logger.error("Error al eliminar: {}", e.toString());
            logger.debug("Error al eliminar: ", e);
        }
        return resultado;
    }
}