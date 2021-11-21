package schedule.mycalendar.request.achieve.member;

import lombok.Builder;
import lombok.Data;

import java.time.LocalTime;

@Data
public class MemberDetailTimeAchievementsRequest {

    private int activeTime;

    @Builder
    public MemberDetailTimeAchievementsRequest(int activeTime) {
        this.activeTime = activeTime;
    }
}
