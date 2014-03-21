package cl.experti.harkonnen.utils;

import java.io.Serializable;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Sebastián Salazar Molina <ssalazar@experti.cl>
 */
public abstract class HarkonnenUtils implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(HarkonnenUtils.class);

    public static String ldapPasswordHash(String texto) {
        String resultado = "";
        try {
            if (StringUtils.isNotBlank(texto)) {
                String[] split = StringUtils.split(texto, ',');
                StringBuilder sb = new StringBuilder();
                for (String caracter : split) {
                    int n = Integer.parseInt(caracter);
                    sb.append((char) n);
                }

                String base64 = StringUtils.remove(sb.toString(), "{MD5}");
                byte[] hash = Base64.decodeBase64(base64);
                resultado = Hex.encodeHexString(hash);
            }
        } catch (Exception e) {
            logger.error("Error al obtener hash ldap: {}", e.toString());
        }
        return resultado;
    }
}
