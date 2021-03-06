public class InstrumentProcessor {
    private TaskDispatcher taskDispatcher;
    private Instrument instrument;

    public InstrumentProcessor(TaskDispatcher taskDispatcher, Instrument instrument) {
        this.taskDispatcher = taskDispatcher;
        this.instrument = instrument;
    }

    void process(){
        try{
            String task = taskDispatcher.getTask();
            instrument.execute(task);
            taskDispatcher.finishTask(task);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
