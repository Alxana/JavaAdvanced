import org.aeonbits.owner.Config;

@Config.Sources("classpath:properties1.properties")
public interface Properties1Interface extends Config {
    @Key("key1")
    @PropertyConverter(converterClass = Converters.class, converterMethod = "toUpperCase")
    String getKey1Value();

    @Key("key2")
    @PropertyConverter(converterClass = Converters.class, converterMethod = "repeatTwice")
    String getKey2Value();
}
