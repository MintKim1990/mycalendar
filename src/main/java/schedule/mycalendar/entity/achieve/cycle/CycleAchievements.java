package schedule.mycalendar.entity.achieve.cycle;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import schedule.mycalendar.entity.achieve.member.MemberAchievements;
import schedule.mycalendar.request.achieve.cycle.CycleAchievementsRequest;

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

    @OneToMany(mappedBy = "cycleAchievements", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CycleDetailAchievements> cycleDetailAchievementsList = new ArrayList<>();

    private LocalDateTime startTime; // 시작일자
    private LocalDateTime endTime; // 종료일자
    private String success; // 성공여부

    // 양방향 연관관계
    public void setMemberAchievements(MemberAchievements memberAchievements) {
        this.memberAchievements = memberAchievements;
    }

    @Builder
    private CycleAchievements(LocalDateTime startTime, LocalDateTime endTime, String success, List<CycleDetailAchievements> cycleDetailAchievementsRequestList) {

        this.startTime = startTime;
        this.endTime = endTime;
        this.success = success;

        // 양방향 연관관계 설정
        for (CycleDetailAchievements cycleDetailAchievements : cycleDetailAchievementsRequestList) {
            cycleDetailAchievementsList.add(cycleDetailAchievements);
            cycleDetailAchievements.setCycleAchievements(this);
        }        
    }

    public static CycleAchievements createCycleAchievements(CycleAchievementsRequest cycleAchievementsRequest) {
        return CycleAchievements.builder()
                .startTime(cycleAchievementsRequest.getStartTime())
                .endTime(cycleAchievementsRequest.getEndTime())
                .success("N")
                .cycleDetailAchievementsRequestList(cycleAchievementsRequest.getCycleDetailAchievementsList())
                .build();
    }
}
