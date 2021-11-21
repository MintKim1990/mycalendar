package schedule.mycalendar.entity.achieve.cycle.achievements;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import schedule.mycalendar.entity.achieve.cycle.CycleDetailAchievements;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * 세부달성내용 사진
 */
@Entity
@Getter
@DiscriminatorValue("Picture")
public class CycleDetailPictureAchievements extends CycleDetailAchievements {

    private String pictureName;

    @Builder
    protected CycleDetailPictureAchievements() {}

    public static CycleDetailPictureAchievements createCycleDetailPictureAchievements() {
        return CycleDetailPictureAchievements.builder()
                .build();
    }
}
