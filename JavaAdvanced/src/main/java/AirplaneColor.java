import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

import java.util.regex.Pattern;

@Log4j2
@Getter
@AllArgsConstructor
public enum AirplaneColor {
    BLACK("#000000", 35) {
        @Override
        public void fade() {
            log.info("Black color fades");
            BLACK.fadePercent /= .5;
        }
    },
    WHITE("#FFFFFF", 15) {
        @Override
        public void fade() {
            log.info("White color fades");
            WHITE.fadePercent *= 3;
        }
    };

    private String colorRGB;
    private int fadePercent;
    private static final String RGB_PATTERN = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$";

    public static boolean validateRGB(String rgb) {
        return Pattern.compile(RGB_PATTERN).matcher(rgb).matches();
    }

    public abstract void fade();
}
