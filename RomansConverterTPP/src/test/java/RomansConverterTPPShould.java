import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomansConverterTPPShould {
    @ParameterizedTest
    @CsvSource({
            "1,I",
            "2,II",
            "3,III",
            "4, IV",
            "5, V",
            "6, VI",
            "7, VII"
    })
    public void convert_arabic_numbers_to_roman_numbers(int arabic, String roman){
        RomansConverterTPP romansConverter = new RomansConverterTPP();
        assertEquals(roman,romansConverter.romanConversion(arabic));
    }

}
