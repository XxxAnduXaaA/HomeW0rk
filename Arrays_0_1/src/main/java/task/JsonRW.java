package task;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.File;
import java.io.IOException;

public class JsonRW {
    ObjectMapper objectMapper = new ObjectMapper();

    public void jsonWork() throws IOException {
        File file = new File("C:\\Users\\admin\\IdeaProjects\\HomeW0rk\\Arrays_0_1\\src\\main\\java\\resources\\array.json");
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Data dataClass = objectMapper.readValue(file, Data.class);

        ResultClass resultClass = new ResultClass();
        BubbleSort bubbleSort = new BubbleSort();
        InsertSort insertSort = new InsertSort();
        if (dataClass.values == null) {
            Error error = new Error("Array is null");
            String json = objectMapper.writeValueAsString(error);
            System.out.println(json);
        }else{
            if(dataClass.algorithm.equals("bubble")){
                double startTime = System.nanoTime();
                bubbleSort.sort(dataClass.values);
                double elapsedTime = System.nanoTime() - startTime;
                resultClass.setTime(elapsedTime / 100000);
                resultClass.setValues(bubbleSort.sort(dataClass.values));
                String json = objectMapper.writeValueAsString(resultClass);
                System.out.println(json);
            }
            if (dataClass.algorithm.equals("insert")) {
                double startTime = System.nanoTime();
                insertSort.sort(dataClass.values);
                double elapsedTime = System.nanoTime() - startTime;
                resultClass.setTime(elapsedTime / 100000);
                resultClass.setValues(insertSort.sort(dataClass.values));
                String json = objectMapper.writeValueAsString(resultClass);
                System.out.println(json);
            }

        }



    }
}
