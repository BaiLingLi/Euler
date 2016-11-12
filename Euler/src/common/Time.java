package common;

public class Time {

    private long start;

    public static Time newInstance() {
        return new Time();
    }

    public void start() {
        start = System.nanoTime();
    }

    public void end() {
        System.out.println("処理時間: " + ((double) (System.nanoTime() - start) / 1000000) + "ミリ秒");
    }

    public double end2() {
        return ((double) (System.nanoTime() - start) / 1000000);
    }
}
