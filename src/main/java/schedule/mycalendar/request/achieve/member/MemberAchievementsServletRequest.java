package schedule.mycalendar.request.achieve.member;

import lombok.Data;

import java.util.List;

@Data
public class MemberAchievementsServletRequest {

    private Long memberId;

    private List<MemberDetailAchievementsRequest> achievementsList;

}
