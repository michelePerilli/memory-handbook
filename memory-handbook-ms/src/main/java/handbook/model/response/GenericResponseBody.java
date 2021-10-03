package handbook.model.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface GenericResponseBody {


    public static ResponseEntity<Long> ok() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
