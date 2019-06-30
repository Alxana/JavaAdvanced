import org.apache.commons.lang3.StringUtils;

public class Converters {

    public String toUpperCase(String str) {
        return StringUtils.upperCase(str);
    }

    public String repeatTwice(String str) {
        return StringUtils.repeat(str, 2);
    }
}
