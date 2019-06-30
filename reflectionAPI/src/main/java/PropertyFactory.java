import lombok.SneakyThrows;
import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;
import org.aeonbits.owner.Converter;
import org.aeonbits.owner.Factory;
import org.aeonbits.owner.loaders.Loader;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public class PropertyFactory {
    public static Factory newInstance() {
        return ConfigFactory.newInstance();
    }

    public static <T extends Config> T create(Class<? extends T> clazz, Map<?, ?>... imports) {
        return ConfigFactory.create(clazz, imports);
    }

    public static String setProperty(String key, String value) {
        return ConfigFactory.setProperty(key, value);
    }

    public static Properties getProperties() {
        return ConfigFactory.getProperties();
    }

    public static void setProperties(Properties properties) {
        ConfigFactory.setProperties(properties);
    }

    public static String getProperty(String key) {
        return ConfigFactory.getProperty(key);
    }

    public static String clearProperty(String key) {
        return ConfigFactory.clearProperty(key);
    }

    public static void registerLoader(Loader loader) {
        ConfigFactory.registerLoader(loader);
    }

    public static void setTypeConverter(Class<?> type, Class<? extends Converter<?>> converter) {
        ConfigFactory.setTypeConverter(type, converter);
    }

    public static void removeTypeConverter(Class<?> type) {
        ConfigFactory.removeTypeConverter(type);
    }

    public static <T extends Config> T createProperty(Class<? extends T> clazz) {

        final Map<Method, PropertyConverterMetadata> methodsForConvert = new HashMap<Method, PropertyConverterMetadata>();

        for (Method method : clazz.getMethods()) {
            if (method.isAnnotationPresent(PropertyConverter.class)) {
                methodsForConvert.put(method, new PropertyConverterHandler().process(method));
            }
        }

        Object interfaceObject = ConfigFactory.create(clazz);
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                PropertyConverterMetadata propertyConverterMetadata = methodsForConvert.get(method);
                if (Objects.nonNull(propertyConverterMetadata)) {
                    Method converterMethod = propertyConverterMetadata.getConverterClass().getDeclaredMethod(propertyConverterMetadata.getConverterMethod(), method.getReturnType());
                    converterMethod.setAccessible(true);
                    return converterMethod.invoke(propertyConverterMetadata.getConverterClass().newInstance(), method.invoke(interfaceObject, args));
                }
                return method.invoke(interfaceObject, args);
            }
        });
    }

    @SneakyThrows
    public static void removeAnnotationFromMethod(Method annotatedMethod, Class<? extends Annotation> annotationType) {
        boolean annotatedMethodAccessible;
        boolean annotationsFieldAccessible;

        annotatedMethodAccessible = annotatedMethod.isAccessible();
        annotatedMethod.setAccessible(true);
        annotatedMethod.getDeclaredAnnotations();

        Field annotations = annotatedMethod.getClass().getSuperclass().getDeclaredField("declaredAnnotations");
        annotationsFieldAccessible = annotations.isAccessible();
        annotations.setAccessible(true);

        ((Map<Class<? extends Annotation>, Annotation>) annotations.get(annotatedMethod)).remove(annotationType);

        annotations.setAccessible(annotationsFieldAccessible);
        annotatedMethod.setAccessible(annotatedMethodAccessible);
    }
}
