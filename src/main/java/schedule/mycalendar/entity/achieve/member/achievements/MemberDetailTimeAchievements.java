package schedule.mycalendar.entity.achieve.member.achievements;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import schedule.mycalendar.entity.achieve.member.MemberDetailAchievements;
import schedule.mycalendar.request.achieve.member.MemberDetailTimeAchievementsRequest;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * 사용자별 달성내용 상세 목표 - 사진
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DiscriminatorValue("Picture")
public class MemberDetailTimeAchievements extends MemberDetailAchievements {

    private int activeTime;

    @Builder
    private MemberDetailTimeAchievements(int activeTime) {
        this.activeTime = activeTime;
    }

    public static MemberDetailTimeAchievements createMemberDetailPictureAchievements(MemberDetailTimeAchievementsRequest memberDetailTimeAchievementsRequest) {

        if(memberDetailTimeAchievementsRequest.getActiveTime() < 0 || memberDetailTimeAchievementsRequest.getActiveTime() > 24)
            throw new IllegalArgumentException("목표시간은 24시간 이내입니다.");

        return MemberDetailTimeAchievements.builder()
                .activeTime(memberDetailTimeAchievementsRequest.getActiveTime())
                .build();
    }
}
