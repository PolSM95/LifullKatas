import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomansConverterShould {
    @ParameterizedTest
    @CsvSource({
            "1,I",
            "2,II",
            "3,III"
    })
    public void convert_arabic_numbers_to_roman_numbers(int arabic, String roman){
        RomansConverter romansConverter = new RomansConverter();
        assertEquals(roman,romansConverter.romanConversion(arabic));
    }

}
