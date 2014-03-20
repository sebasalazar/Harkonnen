package cl.experti.harkonnen.portal.spring;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class CustomXmlWebApplicationContext extends XmlWebApplicationContext {

    @Override
    protected void initBeanDefinitionReader(XmlBeanDefinitionReader reader) {
        super.initBeanDefinitionReader(reader);
        reader.setValidationMode(XmlBeanDefinitionReader.VALIDATION_NONE);
        reader.setNamespaceAware(true);
    }

}
