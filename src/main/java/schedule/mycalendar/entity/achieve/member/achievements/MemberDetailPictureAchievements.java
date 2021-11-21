package schedule.mycalendar.entity.achieve.member.achievements;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import schedule.mycalendar.entity.achieve.member.MemberDetailAchievements;
import schedule.mycalendar.request.achieve.member.MemberDetailPictureAchievementsRequest;

import javax.persistence.*;

/**
 * 사용자별 달성내용 상세 목표 - 사진
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DiscriminatorValue("Picture")
public class MemberDetailPictureAchievements extends MemberDetailAchievements {

    private String pictureName;

    @Builder
    private MemberDetailPictureAchievements(String pictureName) {
        this.pictureName = pictureName;
    }

    public static MemberDetailPictureAchievements createMemberDetailPictureAchievements(MemberDetailPictureAchievementsRequest memberDetailPictureAchievementsRequest) {
        return MemberDetailPictureAchievements.builder()
                .pictureName(memberDetailPictureAchievementsRequest.getPictureName())
                .build();
    }
}
