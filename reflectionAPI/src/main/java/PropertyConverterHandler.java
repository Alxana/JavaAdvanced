import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class PropertyConverterHandler implements RuntimeHandler {

    public PropertyConverterMetadata process(Object parameter) {
        Class converterClass;
        String converterMethod;
        PropertyConverterMetadata propMeta = null;
        Method method = (Method) parameter;
        PropertyConverter annotation;

        if (method.isAnnotationPresent(PropertyConverter.class)) {
            annotation = method.getAnnotation(PropertyConverter.class);
            converterMethod = annotation.converterMethod();
            converterClass = annotation.converterClass();
            propMeta = new PropertyConverterMetadata(converterClass, converterMethod);
        }

        return propMeta;
    }
}
