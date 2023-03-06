package data;

import lombok.Data;
import lombok.NoArgsContructor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
public class data {

    public ResponseDTO(HttpStatus status, T data) {
        this.data = data;
        this.status = status.value();
        this.message = status.getReasonPhrase();
        this.httpStatus = status;
    }

    private T data;
    private Integer status;
    private String message;
    @JsonIgnore
    private HttpStatus httpStatus;
}
