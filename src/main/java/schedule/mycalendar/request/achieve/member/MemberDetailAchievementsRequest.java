package schedule.mycalendar.request.achieve.member;

import lombok.Data;
import lombok.NoArgsConstructor;
import schedule.mycalendar.entity.constant.Achievements;

import java.util.Arrays;

@Data
@NoArgsConstructor
public class MemberDetailAchievementsRequest {

    private Achievements achievements;

    public MemberDetailAchievementsRequest(Achievements achievements) {

        boolean match = Arrays.stream(Achievements.values()).anyMatch(value -> value.equals(achievements));

        if(match)
            throw new IllegalArgumentException("지원하지 않는 달성내용입니다.");

        this.achievements = achievements;
    }
}
