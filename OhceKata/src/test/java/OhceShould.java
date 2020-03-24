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
    public void verify_that_reverse_works(){
        OutputOhce output = mock(OutputOhce.class);
        Ohce ohce = new Ohce(output);
        ohce.reverse("roma");

        verify(output).showOutput("amor");
    }

}
