package schedule.mycalendar.entity.achieve.achievements;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import schedule.mycalendar.entity.section.DefaultAchievements;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * 세부달성내용 사진
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DiscriminatorValue("Picture")
public class PictureAchievements extends DefaultAchievements {

    private String pictureName;

}
