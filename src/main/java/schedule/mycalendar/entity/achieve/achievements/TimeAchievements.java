package schedule.mycalendar.entity.achieve.achievements;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import schedule.mycalendar.entity.achieve.DefaultAchievements;

import javax.persistence.Entity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TimeAchievements extends DefaultAchievements {
}
