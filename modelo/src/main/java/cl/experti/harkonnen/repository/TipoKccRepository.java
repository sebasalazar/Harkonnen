package cl.experti.harkonnen.repository;

import cl.experti.harkonnen.modelo.TipoKcc;
import javax.annotation.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Sebastián Salazar Molina <ssalazar@experti.cl>
 */
@Resource(name = "tipoKccRepository")
public interface TipoKccRepository extends JpaRepository<TipoKcc, Integer> {

    public TipoKcc findByTipoIgnoreCase(String tipo);
}
