package schedule.mycalendar.entity.achieve.cycle;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import schedule.mycalendar.entity.achieve.member.MemberAchievements;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 주기별 달성내용
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CycleAchievements {

    @Id
    @GeneratedValue
    @Column(name = "cycle_achievements_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_achievements_id")
    private MemberAchievements memberAchievements; // 달성내용

    @OneToMany(mappedBy = "cycleAchievements")
    private List<CycleDetailAchievements> cycleDetailAchievementsList = new ArrayList<>();

    private LocalDateTime startTime; // 시작일자
    private LocalDateTime endTime; // 종료일자
    private String success; // 성공여부
}
