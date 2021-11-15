package schedule.mycalendar.entity.achieve.mapping;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import schedule.mycalendar.entity.constant.Cycle;
import schedule.mycalendar.entity.member.Member;
import schedule.mycalendar.entity.section.Section;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberAchievements {

    @Id
    @GeneratedValue
    @Column(name = "member_achievements_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sectionCode")
    private Section memberAchievementsSection;

    @OneToMany(mappedBy = "memberAchievements")
    public List<MemberAchievements> memberAchievementsList = new ArrayList<>();

    private String goal; // 목표
    private LocalDate goalStartDate; // 기간시작일자
    private LocalDate goalEndDate; // 기간시작일자

    @Enumerated(EnumType.STRING)
    private Cycle cycle;
}
