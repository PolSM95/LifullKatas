package app;



public class Copier {

    Readable readerTest;
    Writeable writeTest;

    public Copier(Readable readerTest, Writeable writeTest) {
        this.readerTest = readerTest;
        this.writeTest = writeTest;
    }

    public void copy() {

        char readChar = readerTest.read();
        while (readChar != '\n'){
            writeTest.write(readChar);
            readChar = readerTest.read();
        }
    }


}
