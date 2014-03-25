package cl.experti.harkonnen.repository;

import cl.experti.harkonnen.modelo.Acceso;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Sebastián Salazar Molina <ssalazar@experti.cl>
 */
@Resource(name = "accesoRepository")
public interface AccesoRepository extends JpaRepository<Acceso, Long> {

    public List<Acceso> findByUsuario(String usuario);

    public List<Acceso> findByUsuarioAndFechaBetween(String usuario, Date inicio, Date fin);
}
