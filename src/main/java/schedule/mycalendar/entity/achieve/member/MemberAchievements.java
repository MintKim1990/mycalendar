package schedule.mycalendar.entity.achieve.member;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import schedule.mycalendar.entity.achieve.cycle.CycleAchievements;
import schedule.mycalendar.entity.constant.Cycle;
import schedule.mycalendar.entity.member.Member;
import schedule.mycalendar.entity.section.Section;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * 사용자별 달성내용
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberAchievements {

    @Id
    @GeneratedValue
    @Column(name = "member_achievements_id")
    private Long id;

    // 회원식별키
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    // 섹션
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sectionCode")
    private Section memberAchievementsSection;

    // 주기별 달성내용
    @OneToMany(mappedBy = "memberAchievements")
    public List<CycleAchievements> cycleAchievementsList = new ArrayList<>();

    private String goal; // 목표
    private LocalDate goalStartDate; // 기간시작일자
    private LocalDate goalEndDate; // 기간시작일자

    @Enumerated(EnumType.STRING)
    private Cycle cycle;
}
