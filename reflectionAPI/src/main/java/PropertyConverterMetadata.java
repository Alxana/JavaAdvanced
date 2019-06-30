import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PropertyConverterMetadata {
    private Class converterClass;
    private String converterMethod;
}
