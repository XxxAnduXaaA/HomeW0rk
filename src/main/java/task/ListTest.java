package task;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class ListTest {
    ObjectMapper mapper = new ObjectMapper();


     Data read(Data data) throws IOException {

        File file = new File("C:\\Users\\admin\\IdeaProjects\\HomeW0rk\\src\\main\\java\\resources\\array.json");

        data = mapper.readValue(file, Data.class);
//        for (int value : data.getValues()) {
//            System.out.print(value + " ");
//        }


        return data;

    }

    void write(Data data) throws JsonProcessingException {

         String json = mapper.writeValueAsString(data);
         System.out.println(json);

    }

//    static class Data {
//        @JsonProperty("algorithm")
//        public String algorithm;
//        @JsonProperty("values")
//        int[] values;
//
//
//    }
}
