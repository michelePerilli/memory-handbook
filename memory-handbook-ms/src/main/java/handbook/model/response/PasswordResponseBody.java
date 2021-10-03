package handbook.model.response;

import handbook.model.dto.password.RicercaPasswordResponseDto;
import org.springframework.data.domain.Page;

public class PasswordResponseBody implements GenericResponseBody {


    Page<RicercaPasswordResponseDto> responseDtos;

    public PasswordResponseBody() {
    }

    public PasswordResponseBody(Page<RicercaPasswordResponseDto> responseDtos) {
        this.responseDtos = responseDtos;
    }


    public Page<RicercaPasswordResponseDto> getResponseDtos() {
        return responseDtos;
    }

    public void setResponseDtos(Page<RicercaPasswordResponseDto> responseDtos) {
        this.responseDtos = responseDtos;
    }
}
