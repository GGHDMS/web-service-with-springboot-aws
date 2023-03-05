package study.webservice.web.dto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class HelloResponseDtoTest {

    @Test
    public void 기능_테스트() throws Exception{
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        Assertions.assertThat(dto.name()).isEqualTo(name);
        Assertions.assertThat(dto.amount()).isEqualTo(amount);
    }

}