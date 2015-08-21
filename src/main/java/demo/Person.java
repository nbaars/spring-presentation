package demo;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(makeFinal=true, level= AccessLevel.PRIVATE)
public class Person {

    String firstName;
    String lastName;

}
