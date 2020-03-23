import app.Copier;
import app.Readable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class copyShould {

    @Test
    public void check_If_Read_Character_a(){
     Copier copier = new Copier();
     Reader reader = new Reader();
     copier.copy();
     assertEquals('a',reader.read());
    }

}


class Reader implements Readable {

    @Override
    public char read() {
        return 'a';
    }

}