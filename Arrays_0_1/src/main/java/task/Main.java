package task;

import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {
        BubbleSort bubbleSort = new BubbleSort();
        int[] array = {1, 3, 2};
        bubbleSort.sort(array);
        InsertSort insertSort = new InsertSort();
        insertSort.sort(array);

        JsonRW jsonRW = new JsonRW();
        jsonRW.jsonWork();
    }
}