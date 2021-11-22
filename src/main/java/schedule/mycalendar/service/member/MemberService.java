package schedule.mycalendar.service.member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import schedule.mycalendar.entity.member.Member;
import schedule.mycalendar.repository.member.MemberRepository;
import schedule.mycalendar.request.member.MemberRequest;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void saveMember(MemberRequest memberRequest) {
        Member member = Member.createMember(memberRequest);
        memberRepository.save(member);
    }

}
