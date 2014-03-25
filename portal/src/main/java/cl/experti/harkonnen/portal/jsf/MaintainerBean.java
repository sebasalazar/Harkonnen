package cl.experti.harkonnen.portal.jsf;

import cl.experti.harkonnen.modelo.BaseBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sebastián Salazar Molina <ssalazar@orangepeople.cl>
 * @param <T>
 */
public abstract class MaintainerBean<T extends BaseBean> implements Serializable {

    private boolean edicion = false;
    private T seleccionado = null;
    private List<T> datos = new ArrayList<T>();

    public boolean isEdicion() {
        return edicion;
    }

    public void setEdicion(boolean edicion) {
        this.edicion = edicion;
    }

    public T getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(T seleccionado) {
        this.seleccionado = seleccionado;
        if (seleccionado != null) {
            this.edicion = true;
        }
    }

    public List<T> getDatos() {
        return datos;
    }

    public void setDatos(List<T> datos) {
        this.datos = datos;
    }

    public abstract void refrescar();

    public abstract String guardar();

    public abstract String eliminar();
}
