package cl.experti.harkonnen.modelo;

import javax.naming.Name;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.Id;

/**
 *
 * @author Sebastián Salazar Molina <ssalazar@experti.cl>
 */
@Entry(objectClasses = {"inetOrgPerson", "organizationalPerson", "person", "top"}, base = "cn=users,dc=orangepeople,dc=cl")
public class Usuario extends BaseBean {

    @Id
    private Name id;
    
    @Attribute(name = "displayName")
    private String nombre = null;

    @Attribute(name = "sn")
    private String usuario = null;

    @Attribute(name = "userPassword")
    private String password = null;

    public Name getId() {
        return id;
    }

    public void setId(Name id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
