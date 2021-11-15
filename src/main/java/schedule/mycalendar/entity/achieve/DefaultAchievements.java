package schedule.mycalendar.entity.achieve;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import schedule.mycalendar.entity.section.Section;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class DefaultAchievements {

    @Id
    @Column(name = "AchieveMentsCode")
    private String code;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sectionCode")
    private Section defaultAchievementsSection;



}
