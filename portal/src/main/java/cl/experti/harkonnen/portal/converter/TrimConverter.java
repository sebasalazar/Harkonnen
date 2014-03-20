package cl.experti.harkonnen.portal.converter;

import java.io.Serializable;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import org.apache.commons.lang3.StringUtils;

public class TrimConverter implements Converter, Serializable {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return StringUtils.trimToEmpty(string);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {

        if (o != null) {
            return StringUtils.trimToEmpty(o.toString());
        } else {
            return null;
        }
    }
}