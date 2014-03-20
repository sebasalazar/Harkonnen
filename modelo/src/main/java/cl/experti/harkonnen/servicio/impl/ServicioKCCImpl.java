package cl.experti.harkonnen.servicio.impl;

import cl.experti.harkonnen.modelo.KCC;
import cl.experti.harkonnen.modelo.TipoKCC;
import cl.experti.harkonnen.repository.KCCRepository;
import cl.experti.harkonnen.repository.TipoKCCRepository;
import cl.experti.harkonnen.servicio.ServicioKCC;
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
@Service("servicioKCC")
public class ServicioKCCImpl implements ServicioKCC, Serializable {

    @Resource(name = "tipoKCCRepository")
    private TipoKCCRepository tipoKCCRepository;
    @Resource(name = "kCCRepository")
    private KCCRepository kCCRepository;
    private static final Logger logger = LoggerFactory.getLogger(ServicioKCCImpl.class);

    @Override
    public TipoKCC getTipoKCC(Integer id) {
        TipoKCC tipoKCC = null;
        try {
            if (id != null) {
                tipoKCC = tipoKCCRepository.findOne(id);
            }
        } catch (Exception e) {
            tipoKCC = null;
            logger.error("Error al obtener tipo KCC: {}", e.toString());
            logger.debug("Error al obtener tipo KCC: ", e);
        }
        return tipoKCC;
    }

    @Override
    public List<TipoKCC> getTiposKCCs() {
        List<TipoKCC> tiposKCCs = new ArrayList<TipoKCC>();
        try {
            tiposKCCs = tipoKCCRepository.findAll();
        } catch (Exception e) {
            tiposKCCs = new ArrayList<TipoKCC>();
            logger.error("Error al obtener tipos de KCC: {}", e.toString());
            logger.error("Error al obtener tipos de KCC: ", e);
        }
        return tiposKCCs;
    }

    @Override
    @Transactional
    public TipoKCC guardar(TipoKCC tipoKCC) {
        TipoKCC salida = null;
        try {
            if (tipoKCC != null) {
                salida = tipoKCCRepository.save(tipoKCC);
                if (salida != null) {
                    logger.info("TipoKCC persistido con id {}", salida.getId());
                }
            }
        } catch (Exception e) {
            salida = null;
            logger.error("Error al guardar tipoKCC: {}", e.toString());
            logger.debug("Error al guardar tipoKCC: ", e);
        }
        return salida;
    }

    @Override
    @Transactional
    public boolean eliminar(TipoKCC tipoKCC) {
        boolean resultado = false;
        try {
            if (tipoKCC != null) {
                tipoKCCRepository.delete(tipoKCC);
                resultado = true;
            }
        } catch (Exception e) {
            resultado = false;
            logger.error("Error al eliminar tipoKCC: {}", e.toString());
            logger.debug("Error al eliminar tipoKCC: ", e);
        }
        return resultado;
    }

    @Override
    public KCC getKcc(Long id) {
        KCC kcc = null;
        try {
            if (id != null) {
                kcc = kCCRepository.findOne(id);
            }
        } catch (Exception e) {
            kcc = null;
            logger.error("Error al obtener KCC: {}", e.toString());
            logger.debug("Error al obtener KCC: ", e);
        }
        return kcc;
    }

    @Override
    public KCC getKcc(String carpeta) {
        KCC kcc = null;
        try {
            if (StringUtils.isNotBlank(carpeta)) {
                kcc = kCCRepository.findByCarpetaIgnoreCase(carpeta);
            }
        } catch (Exception e) {
            kcc = null;
            logger.error("Error al obtener KCC: {}", e.toString());
            logger.debug("Error al obtener KCC: ", e);
        }
        return kcc;
    }

    @Override
    public List<KCC> getKccs() {
        List<KCC> kccs = new ArrayList<KCC>();
        try {
            kccs = kCCRepository.findAll();
        } catch (Exception e) {
            logger.error("Error al obtener KCCs: {}", e.toString());
            logger.debug("Error al obtener KCCs: ", e);
        }
        return kccs;
    }

    @Override
    public List<KCC> getKccs(String usuario) {
        List<KCC> kccs = new ArrayList<KCC>();
        try {
            kccs = kCCRepository.findAll();
        } catch (Exception e) {
            logger.error("Error al obtener KCCs: {}", e.toString());
            logger.debug("Error al obtener KCCs: ", e);
        }
        return kccs;
    }

    @Override
    public List<KCC> getKccs(TipoKCC tipoKCC) {
        List<KCC> kccs = new ArrayList<KCC>();
        try {
            if (tipoKCC != null) {
                kccs = kCCRepository.findByTipoKCC(tipoKCC);
            }
        } catch (Exception e) {
            logger.error("Error al obtener KCCs: {}", e.toString());
            logger.debug("Error al obtener KCCs: ", e);
        }
        return kccs;
    }

    @Override
    @Transactional
    public KCC guardar(KCC kcc) {
        KCC salida = null;
        try {
            if (kcc != null) {
                salida = kCCRepository.save(kcc);
                if (salida != null) {
                    logger.info("KCC persistido con id {}", salida.getId());
                }
            }
        } catch (Exception e) {
            salida = null;
            logger.error("Error al guardar KCC: {}", e.toString());
            logger.debug("Error al guardar KCC: ", e);
        }
        return salida;
    }

    @Override
    @Transactional
    public boolean eliminar(KCC kcc) {
        boolean resultado = false;
        try {
            if (kcc != null) {
                kCCRepository.delete(kcc);
                resultado = true;
            }
        } catch (Exception e) {
            resultado = false;
            logger.error("Error al eliminar KCC: {}", e.toString());
            logger.debug("Error al eliminar KCC: ", e);
        }
        return resultado;
    }
}
