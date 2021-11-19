package schedule.mycalendar.entity.achieve.member;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import schedule.mycalendar.entity.member.Member;

import javax.persistence.*;

/**
 * 사용자별 달성내용 상세 목표
 */
@Entity
@Getter
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class MemberDetailAchievements {

    @Id
    @GeneratedValue
    @Column(name = "member_detail_achievements_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_achievements_id")
    private MemberAchievements memberAchievements;
}
