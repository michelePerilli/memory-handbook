package handbook.model.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class RapidResponse {

    private final HttpStatus status;


    public RapidResponse(HttpStatus status) {
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }


    public static ResponseEntity<GenericResponseBody> ok() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public static ResponseEntity<GenericResponseBody> ok(GenericResponseBody body) {
        return new ResponseEntity<>(body, HttpStatus.OK);
    }
}
