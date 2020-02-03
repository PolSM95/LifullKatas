import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomansConverterShould {
    @Test
    public void convert_arabic_numbers_to_roman_numbers(){
        RomansConverter romansConverter = new RomansConverter();
        assertEquals("I",romansConverter.romanConversion(1));
    }

}
