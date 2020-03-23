package app;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

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

    @Test
    public void returning_a_string_when_endOfLine_is_at_the_end(){
        Readable readerTest = mock(Readable.class);
        when(readerTest.read()).thenReturn('a')
                .thenReturn('b')
                .thenReturn('c')
                .thenReturn('d')
                .thenReturn('\n');

        Writeable writerTest = mock((Writeable.class));
        Copier copier = new Copier(readerTest,writerTest);
        copier.copy();

        InOrder inOrder = inOrder(writerTest);

        inOrder.verify(writerTest).write('a');
        inOrder.verify(writerTest).write('b');
        inOrder.verify(writerTest).write('c');
        inOrder.verify(writerTest).write('d');
        verify(writerTest, never()).write('\n');
    }

    @Test
    public void returning_empty_string_when_endOfLine_is_at_the_beginning(){
        Readable readerTest = mock(Readable.class);
        when(readerTest.read()).thenReturn('\n')
                .thenReturn('e')
                .thenReturn('w')
                .thenReturn('q');

        Writeable writerTest = mock((Writeable.class));
        Copier copier = new Copier(readerTest,writerTest);
        copier.copy();

        verify(writerTest, never()).write(anyChar());
    }


}
