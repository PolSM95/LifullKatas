import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Time;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class OhceShould {

    OutputOhce output;
    TimeServer timeServer;
    Ohce ohce;

    @BeforeEach
    public void initialize(){
        output = mock(OutputOhce.class);
        timeServer = mock(TimeServer.class);
        ohce = new Ohce(output, timeServer,"Pedro");
    }


    @Test
    public void verify_that_console_recieves_welcome_message_between_6_and_12(){

        when(timeServer.getTime()).thenReturn(DayTimes.MAÑANA);

        ohce.checkDayTime("Pedro");

        verify(output).showOutput("¡Buenos días Pedro!");
    }

    @Test
    public void verify_that_console_recieves_welcome_message_between_12_20(){

        when(timeServer.getTime()).thenReturn(DayTimes.TARDE);

        ohce.checkDayTime("Pedro");

        verify(output).showOutput("¡Buenas tardes Pedro!");
    }

    @Test
    public void verify_that_console_recieves_welcome_message_between_20_6(){

        when(timeServer.getTime()).thenReturn(DayTimes.NOCHE);

        ohce.checkDayTime("Pedro");

        verify(output).showOutput("¡Buenas noches Pedro!");
    }

    @Test
    public void verify_that_reverse_the_word_if_not_a_palindrome(){

        ohce.handleWord("roma");

        verify(output).showOutput("amor");
    }

    @Test
    public void verify_that_the_word_is_palindrome(){

        ohce.handleWord("oto");

        verify(output).showOutput("oto");
        verify(output).showOutput("¡Bonita Palabra!");
    }

    @Test
    public void verify_that_the_word_is_Stop(){

        ohce.handleWord("Stop!");

        verify(output).showOutput("Adios Pedro!");
    }

}
