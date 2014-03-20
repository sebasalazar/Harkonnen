package cl.experti.harkonnen.servicio;

import cl.experti.harkonnen.modelo.KCC;
import cl.experti.harkonnen.modelo.TipoKCC;
import java.util.List;

/**
 *
 * @author Sebastián Salazar Molina <ssalazar@experti.cl>
 */
public interface ServicioKCC {

    public TipoKCC getTipoKCC(Integer id);

    public List<TipoKCC> getTiposKCCs();

    public TipoKCC guardar(TipoKCC tipoKCC);

    public boolean eliminar(TipoKCC tipoKCC);

    public KCC getKcc(Long id);

    public KCC getKcc(String carpeta);

    public List<KCC> getKccs();

    public List<KCC> getKccs(String usuario);

    public List<KCC> getKccs(TipoKCC tipoKCC);

    public KCC guardar(KCC kcc);

    public boolean eliminar(KCC kcc);
}
