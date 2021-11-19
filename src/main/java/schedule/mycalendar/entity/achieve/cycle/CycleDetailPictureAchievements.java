package schedule.mycalendar.entity.achieve.cycle;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * 세부달성내용 사진
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DiscriminatorValue("Picture")
public class CycleDetailPictureAchievements extends CycleDetailAchievements {

    private String pictureName;

}
