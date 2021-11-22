package schedule.mycalendar.request.achieve.member;

import lombok.Builder;
import lombok.Data;
import org.springframework.util.Assert;
import schedule.mycalendar.entity.constant.Achievements;

@Data
public class MemberDetailPictureAchievementsRequest extends MemberDetailAchievementsRequest {

    private String pictureName;

    @Builder
    public MemberDetailPictureAchievementsRequest(Achievements achievements, String pictureName) {

        super(achievements);
        Assert.hasText(pictureName, "사진이름은 필수입니다.");

        this.pictureName = pictureName;
    }
}
