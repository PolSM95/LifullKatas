package app;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

public class copyMockitoShould {
    @Test
    public void check_the_length_of_a_string(){

        Readable readerTest = mock(Readable.class);
        when(readerTest.read()).thenReturn('a').thenReturn('\n');

        Writeable writerTest = mock(Writeable.class);
        Copier copier = new Copier(readerTest,writerTest);
        copier.copy();

        verify(writerTest, never()).write('\n');
        verify(writerTest).write('a');

    }
}
