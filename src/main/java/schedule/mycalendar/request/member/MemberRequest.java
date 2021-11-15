package schedule.mycalendar.request.member;

import lombok.Builder;
import lombok.Data;
import schedule.mycalendar.entity.member.Member;

@Data
public class MemberRequest {

    private String name;

    @Builder
    public MemberRequest(String name) {
        this.name = name;
    }

}
