package cl.experti.harkonnen.ldap;

import cl.experti.harkonnen.modelo.Usuario;
import javax.annotation.Resource;
import org.springframework.ldap.repository.LdapRepository;

/**
 *
 * @author Sebastián Salazar Molina <ssalazar@experti.cl>
 */
@Resource(name = "usuarioRepository")
public interface UsuarioRepository extends LdapRepository<Usuario> {

    public Usuario findByUsuario(String usuario);
}
