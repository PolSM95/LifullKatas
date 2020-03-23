import app.Copier;
import app.Readable;
import app.Writeable;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class copyShould {

    @Test
    public void check_the_length_of_a_string(){

     ReaderTest readerTest = new ReaderTest("a\n");
     WriterTest writerTest = new WriterTest();
     Copier copier = new Copier(readerTest,writerTest);
     copier.copy();
     assertEquals(1, writerTest.writeResultLength());
    }

    @Test
    public void returning_a_string_when_endOfLine_is_at_the_end(){
        ReaderTest readerTest = new ReaderTest("abcd\n");
        WriterTest writerTest = new WriterTest();
        Copier copier = new Copier(readerTest,writerTest);
        copier.copy();
        assertEquals("abcd", writerTest.getWriteResult());
    }
    @Test
    public void returning_empty_string_when_endOfLine_is_at_the_beginning(){
        ReaderTest readerTest = new ReaderTest("\newq");
        WriterTest writerTest = new WriterTest();
        Copier copier = new Copier(readerTest,writerTest);
        copier.copy();
        assertEquals("", writerTest.getWriteResult());
    }

    @Test
    public void returning_a_string_when_endOfLine_is_in_the_middle(){
        ReaderTest readerTest = new ReaderTest("co\nrona");
        WriterTest writerTest = new WriterTest();
        Copier copier = new Copier(readerTest,writerTest);
        copier.copy();
        assertEquals("co", writerTest.getWriteResult());
    }


}

 class ReaderTest implements Readable {

    char[] readInit;
    int actualIndex;

     public ReaderTest(String readInitString) {
         this.readInit = readInitString.toCharArray();
         actualIndex = 0;
     }

     @Override
    public char read() {
        char auxiliarChar =readInit[actualIndex];
        actualIndex ++;
        return auxiliarChar;
    }

}

class WriterTest implements Writeable {

    String writeResult = "";

    @Override
    public void write(char character) {

        writeResult += character;

    }

    public int writeResultLength(){
        return writeResult.length();
    }

    public String getWriteResult(){

        return writeResult;
    }



}