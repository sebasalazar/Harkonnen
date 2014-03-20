package cl.experti.harkonnen.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Sebastián Salazar Molina <ssalazar@experti.cl>
 */
@Entity
@Table(name = "tipos_kcc")
public class TipoKcc extends BaseBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk", nullable = false)
    private Integer id = null;
    @Column(name = "codigo_comercio")
    private String codigoComercio = null;
    @Column(name = "tipo_comercio")
    private String tipoComercio = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigoComercio() {
        return codigoComercio;
    }

    public void setCodigoComercio(String codigoComercio) {
        this.codigoComercio = codigoComercio;
    }

    public String getTipoComercio() {
        return tipoComercio;
    }

    public void setTipoComercio(String tipoComercio) {
        this.tipoComercio = tipoComercio;
    }
}
