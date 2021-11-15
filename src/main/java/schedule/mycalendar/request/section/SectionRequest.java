package schedule.mycalendar.request.section;

import lombok.Builder;
import lombok.Data;
import org.springframework.util.Assert;

import javax.validation.constraints.NotBlank;

@Data
public class SectionRequest {

    @NotBlank(message = "섹션코드는 필수입니다.")
    private String code;

    @NotBlank(message = "섹션이름은 필수입니다.")
    private String name;

    @Builder
    public SectionRequest(String code, String name) {

        Assert.hasText(code, "섹션코드는 필수입니다.");
        Assert.hasText(name, "섹션이름은 필수입니다.");

        this.code = code;
        this.name = name;
    }
}
