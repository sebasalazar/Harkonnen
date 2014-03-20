package cl.experti.harkonnen.repository;

import cl.experti.harkonnen.modelo.TipoKCC;
import javax.annotation.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Sebastián Salazar Molina <ssalazar@experti.cl>
 */
@Resource(name = "tipoKCCRepository")
public interface TipoKCCRepository extends JpaRepository<TipoKCC, Integer> {

}
