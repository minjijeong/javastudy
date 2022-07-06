package util;


public class TestTimeUtils {
    private long startTime;

    private double spendTime;

    public long getStartTime() {
        return this.startTime;
    }

    public double getSpendTime() {
        return (System.currentTimeMillis() - this.startTime) / 1000.0;
    }

    public TestTimeUtils() {
        this.startTime = System.currentTimeMillis();
        printStartTIme();
    }

    public void printSpendTime(){
        printTime(null,"Current");
        printTime(getSpendTime(), "Spend");
    }
    public long getCurrentTime() {
        return System.currentTimeMillis();
    }
    public void printTime( Double time, String prefix){
        if(time == null){
            time = Double.valueOf(getCurrentTime());
        }
        System.out.println(prefix + " Time :: "+time);
    }
    public void printStartTIme(){
        printTime((double) this.startTime, "Start");
    }
}
