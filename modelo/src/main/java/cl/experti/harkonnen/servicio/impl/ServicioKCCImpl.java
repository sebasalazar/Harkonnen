package cl.experti.harkonnen.servicio.impl;

import cl.experti.harkonnen.modelo.Kcc;
import cl.experti.harkonnen.modelo.TipoKcc;
import cl.experti.harkonnen.repository.KccRepository;
import cl.experti.harkonnen.repository.TipoKccRepository;
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

    @Resource(name = "tipoKccRepository")
    private TipoKccRepository tipoKccRepository;
    @Resource(name = "kccRepository")
    private KccRepository kccRepository;
    private static final Logger logger = LoggerFactory.getLogger(ServicioKCCImpl.class);

    @Override
    public TipoKcc getTipoKCC(Integer id) {
        TipoKcc tipoKCC = null;
        try {
            if (id != null) {
                tipoKCC = tipoKccRepository.findOne(id);
            }
        } catch (Exception e) {
            tipoKCC = null;
            logger.error("Error al obtener tipo KCC: {}", e.toString());
            logger.debug("Error al obtener tipo KCC: ", e);
        }
        return tipoKCC;
    }

    @Override
    public TipoKcc getTipoKCC(String tipo) {
        TipoKcc tipoKCC = null;
        try {
            if (StringUtils.isNotBlank(tipo)) {
                tipoKCC = tipoKccRepository.findByTipoIgnoreCase(tipo);
            }
        } catch (Exception e) {
            tipoKCC = null;
            logger.error("Error al obtener tipo KCC: {}", e.toString());
            logger.debug("Error al obtener tipo KCC: ", e);
        }
        return tipoKCC;
    }

    @Override
    public List<TipoKcc> getTiposKCCs() {
        List<TipoKcc> tiposKCCs = new ArrayList<TipoKcc>();
        try {
            tiposKCCs = tipoKccRepository.findAll();
        } catch (Exception e) {
            tiposKCCs = new ArrayList<TipoKcc>();
            logger.error("Error al obtener tipos de KCC: {}", e.toString());
            logger.error("Error al obtener tipos de KCC: ", e);
        }
        return tiposKCCs;
    }

    @Override
    @Transactional
    public TipoKcc guardar(TipoKcc tipoKCC) {
        TipoKcc salida = null;
        try {
            if (tipoKCC != null) {
                salida = tipoKccRepository.save(tipoKCC);
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
    public boolean eliminar(TipoKcc tipoKCC) {
        boolean resultado = false;
        try {
            if (tipoKCC != null) {
                tipoKccRepository.delete(tipoKCC);
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
    public Kcc getKcc(Long id) {
        Kcc kcc = null;
        try {
            if (id != null) {
                kcc = kccRepository.findOne(id);
            }
        } catch (Exception e) {
            kcc = null;
            logger.error("Error al obtener KCC: {}", e.toString());
            logger.debug("Error al obtener KCC: ", e);
        }
        return kcc;
    }

    @Override
    public Kcc getKcc(String carpeta) {
        Kcc kcc = null;
        try {
            if (StringUtils.isNotBlank(carpeta)) {
                kcc = kccRepository.findByCarpetaIgnoreCase(carpeta);
            }
        } catch (Exception e) {
            kcc = null;
            logger.error("Error al obtener KCC: {}", e.toString());
            logger.debug("Error al obtener KCC: ", e);
        }
        return kcc;
    }

    @Override
    public List<Kcc> getKccs() {
        List<Kcc> kccs = new ArrayList<Kcc>();
        try {
            kccs = kccRepository.findAll();
        } catch (Exception e) {
            logger.error("Error al obtener KCCs: {}", e.toString());
            logger.debug("Error al obtener KCCs: ", e);
        }
        return kccs;
    }

    @Override
    public List<Kcc> getKccs(String usuario) {
        List<Kcc> kccs = new ArrayList<Kcc>();
        try {
            kccs = kccRepository.findAll();
        } catch (Exception e) {
            logger.error("Error al obtener KCCs: {}", e.toString());
            logger.debug("Error al obtener KCCs: ", e);
        }
        return kccs;
    }

    @Override
    public List<Kcc> getKccs(TipoKcc tipoKCC) {
        List<Kcc> kccs = new ArrayList<Kcc>();
        try {
            if (tipoKCC != null) {
                kccs = kccRepository.findByTipoKCC(tipoKCC);
            }
        } catch (Exception e) {
            logger.error("Error al obtener KCCs: {}", e.toString());
            logger.debug("Error al obtener KCCs: ", e);
        }
        return kccs;
    }

    @Override
    @Transactional
    public Kcc guardar(Kcc kcc) {
        Kcc salida = null;
        try {
            if (kcc != null) {
                salida = kccRepository.save(kcc);
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
    public boolean eliminar(Kcc kcc) {
        boolean resultado = false;
        try {
            if (kcc != null) {
                kccRepository.delete(kcc);
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
