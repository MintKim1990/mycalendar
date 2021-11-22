package schedule.mycalendar.request.achieve.member;

import lombok.Builder;
import lombok.Data;
import org.springframework.util.Assert;
import schedule.mycalendar.entity.constant.Achievements;

@Data
public class MemberDetailTimeAchievementsRequest extends MemberDetailAchievementsRequest {

    private int activeTime;

    @Builder
    public MemberDetailTimeAchievementsRequest(Achievements achievements, Integer activeTime) {

        super(achievements);
        Assert.notNull(activeTime, "활동시간은 필수입니다.");

        this.activeTime = activeTime;
    }
}
