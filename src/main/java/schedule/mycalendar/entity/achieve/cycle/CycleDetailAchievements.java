package schedule.mycalendar.entity.achieve.cycle;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 세부달성내용
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class CycleDetailAchievements {

    @Id
    @GeneratedValue
    @Column(name = "cycle_detail_achievements_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cycle_achievements_id")
    private CycleAchievements cycleAchievements; // 주기별 달성내용



}
