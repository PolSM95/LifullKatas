import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class InstrumentProcessorShould {
    @Test
    public void verify_processed_task() {
        TaskDispatcher taskDispatcher = mock(TaskDispatcher.class);
        when(taskDispatcher.getTask()).thenReturn("Task 1");
        Instrument instrument = mock(Instrument.class);
        InstrumentProcessor instrumentProcessor = new InstrumentProcessor(taskDispatcher,instrument);
        instrumentProcessor.process();
        verify(instrument).execute("Task 1");
        verify(taskDispatcher).finishTask("Task 1");
    }

}
