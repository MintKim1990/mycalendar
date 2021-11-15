package schedule.mycalendar.entity.achieve.mapping;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CycleAchievements {

    @Id
    @GeneratedValue
    @Column(name = "member_achievements_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_achievements_id")
    private MemberAchievements memberAchievements; // 달성내용
}
