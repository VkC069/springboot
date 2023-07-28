package employee.Data.dto;


import lombok.*;

import java.util.UUID;

@Builder
@Setter@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private UUID id;
    private String name;
    private int age;
    private String gender;
    private int salary;


}
