package task;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BubleSort bubble = new BubleSort();
        InsertSort insert = new InsertSort();

        Data data = new Data();

        ListTest listTest = new ListTest();
        data = listTest.read(data);

        int sort[];

        long start;
        long finish;
        long elapsed;

        switch (data.getAlgorithm()) {
            case "bubble":

                start = System.currentTimeMillis();

                sort = bubble.sort(data.getValues());
                data.setValues(sort);

                finish = System.currentTimeMillis();
                elapsed = start - finish;

                data.setTime((double) elapsed);
                System.out.println((double) elapsed);


            case "insert":

                start = System.nanoTime();

                sort = insert.sort(data.getValues());
                data.setValues(sort);

                finish = System.nanoTime();
                elapsed = start - finish;

                data.setTime((double) elapsed);
                System.out.println((double) elapsed);


        }

        listTest.write(data);

    }
}
