package schedule.mycalendar.repository.member;

import org.springframework.data.jpa.repository.JpaRepository;
import schedule.mycalendar.entity.member.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
