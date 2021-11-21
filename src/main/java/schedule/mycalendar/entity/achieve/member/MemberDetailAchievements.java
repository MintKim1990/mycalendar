package schedule.mycalendar.entity.achieve.member;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    // 양방향 연관관계 설정
    public void setMemberAchievements(MemberAchievements memberAchievements) {
        this.memberAchievements = memberAchievements;
    }
}
