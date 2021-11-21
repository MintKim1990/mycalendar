package schedule.mycalendar.entity.achieve.member;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.dialect.MySQL5InnoDBDialect;
import schedule.mycalendar.entity.achieve.cycle.CycleAchievements;
import schedule.mycalendar.entity.constant.Cycle;
import schedule.mycalendar.entity.member.Member;
import schedule.mycalendar.entity.section.Section;
import schedule.mycalendar.request.achieve.member.MemberAchievementsRequest;


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
    @OneToMany(mappedBy = "memberAchievements", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<CycleAchievements> cycleAchievementsList = new ArrayList<>();

    private String goal; // 목표
    private LocalDate goalStartDate; // 기간시작일자
    private LocalDate goalEndDate; // 기간시작일자

    @Enumerated(EnumType.STRING)
    private Cycle cycle;

    @OneToMany(mappedBy = "memberAchievements", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<MemberDetailAchievements> memberDetailAchievementsList = new ArrayList<>();

    @Builder
    private MemberAchievements(Member member, Section memberAchievementsSection, List<CycleAchievements> cycleAchievementsRequestList,
                               String goal, LocalDate goalStartDate, LocalDate goalEndDate, Cycle cycle,
                               List<MemberDetailAchievements> memberDetailAchievementsRequestList) {
        this.member = member;
        this.memberAchievementsSection = memberAchievementsSection;
        this.goal = goal;
        this.goalStartDate = goalStartDate;
        this.goalEndDate = goalEndDate;
        this.cycle = cycle;

        // 양방향관계 설정
        for (CycleAchievements cycleAchievements : cycleAchievementsRequestList) {
            cycleAchievementsList.add(cycleAchievements);
            cycleAchievements.setMemberAchievements(this);
        }

        // 양방향관계 설정
        for (MemberDetailAchievements memberDetailAchievements : memberDetailAchievementsRequestList) {
            memberDetailAchievementsList.add(memberDetailAchievements);
            memberDetailAchievements.setMemberAchievements(this);
        }

    }

    public static MemberAchievements createMemberAchievements(MemberAchievementsRequest memberAchievementsRequest) {
        return MemberAchievements.builder()
                .member(memberAchievementsRequest.getMember())
                .memberAchievementsSection(memberAchievementsRequest.getMemberAchievementsSection())
                .cycleAchievementsRequestList(memberAchievementsRequest.getCycleAchievementsRequestList())
                .goal(memberAchievementsRequest.getGoal())
                .goalStartDate(memberAchievementsRequest.getGoalStartDate())
                .goalEndDate(memberAchievementsRequest.getGoalEndDate())
                .cycle(memberAchievementsRequest.getCycle())
                .memberDetailAchievementsRequestList(memberAchievementsRequest.getMemberDetailAchievementsRequestList())
                .build();
    }
}
