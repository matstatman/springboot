package springboot.controllers.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

@Data
@Builder
@JsonInclude(NON_EMPTY)
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MyResponseV1 {
    private String text;
}
