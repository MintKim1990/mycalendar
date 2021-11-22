package schedule.mycalendar.service.achieve.member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import schedule.mycalendar.entity.achieve.member.MemberDetailAchievements;
import schedule.mycalendar.entity.member.Member;
import schedule.mycalendar.repository.member.MemberRepository;
import schedule.mycalendar.request.achieve.member.MemberAchievementsServletRequest;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberAchievementsService {

    private final MemberRepository memberRepository;
    private final MemberDetailAchievementsService memberDetailAchievementsService;


    public void saveMemberAchievements(MemberAchievementsServletRequest memberAchievementsServletRequest) {

        // 회원정보
        Member member = memberRepository.findById(memberAchievementsServletRequest.getMemberId())
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("회원이 존재하지 않습니다.");
                });

        // 회원 달성내용 생성
        List<MemberDetailAchievements> memberDetailAchievementsList =
                memberDetailAchievementsService.createMemberDetailAchievementsList(
                        memberAchievementsServletRequest
                );

    }


}
