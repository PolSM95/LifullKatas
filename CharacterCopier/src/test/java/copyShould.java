import app.Copier;
import app.Readable;
import app.Writeable;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class copyShould {

    @Test
    public void check_If_Read_Character_a(){

     ReaderTest readerTest = new ReaderTest("a\n");
     WriterTest writerTest = new WriterTest();
     Copier copier = new Copier(readerTest,writerTest);
     copier.copy();
     assertEquals(1, writerTest.writeResultLength());
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



}