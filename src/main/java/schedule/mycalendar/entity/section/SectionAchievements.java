package schedule.mycalendar.entity.section;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import schedule.mycalendar.entity.constant.Achievements;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SectionAchievements {
    @Id
    @Enumerated(EnumType.STRING)
    @Column(name = "achievements_code")
    private Achievements code;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sectionCode")
    private Section section;
}
