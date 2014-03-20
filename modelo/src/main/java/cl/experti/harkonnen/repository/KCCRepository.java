package cl.experti.harkonnen.repository;

import cl.experti.harkonnen.modelo.KCC;
import cl.experti.harkonnen.modelo.TipoKCC;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Sebastián Salazar Molina <ssalazar@experti.cl>
 */
@Resource(name = "kCCRepository")
public interface KCCRepository extends JpaRepository<KCC, Long> {

    public KCC findByCarpetaIgnoreCase(String carpeta);

    public List<KCC> findByTipoKCC(TipoKCC tipoKCC);
}
