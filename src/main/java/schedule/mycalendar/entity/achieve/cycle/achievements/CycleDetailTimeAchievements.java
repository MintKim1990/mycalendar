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
public class CycleDetailTimeAchievements extends CycleDetailAchievements {

    private int activeTime;

    @Builder
    protected CycleDetailTimeAchievements() {
        this.activeTime = 0;
    }

    public static CycleDetailTimeAchievements createCycleDetailTimeAchievements() {
        return CycleDetailTimeAchievements.builder()
                .build();
    }
}
