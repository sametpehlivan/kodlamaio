package core.log;

public class ConsoleLog implements ILog{
    @Override
    public void log(String data) {
        System.out.println("Log by ConsoleLog: " + data);
    }
}
