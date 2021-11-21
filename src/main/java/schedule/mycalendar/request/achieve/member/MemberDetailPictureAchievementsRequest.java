package schedule.mycalendar.request.achieve.member;

import lombok.Builder;
import lombok.Data;

@Data
public class MemberDetailPictureAchievementsRequest {

    private String pictureName;

    @Builder
    public MemberDetailPictureAchievementsRequest(String pictureName) {
        this.pictureName = pictureName;
    }

}
