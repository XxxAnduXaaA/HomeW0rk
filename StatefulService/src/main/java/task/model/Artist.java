package task.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Artist {

   private static final String NAME_COLUMN = "name";


    private Long id;

    private String name;
}