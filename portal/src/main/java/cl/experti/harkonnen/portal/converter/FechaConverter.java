package cl.experti.harkonnen.portal.converter;

import cl.experti.harkonnen.portal.utils.FechaUtils;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FechaConverter implements Converter, Serializable {

    private static final Logger logger = LoggerFactory.getLogger(FechaConverter.class);
    public final static String DEFAULT_DATE_PATTERN = "dd/MM/yyyy";

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        Date fecha = null;
        try {
            fecha = FechaUtils.getFechaFromStr(string);
        } catch (Exception e) {
            logger.error("Error al parsear string a fecha");
            logger.error(e.getMessage());
        }

        return fecha;
    }
    
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {

        String resultado = StringUtils.EMPTY;

        try {
            SimpleDateFormat formato = new SimpleDateFormat(DEFAULT_DATE_PATTERN);
            resultado = formato.format(o);
        } catch (Exception e) {
            logger.error("Problemas para convertir fecha a string");
            logger.error(e.getMessage());
        }

        return resultado;
    }    
    
}
