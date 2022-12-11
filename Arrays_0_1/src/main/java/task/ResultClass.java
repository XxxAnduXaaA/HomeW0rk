package task;

import java.util.Arrays;

public class ResultClass {
    double time;
    int[] values;

    public int[] getValues() {
        return values;
    }

    public void setValues(int[] values) {
        this.values = values;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "ResultClass{" +
                "time=" + time +
                ", values=" + Arrays.toString(values) +
                '}';
    }
}