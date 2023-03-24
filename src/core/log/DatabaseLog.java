package core.log;

public class DatabaseLog implements  ILog{
    @Override
    public void log(String data) {
        System.out.println("Log by DatabaseLog: " + data);
    }
}
