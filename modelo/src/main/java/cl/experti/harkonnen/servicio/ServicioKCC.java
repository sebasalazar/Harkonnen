package cl.experti.harkonnen.servicio;

import cl.experti.harkonnen.modelo.Kcc;
import cl.experti.harkonnen.modelo.TipoKcc;
import java.util.List;

/**
 *
 * @author Sebastián Salazar Molina <ssalazar@experti.cl>
 */
public interface ServicioKCC {

    public TipoKcc getTipoKCC(Integer id);

    public TipoKcc getTipoKCC(String tipo);

    public List<TipoKcc> getTiposKCCs();

    public TipoKcc guardar(TipoKcc tipoKCC);

    public boolean eliminar(TipoKcc tipoKCC);

    public Kcc getKcc(Long id);

    public Kcc getKcc(String carpeta);

    public List<Kcc> getKccs();

    public List<Kcc> getKccs(String usuario);

    public List<Kcc> getKccs(TipoKcc tipoKCC);

    public Kcc guardar(Kcc kcc);

    public boolean eliminar(Kcc kcc);
}
