package cl.experti.harkonnen.modelo;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Sebastián Salazar Molina <ssalazar@experti.cl>
 */
public class KCC extends BaseBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk", nullable = false)
    private Long id = null;
    @Column(name = "usuario", nullable = false)
    private String usuario = null;
    @JoinColumn(name = "tipo_kcc_fk", referencedColumnName = "pk", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private TipoKCC tipoKCC = null;
    @Column(name = "carpeta", unique = true)
    private String carpeta = null;
    @Column(name = "medcom")
    private Integer medcom = 1;
    @Column(name = "paramverifcom")
    private Integer paramVerifCom = 1;
    @Column(name = "urlcgicom")
    private String urlCgiCom = null;
    @Column(name = "servercom")
    private String serverCom = "201.238.207.132";
    @Column(name = "portcom")
    private Integer portCom = 80;
    @Column(name = "whilelistcom")
    private String whileListCom = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789._-:=?/~";
    @Column(name = "host")
    private String host = null;
    @Column(name = "wport")
    private Integer wport = 80;
    @Column(name = "urlcgitra")
    private String urlCgiTra = "/filtroUnificado/bp_revision.cgi";
    @Column(name = "urlcgimedtra")
    private String urlCgiMedTra = "/filtroUnificado/bp_validacion.cgi";
    @Column(name = "servertra")
    private String serverTra = "https://certificacion.webpay.cl";
    @Column(name = "porttra")
    private Integer portTra = 6443;
    @Column(name = "prefijo_conf_tr")
    private String prefijoConfTr = "HTML_";
    @Column(name = "cierre")
    private String cierre = null;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public TipoKCC getTipoKCC() {
        return tipoKCC;
    }

    public void setTipoKCC(TipoKCC tipoKCC) {
        this.tipoKCC = tipoKCC;
    }

    public String getCarpeta() {
        return carpeta;
    }

    public void setCarpeta(String carpeta) {
        this.carpeta = carpeta;
    }

    public Integer getMedcom() {
        return medcom;
    }

    public void setMedcom(Integer medcom) {
        this.medcom = medcom;
    }

    public Integer getParamVerifCom() {
        return paramVerifCom;
    }

    public void setParamVerifCom(Integer paramVerifCom) {
        this.paramVerifCom = paramVerifCom;
    }

    public String getUrlCgiCom() {
        return urlCgiCom;
    }

    public void setUrlCgiCom(String urlCgiCom) {
        this.urlCgiCom = urlCgiCom;
    }

    public String getServerCom() {
        return serverCom;
    }

    public void setServerCom(String serverCom) {
        this.serverCom = serverCom;
    }

    public Integer getPortCom() {
        return portCom;
    }

    public void setPortCom(Integer portCom) {
        this.portCom = portCom;
    }

    public String getWhileListCom() {
        return whileListCom;
    }

    public void setWhileListCom(String whileListCom) {
        this.whileListCom = whileListCom;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getWport() {
        return wport;
    }

    public void setWport(Integer wport) {
        this.wport = wport;
    }

    public String getUrlCgiTra() {
        return urlCgiTra;
    }

    public void setUrlCgiTra(String urlCgiTra) {
        this.urlCgiTra = urlCgiTra;
    }

    public String getUrlCgiMedTra() {
        return urlCgiMedTra;
    }

    public void setUrlCgiMedTra(String urlCgiMedTra) {
        this.urlCgiMedTra = urlCgiMedTra;
    }

    public String getServerTra() {
        return serverTra;
    }

    public void setServerTra(String serverTra) {
        this.serverTra = serverTra;
    }

    public Integer getPortTra() {
        return portTra;
    }

    public void setPortTra(Integer portTra) {
        this.portTra = portTra;
    }

    public String getPrefijoConfTr() {
        return prefijoConfTr;
    }

    public void setPrefijoConfTr(String prefijoConfTr) {
        this.prefijoConfTr = prefijoConfTr;
    }

    public String getCierre() {
        return cierre;
    }

    public void setCierre(String cierre) {
        this.cierre = cierre;
    }
}
