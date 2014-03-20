package cl.experti.harkonnen.portal.converter;

import java.io.Serializable;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.SerializationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Sebastián Salazar Molina <ssalazar@orangepeople.cl>
 */
public class BaseBeanConverter implements Converter, Serializable {

    private static final Logger logger = LoggerFactory.getLogger(BaseBeanConverter.class);

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        Object resultado = null;
        byte[] serObj = null;
        try {
            serObj = Hex.decodeHex(string.toCharArray());
            resultado = SerializationUtils.deserialize(serObj);
        } catch (Exception e) {
            resultado = null;
            logger.error(e.toString());
            logger.debug("Error al convertir string: " + string, e);
        }
        return resultado;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object objeto) {
        String resultado = "";
        try {
            byte[] serObj = SerializationUtils.serialize((Serializable) objeto);
            resultado = new String(Hex.encodeHex(serObj));
        } catch (Exception e) {
            resultado = "";
            logger.error(e.toString());
            logger.debug("Error al convertir objeto : " + objeto, e);
        }
        return resultado;
    }
}
