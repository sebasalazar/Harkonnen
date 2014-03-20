package cl.experti.harkonnen.repository;

import cl.experti.harkonnen.modelo.Kcc;
import cl.experti.harkonnen.modelo.TipoKcc;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Sebastián Salazar Molina <ssalazar@experti.cl>
 */
@Resource(name = "kccRepository")
public interface KccRepository extends JpaRepository<Kcc, Long> {

    public Kcc findByCarpetaIgnoreCase(String carpeta);

    public List<Kcc> findByTipoKCC(TipoKcc tipoKCC);
}
