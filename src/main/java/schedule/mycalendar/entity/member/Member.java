package schedule.mycalendar.entity.member;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import schedule.mycalendar.entity.section.Section;
import schedule.mycalendar.request.member.MemberRequest;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Builder
    private Member(String name) {
        this.name = name;
    }

    /**
     * 회원 생성
     * @param request
     * @return
     */
    public static Member createMember(MemberRequest request) {
        return Member.builder()
                .name(request.getName())
                .build();
    }
}
