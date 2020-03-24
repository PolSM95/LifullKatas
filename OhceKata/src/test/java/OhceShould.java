import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class OhceShould {
    @Test
    public void verify_that_console_recieves_welcome_message_between_6_and_12(){

        OutputOhce output = mock(OutputOhce.class);
        TimeServer timeServer = mock(TimeServer.class);
        when(timeServer.getTime()).thenReturn(DayTimes.MAÑANA);
        Ohce ohce = new Ohce(output, timeServer);

        ohce.init("Pedro");

        verify(output).showOutput("¡Buenos días Pedro!");
    }

    @Test
    public void verify_that_console_recieves_welcome_message_between_12_20(){
        OutputOhce output = mock(OutputOhce.class);
        TimeServer timeServer = mock(TimeServer.class);
        when(timeServer.getTime()).thenReturn(DayTimes.TARDE);
        Ohce ohce = new Ohce(output, timeServer);

        ohce.init("Pedro");

        verify(output).showOutput("¡Buenas tardes Pedro!");
    }

    @Test
    public void verify_that_console_recieves_welcome_message_between_20_6(){
        OutputOhce output = mock(OutputOhce.class);
        TimeServer timeServer = mock(TimeServer.class);
        when(timeServer.getTime()).thenReturn(DayTimes.NOCHE);
        Ohce ohce = new Ohce(output, timeServer);

        ohce.init("Pedro");

        verify(output).showOutput("¡Buenas noches Pedro!");
    }

    @Test
    public void verify_that_reverse_the_word_if_not_a_palindrome(){
        OutputOhce output = mock(OutputOhce.class);
        Ohce ohce = new Ohce(output);
        ohce.handleWord("roma");

        verify(output).showOutput("amor");
    }

    @Test
    public void verify_that_the_word_is_palindrome(){
        OutputOhce output = mock(OutputOhce.class);
        Ohce ohce = new Ohce(output);

        ohce.handleWord("oto");

        verify(output).showOutput("oto");
        verify(output).showOutput("¡Bonita Palabra!");
    }

    @Test
    public void verify_that_the_word_is_Stop(){
        OutputOhce output = mock(OutputOhce.class);
        Ohce ohce = new Ohce(output,"Pedro");

        ohce.handleWord("Stop!");

        verify(output).showOutput("Adios Pedro!");
    }

}
